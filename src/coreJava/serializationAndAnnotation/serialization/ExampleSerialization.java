package coreJava.serializationAndAnnotation.serialization;

import java.io.*;
import java.lang.reflect.Field;
import java.util.StringJoiner;

public class ExampleSerialization {

    private static final int LOCAL_INTEGER = 10;
    private static final int INNER_INTEGER = 20;

    public static void main(String[] args) throws Exception {

        byte[] bytes;

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutput objectOutput = new ObjectOutputStream(byteArrayOutputStream)) {
            System.out.println("Prepare objects...");
            MyInnerClass myInnerClass = new MyInnerClass();
            myInnerClass.setAnInt(INNER_INTEGER);
            MyClass myClass = new MyClass();
            myClass.setAnInt(LOCAL_INTEGER);
            myClass.setMyInnerClass(myInnerClass);

            System.out.println("Serialize...");
            objectOutput.writeObject(myClass);
            bytes = byteArrayOutputStream.toByteArray();
        }

        try (ObjectInput objectInput = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
            System.out.println("Deserialize...");
            MyClass myClass = (MyClass) objectInput.readObject();
            System.out.println(myClass);
            System.out.println("Ожидаемый результат: переменная объекта - " + LOCAL_INTEGER + " переменная внутреннего класса - " + INNER_INTEGER);
        }

    }
}

class MyClass implements Externalizable {
    private int anInt;
    private transient MyInnerClass myInnerClass;
    private int myInnerClassIntField;

    public MyClass() {
        System.out.println("MyClass()");
    }

    public void setAnInt(int anInt) {
        System.out.println("MyClass.setAnInt(" + anInt + ")");
        this.anInt = anInt;
    }

    public void setMyInnerClass(MyInnerClass myInnerClass) {
        System.out.println("MyClass.setMyInnerClass()");
        this.myInnerClass = myInnerClass;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MyClass.class.getSimpleName() + "[", "]")
                .add("anInt=" + anInt)
                .add("myInnerClass=" + myInnerClass)
                .toString();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        System.out.println("MyClass.writeInt");
        out.writeInt(anInt);

        Class<?> reflectClass = myInnerClass.getClass();
        Field[] fields = reflectClass.getDeclaredFields();
        for (Field field: fields) {
            field.setAccessible(true);
            if(field.getType().isPrimitive() && field.getName().equals("anInt")) {
                try {
                    System.out.println("MyClass.writeObject");
                    myInnerClassIntField = field.getInt(myInnerClass);
                    out.write(myInnerClassIntField);
                } catch (IllegalAccessException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        System.out.println("MyClass.readInt");
        anInt = in.readInt();
        myInnerClassIntField = in.read();

        myInnerClass = new MyInnerClass();
        myInnerClass.setAnInt(myInnerClassIntField);
    }
}

final class MyInnerClass {
    private int anInt;

    public MyInnerClass() {
        System.out.println("MyInnerClass()");
    }

    public void setAnInt(int anInt) {
        System.out.println("MyInnerClass.setAnInt(" + anInt + ")");
        this.anInt = anInt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MyInnerClass.class.getSimpleName() + "[", "]")
                .add("anInt=" + anInt)
                .toString();
    }
}

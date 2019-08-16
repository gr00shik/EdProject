package javaFundomentals.serializationAndAnnotation.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/*
    Эксперимент по созданию собственной сериализации
    класс с кастомной сериализацией должен использовать интерфейс Externalizable
    и переопределить 2 метода с входным параметром ObjectOutput и ObjectInput - интерфейсы
    в них можно положить любой поток и использовать как угодно

    FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

 */

public class CustomSerialization implements Externalizable {

    private String key;
    private String value;

    public CustomSerialization() {
        this.key = null;
        this.value = null;
    }

    public CustomSerialization(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "key: " + key + " value: " + value;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("custom objectOutput");
        out.writeUTF(key);
        out.writeUTF(value);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("custom objectInput");
        this.key = in.readUTF();
        this.value = in.readUTF();
    }

}

class CustomSerialization_Main {
    private static final String FILE_PATH = "src\\javaFundomentals\\serializationAndAnnotation\\jsave.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CustomSerialization classObject = new CustomSerialization("key", "value");
        System.out.println(classObject.toString());

        // Serialize the pair to a file.
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        classObject.writeExternal(objectOutputStream);

        // Close all resources.
        objectOutputStream.close();
        fileOutputStream.close();

        // Read the contents from the file and create a new instance.
        CustomSerialization emptyClassObject = new CustomSerialization();

        FileInputStream inputStream = new FileInputStream(FILE_PATH);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        emptyClassObject.readExternal(objectInputStream);

        // Close all resources.
        objectInputStream.close();
        inputStream.close();

        System.out.println("After de-serialization: " + emptyClassObject.toString());
    }
}

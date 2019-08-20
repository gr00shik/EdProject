package coreJava.serializationAndAnnotation.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
*   Наблюдения за тем, как ведет себя класс родитель по отношению к классу потомку при сериализации
*
*   В случае если родитель не сериализован:
*       сериализация потомка:
*           создание объекта потомка перед сериализацией:
*               конструктор без параметров родителя
*               конструктор потомка
*           после десериализации
*               конструктор родителя
*
*   В СЛУЧАЕ ЕСЛИ СЕРИАЛИЗОВАН РОДИТЕЛЬ ПОТОМОК БУДЕТ ПО ДЕФОЛТУ СЕРИАЛИЗОВАН
*       сериализация потомка в таком случае:
*           создание объекта потомка перед сериализацией
*               конструктор без параметров родителя
*               конструктор потомка
*           после десериализации
*               (ничего не произойдет, будет выстроен объект у которого все будет воссоздано)
*
*   В случае если потомок не хочет поддерживать сериализацию родителя, он должен переопределять метод
        private void writeObject(ObjectOutputStream out) throws NotSerializableException {
            throw new NotSerializableException("This object can't be sirealizable");
        }
*   И исключение будет вбразываьтся каждый раз при попытке сериализовать объект
*/

//Parent class
public class ParentChildSerialization implements Serializable{

    String value;

    ParentChildSerialization(){
        System.out.println("No param parent constructor");
        value = "no param";
    }

}

class Child extends ParentChildSerialization {

    String childValue;

    Child(String value){
        System.out.println("Param child constructor");
        this.childValue = value;
    }

    Child(){
        System.out.println("No param child constructor");
        this.value = null;
    }

    void printParentField(){
        System.out.println(super.value);
    }

    public void setChildValue(String childValue) {
        this.childValue = childValue;
    }

    public String getChildValue() {
        System.out.println(childValue);
        return childValue;
    }

}

class ParentChildSerialization_Main{
    private static final String FILE_PATH = "src\\coreJava\\serializationAndAnnotation\\jsave.ser";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        Child child = new Child("value");
        child.printParentField();
        child.setChildValue("newTestValue");
        child.getChildValue();

        objectOutputStream.writeObject(child);

        fileOutputStream.close();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        //Child newChild = (Child) objectInputStream.readObject();
        //newChild.printParentField();
        //newChild.getChildValue();

        fileInputStream.close();
        objectInputStream.close();
    }
}
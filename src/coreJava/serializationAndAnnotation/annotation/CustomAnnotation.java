package coreJava.serializationAndAnnotation.annotation;

import coreJava.serializationAndAnnotation.SwitcherRoles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
* Класс создания собственной аннотации
*/

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
    //Поля которые будут указаны в аннотации будут использоваться при использовании аннотации
    //int i(); будет использоваться как @Description(i=100)
    //можно указывать default значение переменной в случае если она не будет указана
    String title() default "default title";
    SwitcherRoles role();
}

class Factory implements Serializable {
    private static final String FILE_PATH = "src\\coreJava\\serializationAndAnnotation\\jsave.ser";
    private boolean factoryMachineOneState;
    private boolean factoryMachineTwoState;

    @CustomAnnotation(role = SwitcherRoles.ON)
    private void factoryMachineOne(){
        System.out.println("it was factoryMachineOne");
    }

    @CustomAnnotation(role = SwitcherRoles.OFF)
    private void factoryMachineTwo(){
        System.out.println("it was factoryMachineTwo");
    }

    public void runOnMachines(Factory factory) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        //Рефлексия - это средство позволяющее получить информацию о классе во время выполнения программы.
        Class<?> customClass = Factory.class;

        //Получение всех полей с помощью рефлексии
        Method[] methods = customClass.getDeclaredMethods();
        for (Method method: methods) {

            //Можно проверить содержит ли метод аннотацию
            if(method.isAnnotationPresent(CustomAnnotation.class)){

                CustomAnnotation annotation = method.getDeclaredAnnotation(CustomAnnotation.class);

                if(annotation.role().equals(SwitcherRoles.ON)){
                    //Получение приватного поля с помощью рефлекции
                    Field field = customClass.getDeclaredField(method.getName() + "State");

                    if(!field.getBoolean(factory)){
                        field.setAccessible(true);
                        field.set(factory, true);

                        method.invoke(factory);
                    }
                }
            }
        }
    }

    public void saveFactoryStates(Factory factory) throws IOException {
        //создаем 2 потока для сериализации объекта и сохранения его в файл
        FileOutputStream outputStream = new FileOutputStream(FILE_PATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // сохраняем игру в файл
        objectOutputStream.writeObject(factory);

        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();
    }

    public Factory loadFactoryStates() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH));
        return (Factory) objectInputStream.readObject();
    }
}

class SimplyAnnotation_Main{
    public static void main(String[] args){
        Factory factory = new Factory();
        try {
            factory.runOnMachines(factory);
            factory.saveFactoryStates(factory);
            Factory factory1 = factory.loadFactoryStates();

            //return false
            factory1.equals(factory);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchFieldException | IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
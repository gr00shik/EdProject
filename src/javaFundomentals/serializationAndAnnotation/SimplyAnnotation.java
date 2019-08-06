package javaFundomentals.serializationAndAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SimplyAnnotation   {
    //Поля которые будут указаны в аннотации будут использоваться при использовании аннотации
    //int i(); будет использоваться как @Description(i=100)
    //можно указывать default значение переменной в случае если она не будет указана
    String title() default "default title";
    SwitcherRoles role();
}

class Factory{
    private boolean factoryMachineOneState;
    private boolean factoryMachineTwoState;

    @SimplyAnnotation(role = SwitcherRoles.ON)
    private void factoryMachineOne(){
        System.out.println("it was factoryMachineOne");
    }

    @SimplyAnnotation(role = SwitcherRoles.OFF)
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
            if(method.isAnnotationPresent(SimplyAnnotation.class)){

                SimplyAnnotation annotation = method.getDeclaredAnnotation(SimplyAnnotation.class);

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

}

class SimplyAnnotation_Main{
    public static void main(String[] args){
        Factory factory = new Factory();
        try {
            factory.runOnMachines(factory);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchFieldException e) {
            System.out.println(e.getMessage());
        }
    }
}
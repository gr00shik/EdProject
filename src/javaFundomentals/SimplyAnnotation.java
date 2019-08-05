package javaFundomentals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
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

    enum SwitcherRoles{
        ON,
        OFF;
    }
}

class Factory{
    @SimplyAnnotation(role = SimplyAnnotation.SwitcherRoles.ON)
    public void factoryMachineOne(){
        System.out.println("it was factoryMachineOne");
    }

    @SimplyAnnotation(role = SimplyAnnotation.SwitcherRoles.OFF)
    public void factoryMachineTwo(){
        System.out.println("it was factoryMachineTwo");
    }

    public void runOnMachines(Factory factory) throws InvocationTargetException, IllegalAccessException {
        Class<?> customClass = Factory.class;

        Method[] methods = customClass.getMethods();
        for (Method method: methods) {

            //Можно проверить содержит ли метод аннотацию
            if(method.isAnnotationPresent(SimplyAnnotation.class)){

                SimplyAnnotation annotation = method.getAnnotation(SimplyAnnotation.class);

                if(annotation.role().equals(SimplyAnnotation.SwitcherRoles.ON)){
                    method.invoke(factory);

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
        } catch (InvocationTargetException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
package javaFundomentals;

/*
* Класс был создан для просмотра функционала создания полиморфных методов в интерфейсах и абстрактных классах:
*
* в абстрактных классах реализуется через обычный метод имеющий реализацию и содержащие внутри абстрактные методы
* в интерфейсах реализуется через default void метод
*/

public abstract class Abstraction_VS_Interface {

    public void inMethod(){
        System.out.println("Abstract)");
        overrider();
    }

    public abstract void overrider();
}

interface Opposite{
    default void secInMethod() {
        System.out.println("Interface)");
        secOverrider();
    }

    void secOverrider();
}

class ClassHeirOne extends Abstraction_VS_Interface implements Opposite{

    @Override
    public void overrider() {
        System.out.println("ClassHeirOne");
    }

    @Override
    public void secOverrider() {
        System.out.println("ClassHeirOne");
    }
}

class ClassHeirTwo extends Abstraction_VS_Interface implements Opposite{

    @Override
    public void overrider() {
        System.out.println("ClassHeirTwo");
    }

    @Override
    public void secOverrider() {
        System.out.println("ClassHeirTwo");
    }
}

class Main {
    public static void main(String[] args){

    }
}

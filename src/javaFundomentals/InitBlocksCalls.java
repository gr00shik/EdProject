package javaFundomentals;

/*
* Класс был создан для игры с вызовами блоков инициализации:
* в классе высшего уровня                               (статический блок, нестатичский блок, конструктор)
* вложенном классе                                      (статический блок вложенного, нестатичский блок вложенного, конструктор вложенного, полносьтю не трогая класс выше)
* в статическом вложенном классе                        ((нестатический блок, конструктор) x столько раз сколько переменных в enum, статический блок инициализации)
* при вызове переменной статического класса             (ничего)
* при вызове статического метода в статическом классе   (статический блок инициализации статического класса, статический метод)
* при вызове статического метода в НЕстатическом классе (статический блок инициализации статического класса, статический метод)
* при вызове статического метода внутри которого есть
*   нестатический                                       (статический блок инициализации, статический метод, не статический метод)
* при вызове статического метода внутри которого создается объекта класса
*   и вызывается его нестатический сетод                (статический блок инициализации, статический метод, нестатический блок инициализации, конструктор, нестатический метод)
*/

public class InitBlocksCalls {
    {
        System.out.println("Обычный блок инициализации");
    }

    static {
        System.out.println("Статический блок инициализации");
    }

    InitBlocksCalls(){
        System.out.println("Конструктор");
    }

    public static void staticMethodInNonStaticClass(){
        System.out.println("staticMethodInNonStaticClass");
        new InitBlocksCalls().nonStaticMethodInNonStaticClass();
    }

    public void nonStaticMethodInNonStaticClass(){
        System.out.println("nonStaticMethodInNonStaticClass");
    }

    private static class StaticClass{
        static final int INTEGER = 3;

        {
            System.out.println("Нестатический блок инициализации в статическом классе");
        }
        static {
            System.out.println("Статический блок инициализации в статическом классе");
        }

        StaticClass(){
            System.out.println("Конструктор статического класса");
        }

        public static void staticMethodInStaticClass(){
            System.out.println("nonStaticMethodInStaticClass");
        }

    }

    enum Enum{
        MERCURY (3.303e+23),
        VENUS   (4.869e+24, 6.0518e6),
        EARTH   (5.976e+24, 6.37814e6),
        MARS    (6.421e+23, 3.3972e6),
        JUPITER (1.9e+27,   7.1492e7),
        SATURN  (5.688e+26, 6.0268e7),
        URANUS  (8.686e+25, 2.5559e7),
        NEPTUNE (1.024e+26, 2.4746e7);

        static {
            System.out.println("static init block enum");
        }

        {
            System.out.println("non static init block enum");
        }

        Enum(double v, double v1) {
            System.out.println("2 param");
        }

        Enum(double v1) {
            System.out.println("1 param");
        }
    }
}

class StaticInvokersMain{
    public static void main(String[] args){
        System.out.println("Отработал мэйн");
        //StaticInvokers.Enum object = StaticInvokers.Enum.EARTH;
        //StaticInvokers si = new StaticInvokers();
        //StaticInvokers.StaticClass object = new StaticInvokers.StaticClass();
        //System.out.println(INTEGER);
        //StaticInvokers.StaticClass.staticMethodInStaticClass();
        //StaticInvokers.staticMethodInNonStaticClass();
        //StaticInvokers.staticMethodInNonStaticClass();
    }
}

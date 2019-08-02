package javaFundomentals;

/*
*  В данном классе я играюсь с темой исключений
*
*  Предисловие:
*  - Были созданы 3 класса ошибок
*       - ошибка наследующаяся от класса Throwable
*       - ошибка наследующаяся от класса Error
*       - ошибка наследующаяся от класса Exception
*  - Был создан класс который имеет методы под кажный из созданных классов исключений
*    Данные методы выбрасывают искусственно созданное исключение когда принимают на вход единицу
*
*  Наблюдения:
*  - Throwable имеет набор методов/ классы наследники Error&Exception имеют лишь конструкторы
*  - Error unchecked
*  - Exception checked
*  - Throwable checked
*  - unchecked исключение можно отловить
* */

public class ExceptionsByThrowable extends Throwable{

    public ExceptionsByThrowable(String message, int num){
        super(message);
    }

}

class ExceptionsByError extends Error{
    private int number;

    public ExceptionsByError(String message, int num){
        super(message);
        number = num;
    }
}

class ExceptionsByException extends Exception{
    private int number;

    public ExceptionsByException(String message, int num){
        super(message);
        number = num;
    }
}

class Factorial{

    public int getFactorialByExceptionsByThrowable(int num) throws ExceptionsByThrowable{
        if(num == 1) throw new ExceptionsByThrowable("THE NUM IS ONE", num);
        return num;
    }

    public int getFactorialByExceptionsByError(int num) throws ExceptionsByError{
        if(num == 1) throw new ExceptionsByError("THE NUM IS ONE", num);
        return num;
    }

    public int getFactorialByExceptionsByException(int num) throws ExceptionsByException{
        if(num == 1) throw new ExceptionsByException("THE NUM IS ONE", num);
        return num;
    }

}

class ExceptionsByThrowable_LocalMain{
    public static void main(String[] args){

        System.out.println("local main start");

        Factorial fac = new Factorial();
        try {
            fac.getFactorialByExceptionsByError(1);
        } catch (ExceptionsByError exceptionsByThrowable) {
            System.out.println(exceptionsByThrowable.getMessage());
        }

        try {
            fac.getFactorialByExceptionsByException(1);
        } catch (ExceptionsByException exceptionsByException) {
            System.out.println(exceptionsByException.getMessage());
        }

        try {
            fac.getFactorialByExceptionsByThrowable(1);
        } catch (ExceptionsByThrowable exceptionsByThrowable) {
            System.out.println(exceptionsByThrowable.getMessage());
        }
    }
}
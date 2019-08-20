package coreJava.javaFundomentals;

public class Inheritance {
    private int baseInt = 10;

    public int getBaseInt() {
        return baseInt;
    }

    public void test(){
        System.out.println("Inherit");
    }
}

class Heir extends Inheritance{
    private int baseInt = 20;

    public int getBaseInt() {
        return baseInt;
    }

    public void test(){
        System.out.println("heir");
    }

    public void test2(){

    }
}

class Inheritance_Main{
    public static void main(String[] args){
        Inheritance obj = new Heir();
        System.out.println("int - " + obj.getBaseInt());
        obj.test();
        //obj.test2 недопустимая конструкция из-за того что Inheritance видит в Heir только перегруженные методы
    }
}



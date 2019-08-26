package coreJava.javaFundomentals;

public class Inheritance {
    private int baseInt = 10;

    public int getBaseInt() {
        return baseInt;
    }

    public void printInt(){
        System.out.println("Inherit");
        System.out.println("-");
    }
}

class Heir extends Inheritance{
    private int baseInt = 20;
    private int localInt = 30;

    public int getBaseInt() {
        return baseInt;
    }

    public void printInt(){
        System.out.println(localInt);
        System.out.println("heir");

        System.out.println("-");
    }
}

class Inheritance_Main{
    public static void main(String[] args){
        Inheritance inh = new Inheritance ();
        inh.printInt();

        Heir objHeir = new Heir();
        objHeir .printInt();

        Inheritance objBoth = new Heir();
        objBoth.printInt();

    }
}



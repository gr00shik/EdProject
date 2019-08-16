package javaFundomentals.classLoader;

import java.io.IOException;

public class CustomClassLoader extends ClassLoader {


}

class CustomClassLoader_Main{

    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("notepad.exe");

    }
}
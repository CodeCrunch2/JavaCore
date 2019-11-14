package main.java.com.mkudriavtsev.javacore.chapter20;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) {
        try (ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream(
                "C:\\portapps\\IdeaProjects\\JavaCore\\src\\main\\java\\com\\mkudriavtsev\\javacore\\chapter20\\serial"))){
            MyClass object1 = new MyClass("Hello", -4, 2.7e10);
            System.out.println("object1: " + object1);
            objOStrm.writeObject(object1);
        }
        catch (IOException e) {
            System.out.println("Исключение при сериализации");
        }
        try (ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream(
                "C:\\portapps\\IdeaProjects\\JavaCore\\src\\main\\java\\com\\mkudriavtsev\\javacore\\chapter20\\serial"))){
            MyClass object2 = (MyClass)objIStrm.readObject();
            System.out.println("object2: " + object2);
        }
        catch (Exception e) {
            System.out.println("Исключение при десериализации");
        }
    }
}

class MyClass implements Serializable {
    private String s;
    private int i;
    private double d;
    public MyClass(String s, int i, double d) {
        this.s = s;
        this.i = i;
        this.d = d;
    }

    @Override
    public String toString() {
        return "s=" + s + "; i=" + i + "; d=" + d;
    }
}

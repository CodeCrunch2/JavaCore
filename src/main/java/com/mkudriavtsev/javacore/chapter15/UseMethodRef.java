package main.java.com.mkudriavtsev.javacore.chapter15;

import java.util.ArrayList;
import java.util.Collections;

class MyClass {
    private int val;
    MyClass(int v) {
        val = v;
    }
    int getVal() {
        return val;
    }
}
class UseMethodRef {
    static int compareMc (MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }

    public static void main(String[] args) {
        ArrayList<MyClass> a1 = new ArrayList<>();
        a1.add(new MyClass(1));
        a1.add(new MyClass(4));
        a1.add(new MyClass(2));
        a1.add(new MyClass(9));
        a1.add(new MyClass(3));
        a1.add(new MyClass(7));
        MyClass maxValObj = Collections.max(a1, UseMethodRef::compareMc);
        System.out.println("Максимальное значение равно: " + maxValObj.getVal());
    }
}

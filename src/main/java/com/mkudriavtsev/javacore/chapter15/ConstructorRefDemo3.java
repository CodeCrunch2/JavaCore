package main.java.com.mkudriavtsev.javacore.chapter15;

//Простая фабрика классов, использующая ссылку на конструктор

interface MyFunc6<R, T> {
    R func(T n);
}
//Простой обобщенный класс
class MyClass4<T> {
    private T val;
    MyClass4(T v) {
        val = v;
    }
    MyClass4() {
        val = null;
    }
    T getVal() {
        return val;
    }
}
//Простой необобщенный класс
class MyClass5{
    String str;
    MyClass5(String s) {
        str = s;
    }
    MyClass5() {
        str = "";
    }
    String getVal() {
        return str;
    }
}

class ConstructorRefDemo3 {
    static <R, T> R myClassFactory(MyFunc6<R, T> cons, T v) {
        return cons.func(v);
    }

    public static void main(String[] args) {
        MyFunc6<MyClass4<Double>, Double> myClassCons = MyClass4<Double>::new;
        MyClass4<Double> mc = myClassFactory(myClassCons, 100.1);
        System.out.println("Значение val в объекте mc равно " + mc.getVal());
        MyFunc6<MyClass5, String> myClassCons2 = MyClass5::new;
        MyClass5 mc2 = myClassFactory(myClassCons2, "Лямбда");
        System.out.println("Значение str в объекте mc2 равно " + mc2.getVal());

    }
}

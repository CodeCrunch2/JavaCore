package main.java.com.mkudriavtsev.javacore.chapter15;

interface MyFunc {
    int func(int n);
}
class VarCapture {
    public static void main(String[] args) {
        int num = 10;
        MyFunc myLambda = (n) -> {
            //Такое применение переменной num допустимо, тк она не видоизменяется
            int v = num + n;
            //Видоизменение num недопустимо
            //num++;
            return v;
        };
    }
}

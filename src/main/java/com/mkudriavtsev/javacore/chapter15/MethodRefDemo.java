package main.java.com.mkudriavtsev.javacore.chapter15;

//Демонстрация ссылки на статический метод
interface StringFunc3 {
    String func(String n);
}

class MyStringOps {
    static String strReverse(String str) {
        String result = "";
        for (int i = str.length()-1; i >= 0 ; i--) {
            result += str.charAt(i);
        }
        return result;
    }

}

class MethodRefDemo {
    static String stringOp(StringFunc3 sf, String s){
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность Java";
        String outStr = stringOp(MyStringOps::strReverse, inStr);
        System.out.println("Исходная строка: " + inStr);
        System.out.println("Обращенная строка: " + outStr);
    }

}

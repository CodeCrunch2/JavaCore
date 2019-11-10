package main.java.com.mkudriavtsev.javacore.chapter10;

public class SuperSubCatch {
    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 42 / a;
        }
        catch (ArithmeticException e) {
            System.out.println("Недостижимый код!"); //В книге перехват Exception предсшествует перехвату ArithmeticException что приводит к ошибке
        }
        catch (Exception e) {
            System.out.println("Перехват общего класса исключений Exception.");
        }

    }
}

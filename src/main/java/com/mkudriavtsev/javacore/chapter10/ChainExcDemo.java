package main.java.com.mkudriavtsev.javacore.chapter10;

class ChainExcDemo {
    static void demoproc(){
        //создать исключение
        NullPointerException e = new NullPointerException("верхний уровень");
        //добавить причину исключения
        e.initCause(new ArithmeticException("причина"));
        throw e;
    }

    public static void main(String[] args) {
        try {
            demoproc();
        }
        catch (NullPointerException e){
            System.out.println("Перехвачено исключение: " + e);
            System.out.println("Первопричина: " + e.getCause());
        }
    }
}

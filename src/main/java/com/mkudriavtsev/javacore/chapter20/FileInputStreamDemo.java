package main.java.com.mkudriavtsev.javacore.chapter20;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        int size;
        try (FileInputStream f =
                     new FileInputStream("/Users/mkudryavtsev/IdeaProjects/JavaCore/src/main/java/com/mkudriavtsev/javacore/chapter20/FileInputStreamDemo.java")){
            System.out.println("Общее количество доступных байтов: " + (size = f.available()));
            int n = size/40;
            System.out.println("Первые " + n + "байтов, прочитанных из файла по очереди методом read()");
            for (int i = 0; i < n; i++) {
                System.out.println((char)f.read());
            }
            System.out.println("\nВсе еще доступно: " + f.available());
            System.out.println("Чтение следующих " + n + " байтов методом read(b[])");
            byte [] b = new byte[n];
            if(f.read(b) !=n ){
                System.err.println("Нельзя прочитать " + n + " байтов");
            }
            System.out.println(new String(b, 0, n));
            System.out.println("\nВсе еще доступно: " + (size = f.available()));
            System.out.println("Пропустить половину оставшихся байтов методом skip()");
            f.skip(size/2);
            System.out.println("Все еще доступно: " + f.available());
            System.out.println("Чтение " + n/2 + " байтов, размещаемых в конце массива");
            if (f.read(b, n/2, n/2) != n/2) {
                System.err.println("Нельзя прочитать " + n/2 + " байтов");
            }
            System.out.println(new String(b, 0, b.length));
            System.out.println("\nВсе еще доступно: " + f.available());

        }
        catch (IOException e){
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}

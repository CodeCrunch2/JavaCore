package main.java.com.mkudriavtsev.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//try с ресурсами
class ShowFile2 {
    public static void main(String[] args) {
        int i;
        if(args.length !=1){
            System.out.println("Использование: ShowFile2 имя_файла");
            return;
        }
        try (FileInputStream fin = new FileInputStream(args[0])) {
            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }

    }
}

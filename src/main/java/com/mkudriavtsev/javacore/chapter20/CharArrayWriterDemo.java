package main.java.com.mkudriavtsev.javacore.chapter20;


import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriterDemo {
    public static void main(String args[]) throws IOException {
        CharArrayWriter f = new CharArrayWriter();
        String s = "Эти данные должны быть выведены в массив!";
        char buf[] = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);
        try {
            f.write(buf);
        }
        catch(IOException e) {
            System.out.println("Ошибка записи в буфер");
            return;
        }
        System.out.println("Буффер в виде символьной строки");
        System.out.println(f.toString());
        System.out.println("В массив");
        char c[] = f.toCharArray();
        for (int i=0; i<c.length; i++) {
            System.out.print(c[i]);
        }
        System.out.println("\nВ поток FileWriter()");
        try ( FileWriter f2 = new FileWriter("C:\\portapps\\IdeaProjects\\JavaCore\\src\\main\\java\\com\\mkudriavtsev\\javacore\\chapter20\\test.txt") )
        {
            f.writeTo(f2);
        }
        catch(IOException e) {
            System.out.println("Ошибка ввода-вывода" + e);
        }
        System.out.println("Установка в исходное состояние");
        f.reset();
        for (int i=0; i<3; i++) f.write('x');
        System.out.println(f.toString());
    }
}
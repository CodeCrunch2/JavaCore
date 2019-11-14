package main.java.com.mkudriavtsev.javacore.chapter20;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("C:\\portapps\\IdeaProjects\\JavaCore\\src\\main\\java\\com\\mkudriavtsev\\javacore\\chapter20\\FileReaderDemo.java")) {
            int c;
            while (fr.ready()) {
                c = fr.read();
                System.out.print((char)c);
            }
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}

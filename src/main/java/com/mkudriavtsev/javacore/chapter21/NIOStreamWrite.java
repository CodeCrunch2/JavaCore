package main.java.com.mkudriavtsev.javacore.chapter21;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class NIOStreamWrite {
    public static void main(String[] args) {
        try (OutputStream fout =
                     new BufferedOutputStream( Files.newOutputStream(Paths.get("src/main/java/com/mkudriavtsev/javacore/chapter21/test.txt")))) {

            for (int i = 0; i < 26; i++) {
                fout.write((byte)('A' + i));
            }
        }
        catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути");
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}

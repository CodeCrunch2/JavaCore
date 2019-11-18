package main.java.com.mkudriavtsev.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;

public class NIOCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Использование: откуда и куда");
            return;
        }
        try {
            Path source = Paths.get(args[0]);
            Path target = Paths.get(args[1]);
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути");
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}

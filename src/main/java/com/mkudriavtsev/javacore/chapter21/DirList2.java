package main.java.com.mkudriavtsev.javacore.chapter21;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList2 {
    public static void main(String[] args) {
        String dirname = "/Users/mkudryavtsev/IdeaProjects/JavaCore/src/main/java/com/mkudriavtsev/javacore/chapter21/examples";
        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path filename) throws IOException {
                if (Files.isWritable(filename)) return true;
                return false;
            }
        };
        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirname), how)) {
            System.out.println("Каталог: " + dirname);
            for (Path entry: dirstrm) {
                BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);
                if (attribs.isDirectory())
                    System.out.print("<DIR> ");
                else System.out.print("      ");
                System.out.println(entry.getName(12));
            }

        }
        catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        }
        catch (NotDirectoryException e) {
            System.out.println(dirname + " не является каталогом");
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
    }
}

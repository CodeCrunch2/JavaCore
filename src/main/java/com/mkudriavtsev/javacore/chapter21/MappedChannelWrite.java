package main.java.com.mkudriavtsev.javacore.chapter21;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MappedChannelWrite {
    public static void main(String[] args) {
        try (FileChannel fChan = (FileChannel)
                Files.newByteChannel(Paths.get("src/main/java/com/mkudriavtsev/javacore/chapter21/test.txt"),
                        StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE)){
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);
            for (int i = 0; i < 26; i++) {
                mBuf.put((byte) ('A' + i));

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

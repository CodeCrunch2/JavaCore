package main.java.com.mkudriavtsev.javacore.chapter21;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExplicitChannelRead {
    public static void main(String[] args) {
        int count;
        Path filepath = null;
        try {
            filepath = Paths.get("src\\main\\java\\com\\mkudriavtsev\\javacore\\chapter21\\test.txt");
        }
        catch (InvalidPathException e) {
            System.out.println("Ошибка создания объекта Path" + e);
            return;
        }
        try (SeekableByteChannel fChan = Files.newByteChannel(filepath)) {
            ByteBuffer mbuf = ByteBuffer.allocate(128);
            do {
                count = fChan.read(mbuf);
                if (count != -1) {
                    mbuf.rewind();
                }
                for (int i = 0; i < count; i++) {
                    System.out.print((char)mbuf.get());
                }
            } while (count != -1);
        }
        catch (IOException e) {
            System.out.println("Ошибка ввода-вывода" + e);
        }


    }
}

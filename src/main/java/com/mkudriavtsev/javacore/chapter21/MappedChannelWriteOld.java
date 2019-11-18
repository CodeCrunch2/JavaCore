package main.java.com.mkudriavtsev.javacore.chapter21;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MappedChannelWriteOld {
    public static void main(String args[]) {
        RandomAccessFile fOut = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;
        try {
            fOut = new RandomAccessFile("/Users/mkudryavtsev/IdeaProjects/JavaCore/src/main/java/com/mkudriavtsev/javacore/chapter21/test.txt", "rw");
            fChan = fOut.getChannel();
            mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);
            for(int i=0; i<26; i++)
                mBuf.put((byte)('A' + i));

        }
        catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }
        finally {
            try {
                if(fChan != null) fChan.close(); // close channel
            }
            catch(IOException e) {
                System.out.println("Ошибка закрытия канала");
            }
            try {
                if(fOut != null) fOut.close(); // close file
            }
            catch(IOException e) {
                System.out.println("Ошибка закрытия файла");
            }
        }
    }
}

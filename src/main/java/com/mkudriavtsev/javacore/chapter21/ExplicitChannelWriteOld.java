package main.java.com.mkudriavtsev.javacore.chapter21;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExplicitChannelWriteOld {
    public static void main(String args[]) {
        FileOutputStream fOut = null;
        FileChannel fChan = null;
        ByteBuffer mBuf;
        try {
            fOut = new FileOutputStream("/Users/mkudryavtsev/IdeaProjects/JavaCore/src/main/java/com/mkudriavtsev/javacore/chapter21/test.txt");
            fChan = fOut.getChannel();
            mBuf = ByteBuffer.allocate(26);
            for(int i=0; i<26; i++)
                mBuf.put((byte)('A' + i));
            mBuf.rewind();
            fChan.write(mBuf);
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

package main.java.com.mkudriavtsev.javacore.chapter20;

import java.io.File;
import java.io.FilenameFilter;

public class DirListOnly {
    public static void main(String[] args) {
        String dirName = "/Users/mkudryavtsev/IdeaProjects/JavaCore/src/main/java/com/mkudriavtsev/javacore/chapter20";
        File fl = new File(dirName);
        FilenameFilter only = new OnlyExt("html");
        String s[] = fl.list(only);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);

        }

    }
}

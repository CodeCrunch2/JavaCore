package main.java.com.mkudriavtsev.javacore.chapter20;

import java.io.File;

public class FileDemo {
    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        File f1 = new File("src\\main\\java\\com\\mkudriavtsev\\javacore\\chapter20\\TEST.txt");
        p("Имя файла: " + f1.getName());
        p("Путь: " + f1.getPath());
        p("Абсолютный путь: " + f1.getAbsolutePath());
        p("Родительский каталог: " + f1.getParent());
        p(f1.exists()?"существует":"не существует");
        p(f1.canWrite()?"доступен для записи":"не доступен для записи");
        p(f1.canRead()?"доступен для чтения":"не доступен для чтения");
        p(f1.isDirectory()?"является каталогом":"не является каталогом");
        p(f1.isFile()?"является обычным файлом":"может быть именованным каналом");
        p(f1.isAbsolute()?"является абсолютным":"не является абсолютным");
        p("Последнее изменение в файле: " + f1.lastModified());
        p("Размер: " + f1.length() + "байт");



    }
}

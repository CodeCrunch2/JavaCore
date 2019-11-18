package main.java.com.mkudriavtsev.javacore.chapter29;

import java.util.ArrayList;
import java.util.stream.Stream;

class NamePhoneEmail {
    String name;
    String phonenum;
    String email;
    NamePhoneEmail(String n, String p, String e) {
        name = n;
        phonenum = p;
        email = e;
    }
}

class NamePhone {
    String name;
    String phonenum;
    NamePhone(String n, String p) {
        name = n;
        phonenum = p;
    }
}
public class StreamDemo5 {
    public static void main(String[] args) {
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Игорь", "555-5555", "igor@mail.com"));
        myList.add(new NamePhoneEmail("Игорь2", "555-4444", "igor2@mail.com"));
        myList.add(new NamePhoneEmail("Игорь3", "444-5555", "igor3@mail.com"));
        System.out.println("Исходные элементы из списка myList: ");
        myList.stream().forEach((a) -> System.out.println(a.name + " " + a.phonenum + " " + a.email));
        System.out.println();
        Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));
        System.out.println("Список имен и номеров телефонов: ");
        nameAndPhone.forEach((a) -> System.out.println(a.name + " " + a.phonenum));

    }
}

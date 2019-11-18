package main.java.com.mkudriavtsev.javacore.chapter29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo10 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Альфа");
        myList.add("Бета");
        myList.add("Гамма");
        myList.add("Дельта");
        myList.add("Кси");
        myList.add("Омега");
        Stream<String> myStream = myList.stream();
        Spliterator<String> splitItr = myStream.spliterator();
        Spliterator<String> splitItr2 = splitItr.trySplit();
        if (splitItr2 != null) {
            System.out.println("Результат, выводимый итератором 2: ");
            splitItr2.forEachRemaining(System.out::println);
        }
        System.out.println("\nРезультат, выводимый итератором 1: ");
        splitItr.forEachRemaining(System.out::println);

    }
}

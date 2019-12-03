package main.java.com.mkudriavtsev.javacore.chapter28;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        int currentPhase;
        System.out.println("Запуск потков");
        new MyThread3(phaser, "A");
        new MyThread3(phaser, "B");
        new MyThread3(phaser, "C");
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + currentPhase + " завершена");
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + currentPhase + " завершена");
        currentPhase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + currentPhase + " завершена");
        phaser.arriveAndDeregister();
        if(phaser.isTerminated()) {
            System.out.println("Синхронизатор фаз завершен");
        }


    }
}
class MyThread3 implements Runnable {
    Phaser phaser;
    String name;
    MyThread3(Phaser p, String n) {
        phaser = p;
        name = n;
        phaser.register();
        new Thread(this).start();
    }
    @Override
    public void run() {
        System.out.println("Поток " + name + " начинает первую фазу");
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Поток " + name + " начинает вторую фазу");
        phaser.arriveAndAwaitAdvance();
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Поток " + name + " начинает третью фазу");
        phaser.arriveAndDeregister();

    }
}

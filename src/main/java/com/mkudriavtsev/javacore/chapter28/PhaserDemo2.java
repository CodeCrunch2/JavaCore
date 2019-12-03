package main.java.com.mkudriavtsev.javacore.chapter28;

import java.util.concurrent.Phaser;

public class PhaserDemo2 {
    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser(1, 4);
        System.out.println("Запуск потоков\n");
        new MyThread4(myPhaser, "A");
        new MyThread4(myPhaser, "B");
        new MyThread4(myPhaser, "C");
        while (!myPhaser.isTerminated()) {
            myPhaser.arriveAndAwaitAdvance();
        }
        System.out.println("Синхронизатор фаз завершен");
    }
}
class MyPhaser extends Phaser {
    int numPhases;
    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("Фаза " + phase + " завершена\n");
        if (phase == numPhases || registeredParties == 0) {
            return true;
        }
        return false;

    }
}
class MyThread4 implements Runnable {
    Phaser phaser;
    String name;
    MyThread4(Phaser p, String n) {
        phaser = p;
        name = n;
        phaser.register();
        new Thread(this).start();
    }
    @Override
    public void run() {
        while (!phaser.isTerminated()) {
            System.out.println("Поток " + name + " начниает фазу " + phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

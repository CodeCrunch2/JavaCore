package main.java.com.mkudriavtsev.javacore.chapter28;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new BarAction());
        System.out.println("Запуск потоков");
        new MyThread2(cyclicBarrier, "A");
        new MyThread2(cyclicBarrier, "B");
        new MyThread2(cyclicBarrier, "C");

    }
}
class MyThread2 implements Runnable {
    CyclicBarrier cbar;
    String name;
    MyThread2(CyclicBarrier c, String n) {
        cbar = c;
        name = n;
        new Thread(this).start();
    }
    @Override
    public void run() {
        System.out.println(name);
        try {
            cbar.await();
        }
        catch (BrokenBarrierException e) {
            System.out.println(e);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
class BarAction implements Runnable {

    @Override
    public void run() {
        System.out.println("Барьер достингут!");
    }
}

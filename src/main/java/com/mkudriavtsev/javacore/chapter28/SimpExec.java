package main.java.com.mkudriavtsev.javacore.chapter28;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SimpExec {
    public static void main(String args[]) {
        CountDownLatch cdl = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);

        System.out.println("Завершение потоков");

        // Start the threads.
        es.execute(new MyThread5(cdl, "A"));
        es.execute(new MyThread5(cdl2, "B"));

        es.execute(new MyThread5(cdl3, "C"));
        es.execute(new MyThread5(cdl4, "D"));

        try {
            cdl.await();
            System.out.println("A завершился");
            cdl2.await();
            System.out.println("B завершился");
            cdl3.await();
            System.out.println("C завершился");
            cdl4.await();
            System.out.println("D завершился");
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        es.shutdown();
        System.out.println("Завершение потоков");
    }
}

class MyThread5 implements Runnable {
    String name;
    CountDownLatch latch;

    MyThread5(CountDownLatch c, String n) {
        latch = c;
        name = n;

        new Thread(this);
    }

    public void run() {

        try {
            for(int i = 0; i < 5; i++) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
                latch.countDown();
            }
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}


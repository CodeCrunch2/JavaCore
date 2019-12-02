package main.java.com.mkudriavtsev.javacore.chapter11;

public class PCFixed {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
    }
}

class Q {
    int n;
    boolean valueSet = false;
    synchronized int get() {
        while (!valueSet)
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        System.out.println("Получено: " + n);
        valueSet = false;
        notify();
        return n;
    }
    synchronized void put (int n) {
        while (valueSet) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Отправлено: " + n);
        notify();
    }

}

class Producer implements Runnable {
    Q q;
    Producer(Q q) {
        this.q = q;
        new Thread(this, "Поставщик").start();
    }
    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
        }
    }

}
class Consumer implements Runnable {
    Q q;
    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Потребитель").start();
    }
    @Override
    public void run() {
        while (true) {
            q.get();
        }

    }
}
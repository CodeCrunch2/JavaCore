package main.java.com.mkudriavtsev.javacore.chapter28;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FJExperiment {
    public static void main(String[] args) {
        int pLevel = 10;
        int threshold = 1000;
        long beginT, endT;
        ForkJoinPool fjp = new ForkJoinPool(pLevel);
        double [] nums = new double[1000000];
        for (int i = 0; i < nums.length; i++) {
            nums [i] = (double) i;
        }
        TransForm task = new TransForm(nums, 0, nums.length, threshold);
        beginT = System.nanoTime();
        fjp.invoke(task);
        endT = System.nanoTime();
        System.out.println("Уровень параллелизма: " + pLevel);
        System.out.println("Порог последовательной обработки: " + threshold);
        System.out.println("Истекшее время: " + (endT - beginT) + " нс");
        System.out.println();
    }
}

class TransForm extends RecursiveAction {
    int seqThreshold;
    double [] data;
    int start, end;
     TransForm(double [] vals, int s, int e, int t) {
         data = vals;
         start = s;
         end = e;
         seqThreshold = t;
     }

    @Override
    protected void compute() {
         if ((end - start) < seqThreshold) {
             for (int i = start; i < end; i++) {
                 if((data[i] % 2) == 0) data[i] = Math.sqrt(data[i]);
                 else data[i] = Math.cbrt(data[i]);
             }
         }
         else {
             int middle = (start + end) / 2;
             invokeAll(new TransForm(data, start, middle, seqThreshold), new TransForm(data, middle, end, seqThreshold));
         }
    }
}

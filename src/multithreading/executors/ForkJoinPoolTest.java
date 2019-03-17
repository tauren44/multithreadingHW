package multithreading.executors;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest {
    private static long numOfOperations = 10_000_000_000L;
    private static int numOfThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool(numOfThreads);
        pool.invoke(new MyFork(0, numOfOperations));
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }

    static class MyFork extends RecursiveTask<Long> {
        long from;
        long to;

        @Override
        protected Long compute() {
            if (to - from <= numOfOperations / numOfThreads) {
                long j = 0;
                for (long i = from; i < to; i++) {
                    j += i;
                }
                return j;
            } else {
                long middle = (to + from) / 2;
                MyFork firstHalf = new MyFork(from, middle);
                firstHalf.fork();
                MyFork secondHalf = new MyFork(middle, to);
                secondHalf.fork();
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;
            }
        }

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }
    }
}

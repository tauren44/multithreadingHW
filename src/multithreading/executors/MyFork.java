package multithreading.executors;

import java.util.concurrent.RecursiveTask;

public class MyFork extends RecursiveTask<Long> {
    private long from;
    private long to;
    public static final long NUM_OF_OPERATIONS = 10_000_000_000L;
    public static int numOfThreads = Runtime.getRuntime().availableProcessors();

    public MyFork(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        if (to - from <= NUM_OF_OPERATIONS / numOfThreads) {
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
}

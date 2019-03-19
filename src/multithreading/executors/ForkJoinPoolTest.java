package multithreading.executors;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest {

    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool(MyFork.numOfThreads);
        pool.invoke(new MyFork(0, MyFork.NUM_OF_OPERATIONS));
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}

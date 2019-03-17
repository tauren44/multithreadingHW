package multithreading.executors;

import multithreading.utility.ThreadSleep;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() {
        int j = 0;
        for (int i = 0; i < 20; i++) {
            j++;
            ThreadSleep.sleep(100);
        }
        return j;
    }
}

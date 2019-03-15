package multithreading.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

public class CounterThread implements Runnable {

    private Semaphore semaphore;

    CounterThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting");
            semaphore.acquire();
            SemaphoreTestApp.resource = 0;
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + SemaphoreTestApp.resource);
                SemaphoreTestApp.resource++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " finished his work");
        semaphore.release();
    }
}

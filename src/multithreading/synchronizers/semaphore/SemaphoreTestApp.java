package multithreading.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTestApp {
    public static int resource;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Thread thread = new Thread(new CounterThread(semaphore));
        Thread thread1 = new Thread(new CounterThread(semaphore));
        Thread thread2 = new Thread(new CounterThread(semaphore));

        thread.start();
        thread1.start();
        thread2.start();
    }
}

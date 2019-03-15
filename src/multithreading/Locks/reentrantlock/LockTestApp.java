package multithreading.Locks.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTestApp {
    public static int resource;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 5; i++) {

            Thread thread = new Thread(new CountThread(lock));
            thread.setName("Thread " + i);
            thread.start();
        }
    }
}

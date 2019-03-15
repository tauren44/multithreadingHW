package multithreading.Locks.reentrantlock;

import java.util.concurrent.locks.Lock;

public class CountThread implements Runnable {
    private Lock locker;

    CountThread(Lock locker) {
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock();
        try {
            LockTestApp.resource = 0;
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + LockTestApp.resource);
                LockTestApp.resource++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}

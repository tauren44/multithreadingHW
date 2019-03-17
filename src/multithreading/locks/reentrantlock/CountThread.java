package multithreading.locks.reentrantlock;

import multithreading.utility.ThreadSleep;

import java.util.concurrent.locks.Lock;

public class CountThread implements Runnable {
    private Lock locker;

    CountThread(Lock locker) {
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock();
        LockTestApp.resource = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " " + LockTestApp.resource);
            LockTestApp.resource++;
            ThreadSleep.sleep(100);
        }
        locker.unlock();
    }
}

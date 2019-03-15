package multithreading.Locks.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;

public class ReadThread implements Runnable {
    private ReadWriteLock locker;

    public ReadThread(ReadWriteLock locker) {
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.readLock().lock();
        try {
            Thread.sleep(1000);
            ReadWriteLockTestApp.information.forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.readLock().unlock();
        }
    }
}

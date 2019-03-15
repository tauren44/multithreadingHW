package multithreading.Locks.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;

public class WriteThread implements Runnable {
    private ReadWriteLock locker;

    public WriteThread(ReadWriteLock locker) {
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.writeLock().lock();
        try {
            Thread.sleep(100);
            ReadWriteLockTestApp.information.add("First");
            ReadWriteLockTestApp.information.add("Second");
            ReadWriteLockTestApp.information.add("Third");
            ReadWriteLockTestApp.information.add("Fourth");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.writeLock().unlock();
        }

    }
}

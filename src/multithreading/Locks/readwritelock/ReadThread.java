package multithreading.Locks.readwritelock;

import multithreading.Utility.ThreadSleep;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

public class ReadThread implements Runnable {
    private ReadWriteLock locker;
    private static List<String> information;

    public ReadThread(ReadWriteLock locker, List<String> information) {
        this.locker = locker;
        ReadThread.information = information;
    }

    @Override
    public void run() {
        locker.readLock().lock();
        ThreadSleep.sleep(1000);
        information.forEach(System.out::println);
        locker.readLock().unlock();
    }
}

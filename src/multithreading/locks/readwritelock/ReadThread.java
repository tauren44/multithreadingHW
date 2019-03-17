package multithreading.locks.readwritelock;

import multithreading.utility.ThreadSleep;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

public class ReadThread implements Runnable {
    private ReadWriteLock locker;
    private List<String> information;

    public ReadThread(ReadWriteLock locker, List<String> information) {
        this.locker = locker;
        this.information = information;
    }

    @Override
    public void run() {
        locker.readLock().lock();
        ThreadSleep.sleep(1000);
        information.forEach(System.out::println);
        locker.readLock().unlock();
    }
}

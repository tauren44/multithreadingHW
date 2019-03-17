package multithreading.locks.readwritelock;

import multithreading.utility.ThreadSleep;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

public class WriteThread implements Runnable {
    private ReadWriteLock locker;
    private List<String> information;

    public WriteThread(ReadWriteLock locker, List<String> information) {
        this.locker = locker;
        this.information = information;
    }

    @Override
    public void run() {
        locker.writeLock().lock();
        ThreadSleep.sleep(100);
        information.add("First");
        information.add("Second");
        information.add("Third");
        information.add("Fourth");
        locker.writeLock().unlock();
    }
}

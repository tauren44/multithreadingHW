package multithreading.Locks.readwritelock;

import multithreading.Utility.ThreadSleep;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

public class WriteThread implements Runnable {
    private ReadWriteLock locker;
    private static List<String> information;

    public WriteThread(ReadWriteLock locker, List<String> information) {
        this.locker = locker;
        WriteThread.information = information;
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

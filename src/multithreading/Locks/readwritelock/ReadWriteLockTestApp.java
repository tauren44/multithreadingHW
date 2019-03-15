package multithreading.Locks.readwritelock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTestApp {
    public static List<String> information = new ArrayList<>();

    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Thread readThread = new Thread(new ReadThread(lock));
        Thread secondReadThread = new Thread(new ReadThread(lock));
        Thread writeThread = new Thread(new WriteThread(lock));

        writeThread.start();
        readThread.start();
        secondReadThread.start();

    }
}

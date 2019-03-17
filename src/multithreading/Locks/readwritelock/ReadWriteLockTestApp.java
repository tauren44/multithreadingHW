package multithreading.Locks.readwritelock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTestApp {

    public static void main(String[] args) {
        List<String> information = new ArrayList<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Thread readThread = new Thread(new ReadThread(lock, information));
        Thread secondReadThread = new Thread(new ReadThread(lock, information));
        Thread writeThread = new Thread(new WriteThread(lock, information));

        writeThread.start();
        readThread.start();
        secondReadThread.start();
    }
}

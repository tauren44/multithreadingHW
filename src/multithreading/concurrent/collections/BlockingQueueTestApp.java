package multithreading.concurrent.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTestApp {
    private static final int INITIAL_CAPACITY = 10;
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(INITIAL_CAPACITY);

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < INITIAL_CAPACITY; i++) {
                queue.add("Some item #" + i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < INITIAL_CAPACITY; i++) {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

package multithreading.concurrent.collections;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteTestApp {
    /**
     * CopyOnWrite is a good choice for reading from collection because read operation does not lock collection
     * Write operations lock collection, and create a new copy of collection
     * Iterator doesn't throw ConcurrentModificationException
     * */
    private static List<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        list.add(0);
        list.add(2);
        list.add(4);
        list.add(6);

        new Thread(() -> {
            System.out.print("From thread-0: ");
            list.forEach(System.out::println);           //fail-safe iterator
        }).start();

        new Thread(() -> {
            list.add(8);
            list.add(10);
            System.out.print("From thread-1: ");
            list.forEach(System.out::println);        //fail-safe iterator
        }).start();
    }
}

package multithreading.concurrent.collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTestApp {
    private static Map<String, String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        map.putIfAbsent("login", "password");
        map.putIfAbsent("user1", "12345");
        map.putIfAbsent("admin", "admin");

        new Thread(() -> map.keySet().stream().map(key -> map.get(key)).forEach(System.out::println)).start();
        new Thread(() -> map.putIfAbsent("test", "test")).start();
        new Thread(() -> map.keySet().stream().map(key -> map.get(key)).forEach(System.out::println)).start();
    }
}

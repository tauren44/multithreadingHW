package multithreading.singleton;

public class Singleton {
    private static volatile Singleton instance;
    private static final Object mutex = new Object();

    private Singleton() {
    }

    public static Singleton getInstance() {
        Singleton result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = result = new Singleton();
                }
            }
        }
        return result;
    }
}

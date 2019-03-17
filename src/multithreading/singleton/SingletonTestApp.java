package multithreading.singleton;

import java.lang.reflect.Constructor;

public class SingletonTestApp {
    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            new Thread(() -> System.out.println(Singleton.getInstance().hashCode())).start();
        }
        /*
         * Reflection breaks singleton
         * */
        Singleton singleton = Singleton.getInstance();
        Singleton reflected = singleton;

        try {
            Constructor[] constructors =
                    Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                reflected = (Singleton) constructor.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Objects are equals : " + singleton.equals(reflected));
        System.out.println(singleton.hashCode() + " Singleton instance hashcode");

        System.out.println(reflected.hashCode() + " Reflected instance hashcode");
    }
}

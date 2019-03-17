package multithreading.synchronizers.cyclicbarrier;

import multithreading.utility.ThreadSleep;

public class FerryBoat implements Runnable {
    @Override
    public void run() {
        ThreadSleep.sleep(500);
        System.out.println("Ferry ferried cars!");
    }
}

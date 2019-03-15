package multithreading.synchronizers.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTestApp {
    public static final CyclicBarrier BARRIER = new CyclicBarrier(2, new FerryBoat());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(500);
        }
    }
}

package multithreading.synchronizers.cyclicbarrier;

public class FerryBoat implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("Ferry ferried cars!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

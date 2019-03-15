package multithreading.synchronizers.cyclicbarrier;

public class Car implements Runnable {
    private int carNumber;

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        try {
            System.out.printf("The car #%d is arrived to ferry.\n", carNumber);
            CyclicBarrierTestApp.BARRIER.await();
            System.out.printf("The car #%d continue moving.\n", carNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

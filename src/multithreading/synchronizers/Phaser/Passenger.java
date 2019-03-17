package multithreading.synchronizers.Phaser;

public class Passenger extends Thread {
    private int departure;
    private int destination;

    public Passenger(int departure, int destination) {
        this.departure = departure;
        this.destination = destination;
        System.out.println(this + " is waiting at bus stop# " + this.departure);
    }

    @Override
    public void run() {
        try {
            System.out.println(this + " got on the bus");

            while (PhaserTestApp.PHASER.getPhase() < destination) {
                PhaserTestApp.PHASER.arriveAndAwaitAdvance();
            }

            Thread.sleep(1);
            System.out.println(this + " left the bus.");
            PhaserTestApp.PHASER.arriveAndDeregister();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Passenger{" + departure + " -> " + destination + '}';
    }

    public int getDeparture() {
        return departure;
    }
}

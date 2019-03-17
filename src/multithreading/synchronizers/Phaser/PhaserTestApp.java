package multithreading.synchronizers.Phaser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

public class PhaserTestApp {
    public static final Phaser PHASER = new Phaser(1);
    private static List<Passenger> passengers = new ArrayList<>();

    public static void main(String[] args) {
        generatePassengers();
        testPhaser();
    }

    private static void testPhaser() {
        for (int i = 0; i < 7; i++) {
            switch (i) {
                case 0:
                    System.out.println("Bus left the depot.");
                    PHASER.arrive();
                    break;
                case 6:
                    System.out.println("Bus goes to depot.");
                    PHASER.arriveAndDeregister();
                    break;
                default:
                    registerPassengers();
            }
        }
    }

    private static void generatePassengers() {
        for (int i = 1; i < 5; i++) {           //generate passengers on bus stops
            if ((int) (Math.random() * 2) > 0) {
                passengers.add(new Passenger(i, i + 1));
            }
            if ((int) (Math.random() * 2) > 0) {
                passengers.add(new Passenger(i, 5));
            }
        }
    }

    private static void registerPassengers() {
        int currentBusStop = PHASER.getPhase();
        System.out.println("Bus stop #" + currentBusStop);

        for (Passenger passenger : passengers)
            if (passenger.getDeparture() == currentBusStop) {
                PHASER.register();
                passenger.start();
            }
        PHASER.arriveAndAwaitAdvance();
    }
}

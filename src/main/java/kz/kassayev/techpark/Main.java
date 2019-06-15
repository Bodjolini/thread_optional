package kz.kassayev.techpark;

import kz.kassayev.techpark.creator.AutoParkCreator;
import kz.kassayev.techpark.entity.Car;
import kz.kassayev.techpark.pool.ParkPool;

public class Main {
    public static void main(String[] args) {
        ParkPool parkPool = new ParkPool();
        parkPool.addToPool(AutoParkCreator.Saturn());
        parkPool.addToPool(AutoParkCreator.Bayterek());
        parkPool.addToPool(AutoParkCreator.Aktobe());

        for (int i = 0; i < 200; i++) {
            new Car(parkPool).start();
        }
    }
}

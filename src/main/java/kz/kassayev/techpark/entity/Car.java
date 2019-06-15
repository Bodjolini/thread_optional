package kz.kassayev.techpark.entity;

import kz.kassayev.techpark.pool.ParkPool;
import org.apache.log4j.Logger;

public class Car extends Thread {
    private static Logger logger = Logger.getLogger(Car.class);
    private boolean occupiedPlace;
    private ParkPool parkPool;

   public Car(ParkPool parkPool){
       this.parkPool = parkPool;
   }

    @Override
    public void run() {
        this.setName("Car - " + this.getId());
        ParkPlace parkPlace = null;

        while (parkPlace == null){
            parkPlace = parkPool.getPlace(500);
        }

        logger.info("Car Id : " + this.getId() + " took a parking place : " + parkPlace.getPlaceId() + ". Parking : " + parkPlace.getParkId());
        occupiedPlace = true;

        parkPlace.using();

        occupiedPlace = false;
        logger.info("Car Id : " + this.getId() + " : " + parkPlace.getPlaceId() + " freed place. Parking : " + parkPlace.getParkId());
        while (true){
            if(parkPool.retrunPlace(parkPlace)){
                break;
            }
        }
    }
}

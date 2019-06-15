package kz.kassayev.techpark.entity;

import org.apache.log4j.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ParkPlace {
    private static Logger logger = Logger.getLogger(ParkPlace.class);
    private int placeId;
    private int parkId;
    private Random random = new Random();

    public ParkPlace(int placeId, int parkId) {
        this.placeId = placeId;
        this.parkId = parkId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public int getParkId() {
        return parkId;
    }

    public void using(){
        try {
            TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
        } catch (InterruptedException e){
            logger.error(e);
        }
    }
}

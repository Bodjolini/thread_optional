package kz.kassayev.techpark.entity;

import org.apache.log4j.Logger;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class AutoPark {
    private static Logger logger = Logger.getLogger(AutoPark.class);
    private int parkId;
    private int parkSize;
    private Queue<ParkPlace> places = new ConcurrentLinkedQueue<>();
    private Semaphore semaphore;

    public AutoPark(int parkId, int parkSize) {
        this.parkId = parkId;
        this.parkSize = parkSize;
        this.semaphore = new Semaphore(parkSize, true);
    }

    public int getParkId() {
        return parkId;
    }


    public void addToParkPlaces(ParkPlace place) {
        if (parkSize > 0) {
            places.add(place);
        } else {
            logger.error("NULL FROM AUTOPARK");
        }
    }

    public ParkPlace occupyPlace(long maxMillisecondsOfWaiting) {
        ParkPlace toGet = null;
        try {
            if (semaphore.tryAcquire(maxMillisecondsOfWaiting, TimeUnit.MILLISECONDS)){
                ParkPlace parkPlace = places.poll();
                toGet = parkPlace;
            }
        } catch (InterruptedException e){
            logger.error(e);
        }
        return toGet;
    }

    public void retrunPlace(ParkPlace parkPlace){
        places.add(parkPlace);
        semaphore.release();
    }
}

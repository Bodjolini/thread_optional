package kz.kassayev.techpark.pool;

import kz.kassayev.techpark.entity.AutoPark;
import kz.kassayev.techpark.entity.ParkPlace;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ParkPool {
    private static Logger logger = Logger.getLogger(ParkPool.class);
    private ReentrantLock lock = new ReentrantLock();
    private ArrayList<AutoPark> parkPool = new ArrayList<>();

    public void addToPool(AutoPark autoPark){
        parkPool.add(autoPark);
    }

    public ParkPlace getPlace(long maxMillisecondsOfWaiting){
        ParkPlace toRetrun = null;
            for (AutoPark autoPark:parkPool){
                ParkPlace parkPlace = autoPark.occupyPlace(maxMillisecondsOfWaiting);
                if (parkPlace != null){
                    toRetrun = parkPlace;
                    break;
                } else {
                    logger.info("Car #" + Thread.currentThread().getId() + " timeout. Going to another parking.");
                }
            }
        return toRetrun;
    }

    public boolean retrunPlace(ParkPlace parkPlace) {
        boolean toRetrun = false;
        if (lock.tryLock()){
            for (AutoPark autoPark:parkPool){
                if (autoPark.getParkId() == parkPlace.getParkId()){
                    autoPark.retrunPlace(parkPlace);
                }
            }
            toRetrun = true;
            lock.unlock();
        }
        return toRetrun;
    }
}

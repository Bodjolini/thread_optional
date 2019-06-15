package kz.kassayev.techpark.creator;

import kz.kassayev.techpark.entity.AutoPark;
import kz.kassayev.techpark.entity.ParkPlace;

public class AutoParkCreator {
    public static AutoPark Saturn(){
        AutoPark autoPark = new AutoPark(1,5);

        autoPark.addToParkPlaces(new ParkPlace(1,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(2,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(3,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(4,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(5,autoPark.getParkId()));

        return autoPark;
    }

    public static AutoPark Bayterek(){
        AutoPark autoPark = new AutoPark(2,6);

        autoPark.addToParkPlaces(new ParkPlace(1,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(2,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(3,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(4,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(5,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(6,autoPark.getParkId()));

        return autoPark;
    }

    public static AutoPark Aktobe(){
        AutoPark autoPark = new AutoPark(3,7);

        autoPark.addToParkPlaces(new ParkPlace(1,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(2,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(3,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(4,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(5,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(6,autoPark.getParkId()));
        autoPark.addToParkPlaces(new ParkPlace(7,autoPark.getParkId()));

        return autoPark;
    }
}

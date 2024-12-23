package chapter5.strategy;

import java.util.Arrays;
import java.util.List;

public class Spacehip implements TransportVehicle {

    String name;
    private int fuelCapacity;
    private int cargoCapacity;
    private int passengerCount;
    private int speed;
    private int crewCount;

    public Spacehip(String name,int fuelCapacity, int cargoCapacity, int passengerCount, int speed, int crewCount) {
        this.name = name;
        this.fuelCapacity = fuelCapacity;
        this.cargoCapacity = cargoCapacity;
        this.passengerCount = passengerCount;
        this.speed = speed;
        this.crewCount = crewCount;
    }

    @Override
    public int getFuelCapacity() {
        return fuelCapacity;
    }

    @Override
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public int getPassengerCount() {
        return passengerCount;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getCrewCount() {
        return crewCount;
    }

    @Override
    public String toString() {
        return name + " [ FCap:"+fuelCapacity +
                        " CCap:" +cargoCapacity +
                        " Pssg:" +passengerCount +
                        " Speed:" +speed +
                        " Crew: " + crewCount + " ]";
    }

    public static void main(String[] args) {
        List<TransportVehicle> fleet = Arrays.asList(   new Spacehip("Falcon",200,500,4,40,4),
                                                        new Spacehip("Eagle",100,300,2,80,2),
                                                        new Spacehip("CosmicTiger",400,300,12,50,5),
                                                        new Spacehip("PhotonX",200,50,4,140,3),
                                                        new Spacehip("Spacelephant",600,750,2,20,8));

        fleet.forEach(System.out::println);

        PlanetTrader trader = new PlanetTrader();

        TransportVehicle v1 = trader.chooseSpacehipByCargoCapacity(fleet);

        System.out.println(v1);

        TransportVehicle v2 = trader.chooseVehicle(fleet,new SmartEvaluator());
        TransportVehicle v3 = trader.chooseVehicle(fleet,new FuelCapacityBasedEvaluator());

        System.out.println(v2);
        System.out.println(v3);

        // Anonymous class usage
        TransportVehicle v4 = trader.chooseVehicle(fleet, new VehicleEvaluator() {
            @Override
            public double evaluate(TransportVehicle v) {
                return v.getPassengerCount();
            }
        });

        // Lambda notation
        TransportVehicle v5 = trader.chooseVehicle(fleet, (v)-> {
                           return v.getPassengerCount();}
                           );

    }
}

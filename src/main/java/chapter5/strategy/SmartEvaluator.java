package chapter5.strategy;

public class SmartEvaluator implements VehicleEvaluator{
    @Override
    public double evaluate(TransportVehicle v) {
        return v.getPassengerCount() - v.getCrewCount() + v.getSpeed();
    }
}

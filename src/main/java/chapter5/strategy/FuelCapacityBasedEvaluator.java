package chapter5.strategy;

public class FuelCapacityBasedEvaluator implements VehicleEvaluator{
    @Override
    public double evaluate(TransportVehicle v) {
        return v.getFuelCapacity();
    }
}

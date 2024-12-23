package chapter5.strategy;

import java.util.List;

public class PlanetTrader {

    // Very naive implementation that requires different function for each different stragety
    TransportVehicle chooseSpacehipByFuelCapacity(List<TransportVehicle> fleet)
    {
        TransportVehicle best= null;

        for (TransportVehicle vehicle:fleet)
        {
            if (best==null|| best.getFuelCapacity()<vehicle.getFuelCapacity())
                best = vehicle;
        }
        return best;
    }

    // Very naive implementation that requires different function for each different stragety
    TransportVehicle chooseSpacehipByCargoCapacity(List<TransportVehicle> fleet)
    {
        TransportVehicle best= null;

        for (TransportVehicle vehicle:fleet)
        {
            if (best==null|| best.getCargoCapacity()<vehicle.getCargoCapacity())
                best = vehicle;
        }
        return best;
    }

    // Strategy pattern applied
    TransportVehicle chooseVehicle(List<TransportVehicle> fleet, VehicleEvaluator evaluator)
    {
        TransportVehicle best= null;
        double bestScore =0;

        for (TransportVehicle vehicle:fleet)
        {
            double score = evaluator.evaluate(vehicle);
            if (best==null|| bestScore<score) {
                best = vehicle;
                bestScore = score;
            }
        }

        return best;
    }

}

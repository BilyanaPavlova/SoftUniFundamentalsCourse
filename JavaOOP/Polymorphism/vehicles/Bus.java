package vehicles;

import java.text.DecimalFormat;

public class Bus extends VehicleImpl{

    private static final double ADDITIONAL_CONSUMPTION = 1.4;

    private boolean isEmpty = false;

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected double getAdditionalConsumption() {
        return ADDITIONAL_CONSUMPTION;
    }

    public String driveWithoutAdditionalConsumption(double distanceToTravel) {

        double actualConsumption = fuelConsumption;
        double actualFuelNeeded = distanceToTravel * actualConsumption;

        if (fuelQuantity < actualFuelNeeded) {
            return String.format (this.getClass().getSimpleName()+ Constants.NEEDS_REFUEL);
        }

        DecimalFormat df = new DecimalFormat("##.##"); //returns string
        this.fuelQuantity -= actualFuelNeeded;
        return String.format( this.getClass().getSimpleName()+ Constants.DISTANCE_TRAVELLED, df.format(distanceToTravel));
    }
}

package vehicles;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle{



    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double tankCapacity;

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity < 0) {
            throw new IllegalStateException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;

    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    // an abstract class can have a constructor. However, it's important to note that the constructor
// in an abstract class can't be used to create an instance of the abstract class itself
// (since abstract classes can't be instantiated directly).
// Instead, the constructor of an abstract class is called when an instance of a subclass is created.

    public VehicleImpl(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setFuelConsumption(fuelConsumption);
        setTankCapacity(tankCapacity);
    }

    //to get the concrete classes constants - override only this in the concrete classes!!!!
    protected double getAdditionalConsumption() {
        return 0;
    }

    @Override
    public String drive(double distanceToTravel) {

        double actualConsumption = fuelConsumption + this.getAdditionalConsumption();
        double actualFuelNeeded = distanceToTravel * actualConsumption;

        if (fuelQuantity < actualFuelNeeded) {
            return String.format (this.getClass().getSimpleName()+ Constants.NEEDS_REFUEL);
        }

        DecimalFormat df = new DecimalFormat("##.##"); //returns string
        this.fuelQuantity -= actualFuelNeeded;
        return String.format( this.getClass().getSimpleName()+ Constants.DISTANCE_TRAVELLED, df.format(distanceToTravel));
    }

    @Override
    public void refuel(double liters) {

        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        if (this.fuelQuantity + liters > this.tankCapacity) {
            throw new IllegalStateException("Cannot fit fuel in tank");
        }


        this.fuelQuantity += liters;

    }

    public void printVehicle() {
        System.out.println();
    }

    @Override
    public String toString() {
        return String.format(this.getClass().getSimpleName() + ": %.2f", fuelQuantity);
    }
}

package vehicles;

public class Car extends VehicleImpl{

    private static final double ADDITIONAL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected double getAdditionalConsumption() {
        return ADDITIONAL_CONSUMPTION;
    }
}

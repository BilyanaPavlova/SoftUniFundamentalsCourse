package vehicles;

public class Truck extends VehicleImpl{

        private static final double ADDITIONAL_CONSUMPTION = 1.6;
        private static final double HOLE_FACTOR = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
        public void refuel(double liters) {
            super.refuel(liters * HOLE_FACTOR );
        }

        @Override
        protected double getAdditionalConsumption() {
            return ADDITIONAL_CONSUMPTION;
        }
    }



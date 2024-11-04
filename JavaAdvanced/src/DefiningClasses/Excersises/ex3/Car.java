package DefiningClasses.Excersises.ex3;

public class Car {

    private String model;
    private double fuelAmount;
    private final double fuelCostFor1km;
    private double distanceTravelled;


    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTravelled = 0;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public String getModel() {
        return model;
    }

    public double getDistanceTravelled(){
        return distanceTravelled;
    }

    public void drive(double kms) {
        if (this.isEnoughFuel(kms)){
            this.distanceTravelled += kms;
            this.fuelAmount -= kms * this.fuelCostFor1km;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }

    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.getModel(), this.getFuelAmount(), this.getDistanceTravelled());
    }



    public boolean isEnoughFuel(double kms) {
        double fuelNeeded = this.fuelCostFor1km * kms;
        if (fuelNeeded > this.fuelAmount){
            return false;
        }
        return true;
    }
}

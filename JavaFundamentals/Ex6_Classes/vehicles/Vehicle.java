package Ex6_Classes.vehicles;

public class Vehicle {
    private String typeOfVehicle;
    private String modelOfVehicle;
    private String colorOfVehicle;
    private String horsepower;


    public Vehicle(String typeOfVehicle, String modelOfVehicle, String colorOfVehicle, String horsepower) {
        this.typeOfVehicle = typeOfVehicle;
        this.modelOfVehicle = modelOfVehicle;
        this.colorOfVehicle = colorOfVehicle;
        this.horsepower = horsepower;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public String getModelOfVehicle() {
        return modelOfVehicle;
    }

    public String getColorOfVehicle() {
        return colorOfVehicle;
    }

    public String getHorsepower() {
        return horsepower;
    }

    @Override
    public String toString() {
        String output = String.format("Type: %s\nModel: %s\nColor: %s\nHorsepower: %s",
                this.getTypeOfVehicle().substring(0, 1).toUpperCase() + this.getTypeOfVehicle().substring(1).toLowerCase(),
                this.getModelOfVehicle().substring(0, 1).toUpperCase() + this.getModelOfVehicle().substring(1).toLowerCase(),
                this.getColorOfVehicle(),
                this.getHorsepower());
        return output;
    }

}

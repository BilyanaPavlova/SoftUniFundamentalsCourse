package DefiningClasses.Excersises.ex5;

public class Engine {

    //An Engine has a model, power, displacement, and efficiency
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency){
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    //Engine displacements, and efficiency are optional.
    public Engine(String model, int power){
        this(model, power, 0, "n/a");
    }

    public Engine(String model, int power, int displacement){
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency){
        this(model, power, 0, efficiency);
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

@Override
    public String toString() {
        return String.format("%s:%nPower: %d%nDisplacement: %d%nEfficiency: %s",
                this.getModel(), this.getPower(), this.getDisplacement(), this.getEfficiency());
    }



}

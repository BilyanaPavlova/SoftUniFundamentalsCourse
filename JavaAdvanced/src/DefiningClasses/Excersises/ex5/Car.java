package DefiningClasses.Excersises.ex5;

public class Car {

    private String model;
    private Engine engine;
    private double weight;
    private String color;

    //A Car's weight, color, Engine displacements, and efficiency are optional.
    public Car(String model, Engine engine, double weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, 0, color);

    }

    public Car(String model, Engine engine, double weight) {
        this(model, engine, weight, "n/a");
    }


    public Car(String model, Engine engine) {
        this(model, engine, 0, "n/a");
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {

    String displacement = this.getEngine().getDisplacement() == 0 ? "n/a" : String.valueOf(this.getEngine().getDisplacement());
    String weight = this.getWeight() == 0 ? "n/a" : String.format("%.0f", this.getWeight());
    String color = this.getColor().equals("n/a") ? "n/a" : this.getColor();
    String efficiency = this.getEngine().getEfficiency().equals("n/a") ? "n/a" : this.getEngine().getEfficiency();

    return String.format("%s:\n" +
            "%s:\n" +
            "Power: %d\n" +
            "Displacement: %s\n" +
            "Efficiency: %s\n" +
            "Weight: %s\n" +
            "Color: %s\n", this.getModel(), this.getEngine().getModel(),
            this.getEngine().getPower(), displacement,
            efficiency, weight, color);
}
}

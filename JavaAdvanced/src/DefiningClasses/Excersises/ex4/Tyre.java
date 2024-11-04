package DefiningClasses.Excersises.ex4;

public class Tyre {

    private  double tyrePressure;
    private int tyreAge;

    public Tyre(int tyreAge, double tyrePressure) {
        this.tyreAge = tyreAge;
        this.tyrePressure = tyrePressure;
    }

    public int getTyreAge() {
        return tyreAge;
    }

    public void setTyreAge(int tyreAge) {
        this.tyreAge = tyreAge;
    }

    public double getTyrePressure() {
        return tyrePressure;
    }

    public void setTyrePressure(double tyrePressure) {
        this.tyrePressure = tyrePressure;
    }
}

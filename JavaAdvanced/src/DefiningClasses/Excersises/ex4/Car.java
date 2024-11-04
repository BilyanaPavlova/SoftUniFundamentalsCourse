package DefiningClasses.Excersises.ex4;

import java.util.LinkedList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tyre tyre1;
    private Tyre tyre2;
    private Tyre tyre3;
    private Tyre tyre4;
    private List<Tyre> tyres = new LinkedList<>();

    public Car(String model, Engine engine, Cargo cargo, Tyre tyre1, Tyre tyre2, Tyre tyre3, Tyre tyre4) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyre1 = tyre1;
        this.tyre2 = tyre2;
        this.tyre3 = tyre3;
        this.tyre4 = tyre4;
        tyres.add(tyre1);
        tyres.add(tyre2);
        tyres.add(tyre3);
        tyres.add(tyre4);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tyre getTyre1() {
        return tyre1;
    }

    public void setTyre1(Tyre tyre1) {
        this.tyre1 = tyre1;
    }

    public Tyre getTyre2() {
        return tyre2;
    }

    public void setTyre2(Tyre tyre2) {
        this.tyre2 = tyre2;
    }

    public Tyre getTyre3() {
        return tyre3;
    }

    public void setTyre3(Tyre tyre3) {
        this.tyre3 = tyre3;
    }

    public Tyre getTyre4() {
        return tyre4;
    }

    public void setTyre4(Tyre tyre4) {
        this.tyre4 = tyre4;
    }

    public List<Tyre> getTyres(){
        return this.tyres;
    }
}

package DefiningClasses.Excersises.ex4;

public class Engine {
    private int enginePower;
    private int engineSpeed;

    public Engine(int enginePower, int engineSpeed) {
        this.enginePower = enginePower;
        this.engineSpeed = engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }
}

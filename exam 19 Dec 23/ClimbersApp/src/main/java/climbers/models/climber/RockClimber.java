package climbers.models.climber;

public class RockClimber extends BaseClimber{

    private final int DECREASE_FACTOR = 60;

    public RockClimber(String name) {
        super(name, 120);
    }

    @Override
    public void climb() {
        this.strength -= DECREASE_FACTOR;
        if(this.strength < 0) {
            this.strength = 0;
        }
    }
}

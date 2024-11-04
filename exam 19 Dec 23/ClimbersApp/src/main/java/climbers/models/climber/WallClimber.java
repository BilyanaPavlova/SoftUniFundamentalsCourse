package climbers.models.climber;

public class WallClimber extends BaseClimber{

    private final int DECREASE_FACTOR = 30;

    public WallClimber(String name) {
        super(name, 90);
    }

    @Override
    public void climb() {
        this.strength -= DECREASE_FACTOR;
        if(this.strength < 0) {
            this.strength = 0;
        }

    }


}

package climbers.models.climber;

import climbers.models.roster.Roster;
import climbers.models.roster.RosterImpl;

import java.util.Collection;
import java.util.List;

import static climbers.common.ExceptionMessages.*;

public abstract class BaseClimber implements Climber{

    String name;
    double strength;
    Roster roster;

    protected void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(CLIMBER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setStrength(double strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(CLIMBER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    protected BaseClimber(String name, double strength) {
        setName(name);
        setStrength(strength);
        this.roster = new RosterImpl();

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getStrength() {
        return this.strength;
    }

    @Override
    public boolean canClimb() {
        return this.strength > 0;
    }

    @Override
    public Roster getRoster() {
        return this.roster;
    }


}

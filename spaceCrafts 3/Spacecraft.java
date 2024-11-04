package spaceCrafts;

import java.util.HashSet;
import java.util.Set;

public class Spacecraft {
    private String name;
    private String missionType;
    private String target;
    private String objective;
    private int weight;
    private static Set<String> nameSet = new HashSet<>();

    public Spacecraft(String name, String missionType, String target, String objective, int weight) {

        if (nameSet.contains(name)) {
            throw new IllegalArgumentException("Name already exists: " + name);
        }

        this.name = name;
        this.missionType = missionType;
        this.target = target;
        this.objective = objective;
        this.weight = weight;
        nameSet.add(name);
    }



    public String getName() {
        return name;
    }

    public String getMissionType() {
        return missionType;
    }

    public String getTarget() {
        return target;
    }

    public String getObjective() {
        return objective;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        if (nameSet.contains(name)) {
            throw new IllegalArgumentException("Name already exists: " + name);
        }
        nameSet.remove(this.name);
        this.name = name;
        nameSet.add(name);
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "The mission of " + this.name + " was to reach " + this.target + " and to " + this.objective;
    }

}


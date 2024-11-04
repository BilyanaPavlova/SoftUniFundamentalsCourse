package exam.april_10_24.task03.spaceCrafts;

public class Spacecraft {

    String name;
    String missionType;
    String target;
    String objective;
    int weight;

    @Override
    public String toString() {
        return String.format("The mission of %s was to reach %s and to %s", this.name, this.target, this.objective);


    }

    public Spacecraft(String name, String missionType, String objective, String target, int weight) {
        setName(name);
        setMissionType(missionType);
        setObjective(objective);
        setWeight(weight);
        setTarget(target);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMissionType() {
        return missionType;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

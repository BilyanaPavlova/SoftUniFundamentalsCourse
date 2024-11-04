package spaceCrafts;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class LaunchPad {

    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        spacecrafts = new LinkedList<>();
    }

    //    •	Method addSpacecraft(Spacecraft spacecraft) – adds an entity to the data
//    if a space for it, otherwise print: "This launchpad is at full capacity!"
    public void addSpacecraft(Spacecraft spacecraft) {
        if (this.spacecrafts.size() < capacity) {
            spacecrafts.add(spacecraft);
        } else {
            System.out.println("This launchpad is at full capacity!");
        }
    }

//    Method removeSpacecraft(String name) – removes a Spacecraft by given name, if such exists,
//    and returns boolean (true if it is removed, otherwise – false)

    public boolean removeSpacecraft(String name) {
        Optional<Spacecraft> foundSpacecrasft = this.spacecrafts.stream()
                .filter(spacecraft -> spacecraft.getName().equals(name))
                .findAny();

        if (foundSpacecrasft.isEmpty()) {
            return false;
        }

        this.spacecrafts.remove(foundSpacecrasft.get());
        return true;
    }

//•	Method getHeaviestSpacecraft()– returns String the heaviest spacecraft by weight in the given launchpad
// in the following format:
//	"{spaceCraft name} - {spaceCraft weight}kg."

    public String getHeaviestSpacecraft() {
        // Find the heaviest spacecraft
        Optional<Spacecraft> heaviestSpacecraft = this.spacecrafts.stream()
                .max(Comparator.comparingInt(Spacecraft::getWeight))
                .stream().findFirst();

        // Create the result string
        String result = heaviestSpacecraft
                .map(spacecraft -> spacecraft.getName() + " - " + spacecraft.getWeight() + "kg.")
                .orElse("No spacecraft found");

    return result;
    }

//    Method getSpacecraft(String name) – returns the spacecraft with the given name, otherwise – returns null
    public Spacecraft getSpacecraft(String name) {
        Spacecraft match = this.spacecrafts.stream().
                filter(spacecraft -> spacecraft.getName().equals(name))
                .findFirst()
                .orElse(null);
        return match;
    }

//    •	Method getCount() – returns the count of spacecrafts in the given launchpad
    public int getCount() {
        return this.spacecrafts.size();
    }

//    •	Method getSpacecraftsByMissionType(String missionType) – returns List – a collection of Spacecraft
//    which holds the spacecrafts having the same missionType in the given launchpad.
//
//In case there are no spacecrafts to respond to this condition (missionType) print:
//o	"There are no spacecrafts to respond this criteria."

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> result = this.spacecrafts.stream()
                .filter(spacecraft -> spacecraft.getMissionType().equals(missionType))
                .toList();

        if (result.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
        }

        return result;
    }

//    •	Method getStatistics() – returns a String in the following format (print the spacecrafts in order of addition):
//o	"Spacecrafts launched from {launchpad name}:1. {spacecraft name}2. {spacecraft name} (…)
//a.	{spacecraft name}"
//If there are no spacecrafts in some launchpad print:
//o	"Spacecrafts launched from {launchpad name}:
//none"

  public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Spacecrafts launched from ").append(this.name).append(":");
        if (this.spacecrafts.isEmpty()) {
            sb.append("\nnone");
        } else {
            int[] count = {1};
            this.spacecrafts.forEach(spacecraft -> {
                sb.append("\n").append(count[0]++).append(". ").append(spacecraft.getName());
            });
        }
        return sb.toString();
    }


}

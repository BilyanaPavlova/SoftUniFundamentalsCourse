package exam.april_10_24.task03.spaceCrafts;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LaunchPad {
    String name;
    int capacity;
    List<Spacecraft> spacecrafts;

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.spacecrafts = new LinkedList<>();
    }

    //•	Method addSpacecraft(Spacecraft spacecraft) – adds an entity to the data if a space for it, otherwise print: "This launchpad is at full capacity!"
    public void addSpacecraft(Spacecraft spacecraft) {
        if (this.spacecrafts.size() < this.capacity) {
            this.spacecrafts.add(spacecraft);
        } else {
            System.out.println("This launchpad is at full capacity!"
            );
        }
    }

    //•	Method removeSpacecraft(String name) – removes a Spacecraft by given name, if such exists, and returns boolean (true if it is removed, otherwise – false)
    public boolean removeSpacecraft(String name) {
        return this.spacecrafts.removeIf(spacecraft -> spacecraft.getName().equals(name));
    }

    //•	Method getHeaviestSpacecraft()– returns String the heaviest spacecraft by weight in the given launchpad in the following format:
    //o	"{spaceCraft name} - {spaceCraft weight}kg."
    public String getHeaviestSpacecraft() {
        Spacecraft heaviest = this.spacecrafts.stream()
                .max(Comparator.comparing(Spacecraft::getWeight))
                .orElse(null);

        return String.format(heaviest.getName() + " - " + heaviest.getWeight() + "kg.");
    }

    //•	Method getSpacecraft(String name) – returns the spacecraft with the given name, otherwise – returns null
    public Spacecraft getSpacecraft(String name) {
        return this.spacecrafts.stream()
                .filter(spacecraft -> spacecraft.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    //Method getCount() – returns the count of spacecrafts in the given launchpad
    public int getCount() {
        return this.spacecrafts.size();
    }

    //•	Method getSpacecraftsByMissionType(String missionType) – returns List – a collection of Spacecraft which holds the spacecrafts having the same missionType in the given launchpad.
    //
    //In case there are no spacecrafts to respond to this condition (missionType) print:
    //o	"There are no spacecrafts to respond to the criteria."

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> filteredSpacecrafts = this.spacecrafts.stream()
                .filter(spacecraft -> spacecraft.getMissionType().equals(missionType))
                .collect(Collectors.toList());

        if (filteredSpacecrafts.isEmpty()) {
            System.out.println("There are no spacecrafts to respond this criteria.");
            return Collections.emptyList();
        }

        return filteredSpacecrafts;
    }

    //•	Method getStatistics() – returns a String in the following format (print the spacecrafts in order of addition):
    //o	"Spacecrafts launched from {launchpad name}:1. {spacecraft name}2. {spacecraft name} (…)
    //a.	{spacecraft name}"
    //If there are no spacecrafts in some launchpad print:
    //o	"Spacecrafts launched from {launchpad name}:
    //none"


    public String getStatistics() {
        StringBuilder strb = new StringBuilder("Spacecrafts launched from ");
        strb.append(this.name)
                .append(":");

        if (this.spacecrafts.isEmpty()) {
            strb.append("\nnone");
        } else {
            for (int i = 0; i < this.spacecrafts.size(); i++) {
                strb.append("\n")
                        .append(i + 1)
                        .append(". ")
                        .append(this.spacecrafts.get(i).getName());
            }
        }

        return strb.toString();
    }




}

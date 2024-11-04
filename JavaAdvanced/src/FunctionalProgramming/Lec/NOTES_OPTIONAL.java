package FunctionalProgramming.Lec;

public class NOTES_OPTIONAL {

    /*
    * you can use the map method on Optional objects in Java.
    * The map method is used to transform the value inside the Optional if it is present.
    * If the Optional is empty, the transformation is not applied, and an empty Optional is returned.

How map Works with Optional
The map method takes a Function as an argument.
* This function is applied to the value inside the Optional if it is present, and the result is wrapped in a new Optional.
* If the Optional is empty, map returns an empty Optional.

Example with Optional.map
Here’s a simple example to demonstrate how you can use map with Optional:

java
Copy code
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Create a list of Spacecraft objects
        List<Spacecraft> spacecraftList = Arrays.asList(
            new Spacecraft("Apollo 11", "Lunar", "Moon", "land on the moon", 30000),
            new Spacecraft("Voyager 1", "Interstellar", "Outer Solar System", "explore outer planets", 722),
            new Spacecraft("Hubble", "Telescope", "Orbit", "observe distant galaxies", 11110),
            new Spacecraft("SpaceX", "Mars", "Mars", "colonize Mars", 30000) // Same weight as Apollo 11
        );

        // Find the heaviest spacecraft
        Optional<Spacecraft> heaviestSpacecraft = spacecraftList.stream()
            .max(Comparator.comparingInt(Spacecraft::getWeight));

        // Use map to transform the Optional value - returns string in 2 cases :either if there is an optional, that is string, either empty optional and then the other string
        String result = heaviestSpacecraft
            .map(spacecraft -> spacecraft.getName() + " - " + spacecraft.getWeight() + "kg.")
            .orElse("No spacecraft found");

        // Print the result
        System.out.println(result);
    }
}

class Spacecraft {
    private String name;
    private String missionType;
    private String target;
    private String objective;
    private int weight;

    public Spacecraft(String name, String missionType, String target, String objective, int weight) {
        this.name = name;
        this.missionType = missionType;
        this.target = target;
        this.objective = objective;
        this.weight = weight;
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

    @Override
    public String toString() {
        return "The mission of " + name + " was to reach " + target + " and to " + objective;
    }
}
Explanation
Finding the Heaviest Spacecraft:

heaviestSpacecraft is an Optional<Spacecraft> which may or may not contain a Spacecraft.
Using map to Transform the Optional:

heaviestSpacecraft.map(spacecraft -> spacecraft.getName() + " - " + spacecraft.getWeight() + "kg.") transforms the Optional<Spacecraft>
* into an Optional<String> if the Optional is present.
The lambda expression provided to map creates a string with the spacecraft's name and weight.
Using orElse to Provide a Default Value:

If heaviestSpacecraft is empty, orElse provides the default string "No spacecraft found".
If heaviestSpacecraft contains a value, the transformed string is returned.
Summary
Using map with Optional is a powerful way to apply transformations only if a value is present,
* and to handle empty cases cleanly without the need for explicit null checks.
    * */
}

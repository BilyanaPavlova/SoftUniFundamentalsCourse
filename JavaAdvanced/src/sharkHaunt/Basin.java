package sharkHaunt;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Basin {
    //•	name: String
    //•	capacity: int
    //•	sharks: List<Shark>
    String name;
    int capacity;
    List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new LinkedList<>();
    }

    //•	Method addShark(Shark shark) – adds an entity to the data if a space for it,
    // otherwise print: "This basin is at full capacity!"
    public void addShark(Shark shark) {
        if (this.sharks.size() < capacity) {
            sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }


    //•	Method removeShark(String kind) – removes a shark by given kind, if such exists,
    // and returns boolean (true if it is removed, otherwise – false)

    public boolean removeShark(String kind) {
        return sharks.removeIf(sh -> sh.getKind().equals(kind));
    }

    //•	Method getLargestShark()– returns the largest shark by length in the given basin
    public Shark getLargestShark() {
        return this.sharks.stream()
                .max(Comparator.comparing(Shark::getLength))
                .orElse(null);
    }

    //•	Method getShark(String kind) – returns the shark with the given kind, otherwise – returns null
    public Shark getShark(String kind) {
        return this.sharks.stream()
                .filter(shark -> shark.getFood().equals(kind))
                .findFirst()
                .orElse(null);
    }

    //•	Method getCount – returns the count of sharks in the given basin
    public int getCount() {
        return this.sharks.size();
    }

    //•	Method getAverageLength – returns integer - the average length of the sharks in the given basin
    public int getAverageLength() {

        if (this.sharks.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (Shark sh : this.sharks) {
            sum += sh.getLength();
        }
        return sum / this.sharks.size();

    }

    //•	Method report() – returns a string in the following format (print the sharks in order of addition):
    //o	"Sharks in {basin name}:The {kind} is {length} centimeters long, eats {food} and inhabits {habitation}.
    // The {kind} is {length} centimeters long, eats {food} and inhabits {habitation}.
    // (…)"

    public String report() {
        StringBuilder report = new StringBuilder("Sharks in " + this.name + ":");
        report.append(System.lineSeparator());
        for (Shark sh : this.sharks) {
            report.append("The ").append(sh.getKind())
                    .append(" is ").append(sh.getLength())
                    .append(" centimeters long, eats ").append(sh.getFood())
                    .append(" and inhabits ").append(sh.getHabitation())
                    .append(". ")
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}

package fishingPond;

import java.util.LinkedList;
import java.util.List;

public class Pond {

    private int capacity;
    private List<Fish> fishes;

    public Pond(int capacity) {
        this.capacity = capacity;
        this.fishes = new LinkedList<>();
    }

    public void addFish(Fish fish) {
        if (this.fishes.size() < capacity) {
            this.fishes.add(fish);
        }
    }

    public boolean removeFish(String species) {
        return fishes.removeIf(f -> f.getSpecies().equals(species));
    }

    public Fish getOldestFish() {
        return this.fishes.stream()
                .max((f1, f2) -> Integer.compare(f1.getAge(), f2.getAge()))
                .orElse(null);
    }

    public Fish getFish(String species) {

        return this.fishes.stream()
                .filter(f -> f.getSpecies().equals(species))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return this.fishes.size();
    }

    public int getVacancies() {
        return this.capacity - this.fishes.size();
    }

    public String report() {
        StringBuilder report = new StringBuilder("Fishes in the pond:\n");
        for (Fish fish : fishes) {
            report.append(fish.toString())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}

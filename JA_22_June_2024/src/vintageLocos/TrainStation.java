package vintageLocos;

import java.util.LinkedList;
import java.util.List;

public class TrainStation {



        private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = locomotives = new LinkedList<>();
    }



    public void addLocomotive(Locomotive locomotive) {
        if (this.locomotives.size() < this.capacity) {
            if (this.railGauge == locomotive.getGauge()) {
                locomotives.add(locomotive);
            } else {
                int difference = Math.abs(this.railGauge - locomotive.getGauge());
                System.out.printf("The rail gauge of this station does not match the locomotive gauge! Difference: %d mm.\n", difference);
            }
        } else {
            System.out.println("This train station is full!");
        }
    }

    public boolean removeLocomotive(String name){
        return locomotives.removeIf( l -> l.getName().equals(name));
    }

    public String getFastestLocomotive() {
        return locomotives.stream()
                .max((l1, l2) -> Integer.compare(l1.getMaxSpeed(), l2.getMaxSpeed()))
                .map(l -> String.format("%s is the fastest locomotive with a maximum speed of %d km/h.", l.getName(), l.getMaxSpeed()))
                .orElse("There are no locomotives.");
    }

    public Locomotive getLocomotive(String name){
        return this.locomotives.stream()
                .filter(l -> l.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return this.locomotives.size();
    }

    public String getOldestLocomotive(){
        return locomotives.stream()
                .min((l1, l2) -> l1.getBuildDate().compareTo(l2.getBuildDate()))
                .map(Locomotive::getName)
                .orElse("There are no locomotives.");
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        if (!this.locomotives.isEmpty()) {
            String str1 = String.format("Locomotives departed from %s:\n", this.name);
            sb.append(str1);
            int counter = 1;
            for (Locomotive loco : this.locomotives) {
                sb.append(String.format("%d. %s\n", counter++, loco.getName()));
            }
            return sb.toString();
        } else {
            sb.append(String.format("There are no locomotives departing from %s station.", this.name));
        }
        return sb.toString();
    }



}

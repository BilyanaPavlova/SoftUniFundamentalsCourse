package surfers;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Beach {

    private String name;
    private int surfboardsForRent;
    private List<Surfer> surfers;

    public Beach(String name, int surfboardsForRent) {
        this.name = name;
        this.surfboardsForRent = surfboardsForRent;
        this.surfers = new LinkedList<>();
    }

    public String addSurfer(Surfer surfer) {

        if (surfer.getOwnsASurfBoard()) {
            this.surfers.add(surfer);
            return String.format("Surfer %s added.", surfer.getName());

        }

        if (surfer.getMoney() >= 50) {
            if (this.surfboardsForRent > 0) {
                this.surfboardsForRent--;
                surfer.setMoney(surfer.getMoney() - 50);
                surfers.add(surfer);
                return String.format("Surfer %s added.", surfer.getName());
            } else {
                return "There are no free surfboards.";
            }

        } else {
            return String.format("%s has not enough money to rent a surfboard.", surfer.getName());
        }
    }

    public boolean removeSurfer(String name) {
        return this.surfers.removeIf(s -> s.getName().equals(name));
    }

    public String getMostExperiencedSurfer() {
        if (this.surfers.isEmpty()) {
            return "There are no surfers.";
        }

        Surfer mostExperiencedSurfer = this.surfers.stream()
                .max((s1, s2) -> Integer.compare(s1.getExperience(), s2.getExperience()))
                .orElse(null);

        return String.format("%s is most experienced surfer with %d years experience.",
                mostExperiencedSurfer.getName(), mostExperiencedSurfer.getExperience());
    }

    public Surfer getSurfer(String name) {
        return this.surfers.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return this.surfers.size();
    }

    public String getSurfersWithPersonalSurfboards(){
        if (this.surfers.isEmpty()) {
            return "There are no surfers.";
        }

        List<Surfer> withBoards = this.surfers.stream()
                .filter(Surfer::getOwnsASurfBoard)
                .toList();


        String surferNames = withBoards.stream()
                .map(Surfer::getName)
                .collect(Collectors.joining(", "));

        return String.format("Surfers who have their own surfboards: %s", surferNames);

    }

    public String getReport() {
        if (this.surfers.isEmpty()) {
            return String.format("There are no surfers on %s beach.", this.name);
        }

        StringBuilder sb = new StringBuilder(String.format("Beach %s was visited by the following surfers:\n", this.name));
        int num = 1;
        for (Surfer surfer : this.surfers) {
            if (surfer.getExperience() == 0) {
                sb.append(String.format("%d. %s with no experience.\n", num, surfer.getName()));
            } else {
                sb.append(String.format("%d. %s with %d years experience.\n", num, surfer.getName(), surfer.getExperience()));
            }
            num++;
        }

        return sb.toString().trim();
    }


    }




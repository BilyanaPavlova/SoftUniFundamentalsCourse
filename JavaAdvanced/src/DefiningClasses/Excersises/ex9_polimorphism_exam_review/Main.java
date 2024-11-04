package DefiningClasses.Excersises.ex9_polimorphism_exam_review;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Cat> cats = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double special = Double.parseDouble(tokens[2]);

            Cat cat = switch (breed) {
                case "Siamese" -> new Siamese(name, breed, special);
                case "Cymric" -> new Cymric(name, breed, special);
                case "StreetExtraordinaire" -> new StreetExtraordinaire(name, breed, special);
                default -> null;
            };

            cats.add(cat);

            input = scanner.nextLine();
        }


        String desiredCat = scanner.nextLine();

        Cat cat = cats.stream()
                .filter(c -> c.getName().equals(desiredCat))
                .findFirst()
                .get();

        System.out.println(cat.toString());

    }
}

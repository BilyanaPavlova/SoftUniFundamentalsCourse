package Ex6_Classes;

import java.util.*;

public class Random_Generator {
    public static void main(String[] args) {


        List<String> phrases = Arrays.asList("Excellent product.", "Such a great product.",
                "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product.");

        List<String> events = Arrays.asList("Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!");

        List<String> names = Arrays.asList("Diana", "Petya", "Stella", "Elena",
                "Ktaya", "Iva", "Annie", "Eva");

        List<String> cities = Arrays.asList("Burgas", "Sofia", "Plovdiv", "Varna", "Ruse");

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Random rdm = new Random();


        for (int i = 0; i < n; i++) {
            String phrase = phrases.get(rdm.nextInt(phrases.size()));
            String event = events.get(rdm.nextInt(events.size()));
            String name = names.get(rdm.nextInt(names.size()));
            String city = cities.get(rdm.nextInt(cities.size()));
            String output = String.format("%s %s %s - %s",
                    phrase, event, name, city);
            System.out.println(output);
        }


    }
}

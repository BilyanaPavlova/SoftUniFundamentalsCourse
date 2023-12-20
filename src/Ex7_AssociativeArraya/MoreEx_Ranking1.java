package Ex7_AssociativeArraya;

import java.util.*;

public class MoreEx_Ranking1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contests = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> submissions = new LinkedHashMap<>();

        // Read contests
        String input;
        while (!(input = scanner.nextLine()).equals("end of contests")) {
            String[] tokens = input.split(":");
            String contest = tokens[0];
            String password = tokens[1];
            contests.put(contest, password);
        }

        // Read submissions
        while (!(input = scanner.nextLine()).equals("end of submissions")) {
            String[] tokens = input.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String username = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if (contests.containsKey(contest) && contests.get(contest).equals(password)) {
                submissions.putIfAbsent(username, new HashMap<>());
                submissions.get(username).put(contest, submissions.get(username).getOrDefault(contest, 0) + points);
            }
        }

        // Find the best candidate
        String bestCandidate = "";
        int maxPoints = Integer.MIN_VALUE;

        for (Map.Entry<String, Map<String, Integer>> entry : submissions.entrySet()) {
            int totalPoints = entry.getValue().values().stream().mapToInt(Integer::intValue).sum();
            if (totalPoints > maxPoints) {
                maxPoints = totalPoints;
                bestCandidate = entry.getKey();
            }
        }

        // Print the best candidate
        System.out.println("Best candidate is " + bestCandidate + " with total " + maxPoints + " points.");

        // Print all students ordered by names and their contests with points
        submissions.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(studentEntry -> {
                    System.out.println(studentEntry.getKey());
                    studentEntry.getValue().entrySet().stream()
                            .sorted((c1, c2) -> Integer.compare(c2.getValue(), c1.getValue()))
                            .forEach(contestEntry ->
                                    System.out.printf("#  %s -> %d%n", contestEntry.getKey(), contestEntry.getValue())
                            );
                });
    }
}


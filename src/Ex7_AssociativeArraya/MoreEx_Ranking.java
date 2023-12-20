package Ex7_AssociativeArraya;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class MoreEx_Ranking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> validContests = new LinkedHashMap<>();

        //contest - (username - pointsInContest)
        Map<String, LinkedHashMap<String, Integer>> contestUserPoints = new LinkedHashMap<>();
        Map<String, Integer> usersTotalPoints = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("end of contests")) {
            String contest = input.split(":")[0];
            String password = input.split(":")[1];

            validContests.put(contest, password);
            input = sc.nextLine();
        }

        String input2 = sc.nextLine();
        while (!input2.equals("end of submissions")) {
            String contest = input2.split("=>")[0];
            String password = input2.split("=>")[1];
            String userName = input2.split("=>")[2];
            int points = Integer.parseInt(input2.split("=>")[3]);

            if (validContests.containsKey(contest) && validContests.get(contest).equals(password)) {

                if(usersTotalPoints.containsKey(userName)) {
                    usersTotalPoints.put(userName, usersTotalPoints.get(userName) + points);
                }
                usersTotalPoints.putIfAbsent(userName, points);

                contestUserPoints.putIfAbsent(contest, new LinkedHashMap<>());
                contestUserPoints.get(contest).putIfAbsent(userName, points);

                if (contestUserPoints.get(contest).get(userName) < points) {
                    contestUserPoints.get(contest).put(userName, points);
                }

            }
            input2 = sc.nextLine();

        }
//
//        int max = findMaxValue(usersTotalPoints);
//        String maxUser = findMaxUser(usersTotalPoints, max);
//        System.out.printf("Best candidate is %s with total %d points.", maxUser, max);

        for (Map.Entry<String, LinkedHashMap<String, Integer>>entry:
             contestUserPoints.entrySet()) {
            for (Map.Entry<String, Integer>entry1:
                 entry.getValue().entrySet()) {
                System.out.println(entry1.getKey());
                System.out.println("# " + entry.getKey() + " -> " + entry1.getValue());
            }
        }

    }

    private static String findMaxUser(Map<String, Integer> map, int max) {
        String maxUser = "";
        for (Map.Entry<String, Integer> entry :
                map.entrySet()) {
            if (entry.getValue().equals(max)) {
                 maxUser = entry.getKey();
            }
        }
        return maxUser;
    }



    private static int findMaxValue(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            // Handle the case when the map is empty or null
            throw new IllegalArgumentException("The map is empty or null.");
        }

        // Initialize max with the first value
        int max = map.values().iterator().next();

        // Iterate over the values and find the maximum
        for (int value : map.values()) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }



    }


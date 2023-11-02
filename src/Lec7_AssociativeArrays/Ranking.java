package Lec7_AssociativeArrays;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> contest = new HashMap<>();

        String input = sc.nextLine();
        while (true) {
            if (input.equals("end of contests")) {
                break;
            }
            String[] inp = input.split(":");
            contest.put(inp[0], inp[1]);
            input = sc.nextLine();
        }

        TreeMap<String, List> users = new TreeMap<>();
        String input2 = sc.nextLine();
        while (true) {
            if (input.equals("end of submissions")) {
//                ....
                break;
            }
            String[] data = input2.split("=>");
            String contestName = data[0];
            String password = data[1];
            String userName = data[2];
            String points = data[3];


        }
    }
}

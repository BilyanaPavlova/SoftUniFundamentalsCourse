package Ex7_AssociativeArraya;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        LinkedHashMap<String, String> users = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {

            String [] input = sc.nextLine().split(" ");

            if (input[0].equals("register")){
                if(users.containsKey(input[1])){
                    System.out.printf("ERROR: already registered with plate number %s\n", users.get(input[1]));

                    continue;
                }
                users.putIfAbsent(input[1], input[2]);
                System.out.printf("%s registered %s successfully\n", input[1], input[2]);
            }

            if (input[0].equals("unregister")){
                if(!users.containsKey(input[1])){
                    System.out.printf("ERROR: user %s not found\n", input[1]);
                    continue;
                }
                users.remove(input[1]);
                System.out.printf("%s unregistered successfully\n", input[1]);
            }
        }

        for(Map.Entry<String, String> entry : users.entrySet()){
            System.out.printf("%s => %s\n", entry.getKey(), entry.getValue());
        }
    }
}

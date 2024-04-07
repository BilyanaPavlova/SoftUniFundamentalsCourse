package Sets_And_Maps.problems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06_PhoneBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();


        Map<String, String> phonebook = new LinkedHashMap<>();


        while (!input.equals("search")) {
            String[] data = input.split("-");
            phonebook.put(data[0], data[1]);
            input = sc.nextLine();

        }


        input = sc.nextLine();
        boolean flag = false;
        while (!input.equals("stop")) {

            for (Map.Entry<String, String> entry : phonebook.entrySet()) {
                if (input.equals(entry.getKey())) {
                    flag = true;
                    System.out.println(input + " -> " + entry.getValue());

                }

                }

            if(!flag) {
                System.out.println("Contact " + input + " does not exist.");
            }
            input = sc.nextLine();
            flag = false;
        }


    }
}

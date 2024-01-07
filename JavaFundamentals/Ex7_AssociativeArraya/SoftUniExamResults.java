package Ex7_AssociativeArraya;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map <String, Integer> results = new LinkedHashMap<>();
        Map <String, Integer> submissions = new LinkedHashMap<>();


        String input = sc.nextLine();

        while(true){

            if(input.equals("exam finished")){
                //print

                System.out.println("Results:");
                for(Map.Entry<String, Integer> entry : results.entrySet()){
                    System.out.printf("%s | %d\n", entry.getKey(), entry.getValue());
                }

                System.out.println("Submissions:");
                for(Map.Entry<String, Integer> entry : submissions.entrySet()){
                    System.out.printf("%s - %d\n", entry.getKey(), entry.getValue());
                }

                return;
            }

            String[] inp = input.split("-");
            String userName = "";
            String language = "";
            Integer points = 0;

            if (inp.length == 3) {
                userName = inp[0];
                language = inp[1];
                points = Integer.parseInt(inp[2]);
            }

            if (inp.length == 2 && input.contains("banned")) {
                userName = inp[0];
                results.remove(userName);
                input = sc.nextLine();
                continue;
            }


            if(!results.containsKey(userName)){
                results.put(userName, points);
            } else {
                if(results.get(userName) < points){
                    results.put(userName, points);
                }
            }

            if(!submissions.containsKey(language)) {
                submissions.put(language, 1);
            } else{
                submissions.put(language, submissions.get(language) + 1);
            }

            input = sc.nextLine();
        }
    }
}

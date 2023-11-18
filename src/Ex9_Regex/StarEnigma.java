package Ex9_Regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        // foreach input line
        for (int i = 0; i < n; i++) {
            int count = 0;
            String input = sc.nextLine();
            char[]chars = input.toCharArray();

            //foreach char form the line
            for (int j = 0; j < chars.length; j++) {
                if(chars[j] == 's' ||chars[j] == 'S'
                        ||chars[j] == 't' ||chars[j] == 'T'
                        ||chars[j] == 'a' ||chars[j] == 'A'
                        ||chars[j] == 'r' || chars[j] == 'R'){
                    count++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char ch :
                    chars) {
               int newAscii = (int)ch - (int)count;
               char newChar = (char) newAscii;
               sb.append(newChar);
            }
//            System.out.println(sb);

            // validation of the decrypted string (sb)

            Pattern pattern = Pattern.compile("([^@\\-!:>]+)*" +
                    "@(?<planet>[A-Za-z]+)([^@\\-!:>]+)*" +
                    ":(?<population>\\d+)([^@\\-!:>]+)*" +
                    "!(?<attackType>A?|D?)!([^@\\-!:>]+)*" +
                    "->(?<soldiers>\\d+)([^@\\-!:>]+)*");

            Matcher matcher = pattern.matcher(sb.toString());

            String plan = "";
            String popul = "";
            String attackT = "";
            String sold = "";

            while(matcher.find()){
                plan = matcher.group("planet");
                popul = matcher.group("population");
                attackT = matcher.group("attackType");
                sold = matcher.group("soldiers");
            }

            if(attackT.equals("A")){
                attackedPlanets.add(plan);
            }
            if(attackT.equals("D")){
                destroyedPlanets.add(plan);
            }

        }


        System.out.printf("Attacked planets: %d\n", attackedPlanets.size());
        if(attackedPlanets.size()>0){
            Collections.sort(attackedPlanets);
            for (String planet :
                    attackedPlanets) {
                System.out.printf("-> %s\n",planet);
            }
        }
        System.out.printf("Destroyed planets: %d\n", destroyedPlanets.size());
        if(destroyedPlanets.size()>0){
            Collections.sort(destroyedPlanets);
            for (String planet :
                    destroyedPlanets) {
                System.out.printf("-> %s\n",planet);
            }
        }

    }
}

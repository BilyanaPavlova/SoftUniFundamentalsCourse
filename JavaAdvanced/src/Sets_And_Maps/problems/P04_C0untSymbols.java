package Sets_And_Maps.problems;

import java.util.*;

public class P04_C0untSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArray = sc.nextLine().toCharArray();
        Map<Character, Integer> characters = new TreeMap<>();

        int count = 0;
        for (char character : charArray) {

            if(characters.containsKey(character)){
                characters.put(character, characters.get(character)+1);
            }
            characters.putIfAbsent(character, 1);
        }

        for (Map.Entry<Character, Integer> entry :
                characters.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }


    }
}

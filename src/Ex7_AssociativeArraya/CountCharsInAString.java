package Ex7_AssociativeArraya;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();


        LinkedHashMap<Character, Integer> result = new LinkedHashMap<>();


        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if(!result.containsKey(ch)){
                result.putIfAbsent(ch, 1);
            }else{
                result.put(ch, result.get(ch)+1);
            }
        }

        result.remove(' ');

        for(Map.Entry<Character, Integer> entry : result.entrySet()){
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());

        }

        }
    }


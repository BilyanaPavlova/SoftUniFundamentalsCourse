package Ex7_AssociativeArraya;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();


        LinkedHashMap<String, Integer> hm = new LinkedHashMap<>();
        int counter = 0;

        while(true){
            if(input.equals("stop")){
                for (Map.Entry<String, Integer> entry : hm.entrySet()) {
                    System.out.printf("%s -> %d%n",
                            entry.getKey(), entry.getValue());
                }
                return;
            }


            int value = Integer.parseInt(sc.nextLine());

                if(hm.containsKey(input)){
                    hm.put(input, hm.get(input) + value);

                }else {
                    hm.putIfAbsent(input, value);
                }

            input = sc.nextLine();

            }




        }
    }


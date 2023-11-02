package Lec7_AssociativeArrays;

import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double [] numbers = Arrays.stream(sc.nextLine().split(" "))
                        .mapToDouble(Double::parseDouble)
                        .toArray();

        TreeMap<Double, Integer> hm = new TreeMap<>();


            for (Double num :
               numbers ) {
            if(hm.containsKey(num)){
                hm.put(num, hm.get(num) + 1);
            }else {
                hm.put(num, 1);
            }
        }

            for (Map.Entry<Double, Integer> entry : hm.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######"); // a class used to format decimal numbers as strings
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }
}

package resources.IMPORTANT;

import java.util.HashMap;
import java.util.Map;

public class RULESPrintingHashMap {
    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("one", 1);
        hm.put("two", 2);
        hm.put("three", 3);

        /*The entrySet() method is used to get a set of key-value pairs (Map.Entry objects) from the HashMap.
        Then, a for loop is used to iterate over these entries,
        and getKey() and getValue() methods of the Map.Entry interface are used
        to retrieve the key and value of each entry, which are then printed.*/

        for(Map.Entry<String, Integer> entry : hm.entrySet()){
            System.out.printf("%s , %d\n", entry.getKey(), entry.getValue());
        }

        /*Alternatively, if you're using Java 8 or higher,
        you can use lambda expressions and the forEach method to print the HashMap:*/

        // Printing key-value pairs using forEach and lambda expression
        hm.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

//        3rd way  to print:
        hm.entrySet().forEach(entry -> System.out.printf("%s, %s\n", entry.getKey(), entry.getValue()));

        //only keys
        hm.keySet().forEach(el -> System.out.println(el));

        //only values
        hm.values().forEach(el -> System.out.println(el));

    }
    }


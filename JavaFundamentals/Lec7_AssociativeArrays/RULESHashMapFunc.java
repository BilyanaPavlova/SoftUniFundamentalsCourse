package Lec7_AssociativeArrays;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RULESHashMapFunc {
    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("Bi", 1);
        System.out.println(hm.containsKey("Bi")); // ture

        hm.putIfAbsent("Ki", 2);
        hm.putIfAbsent("Ki", 3); // does nothing if Ki is present. used only to initialise an entry
        hm.put("Bi", 3); // this sets a new value to the key

        Integer bi = hm.get("Bi");//returns the value !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        System.out.println(bi);

        boolean b = hm.containsValue(2); // check if a value exists
        boolean c = hm.containsValue(1); // check if a value exists
        hm.containsKey("Bi");
        System.out.println(b);
        System.out.println(c);

        Set<String> strings = hm.keySet(); // only the keys
        System.out.println(strings);

        Set<Map.Entry<String, Integer>> entries = hm.entrySet(); //set of the entries
        System.out.println(entries);

//        hm.clear(); // the map is cleared of all entries

        hm.isEmpty(); // check if map is empty

        System.out.println(hm.replace("Bi", 3, 10)); // returns boolean

        System.out.println(hm.replace("Bi", 11)); // returns integer

//        hm.remove("Bi");
        System.out.println(hm.remove("Bi", 2)); //true if the value is removed - removes the entry only if the key is mapped to the current value

        System.out.println(hm.values());// [11, 2]
        Collection<Integer> values = hm.values();

        System.out.println(hm.size());





        System.out.println(hm);

//        printing - Map.Entry - this loop cannot change the HM, it is read only!!!!!!
//        for (Map.Entry<K, V> entry : fruits.entrySet()) {
//            System.out.printf("%s -> %.2f%n",
//                    entry.getKey(), entry.getValue());
//        }


        //iterate only through the values
        for (int value : hm.values()) {
            System.out.println("Value: " + value);
        }

    }
}

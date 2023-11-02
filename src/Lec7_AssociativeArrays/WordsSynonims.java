package Lec7_AssociativeArrays;

import java.util.*;

public class WordsSynonims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

     HashMap<String, List<String>> kvp = new HashMap<>();


        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            String value = sc.nextLine();

//            This method is used to insert a key-value pair into the map if the specified key is not already
//            associated with a value (or is mapped to null).
//            If the key is already present in the map, the method does nothing and leaves the map unchanged.
            kvp.putIfAbsent(word, new ArrayList<>()); //добавя ключ акого няма, ако го има нищо не прави
            kvp.get(word).add(value);//попълваме листа: kvp.get(word) - връща листа /валюто

        }

        for(Map.Entry<String, List<String>> entry : kvp.entrySet()){
            System.out.print(entry.getKey() + " - ");
            System.out.println(String.join(", ", entry.getValue()));
            }
        }


    }


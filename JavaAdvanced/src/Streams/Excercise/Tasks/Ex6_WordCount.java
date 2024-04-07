package Streams.Excercise.Tasks;

import java.io.*;
import java.util.*;

public class Ex6_WordCount {
    public static void main(String[] args) {
        
        String words = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt";
        String text = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt";
        String output = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/ex6_output.txt";
        
        
        try(BufferedReader reader = new BufferedReader(new FileReader(words));
            BufferedReader reader1 = new BufferedReader(new FileReader(text));
            PrintWriter writer = new PrintWriter(new FileWriter(output))) {
            
            String line = reader.readLine();
            String[] wordsArr = line.split("\\s+");
            
            String textLine = reader1.readLine();
            String[] splitText = textLine.split("\\. | |, ");

            HashMap<String, Integer> hm = new HashMap<>();
            
            int counterMatches = 0;

            for (String w : wordsArr) {
                for (String t : splitText) {

                    if (w.equals(t)){
                        counterMatches++;
                    }
                }

                hm.put(w, counterMatches);
                counterMatches = 0;

            }

            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hm.entrySet());

            // Sort the list based on values in descending order
            entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            // Convert the sorted list back to a LinkedHashMap to preserve the order
            LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : entryList) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
                for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                }
//                System.out.println(sortedMap);
//                System.out.println(w + " - " + counterMatches);
                counterMatches = 0;


        } catch (IOException e){
            throw new RuntimeException();
        }
    
    }
}

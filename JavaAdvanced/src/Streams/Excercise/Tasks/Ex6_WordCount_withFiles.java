package Streams.Excercise.Tasks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Ex6_WordCount_withFiles {
    public static void main(String[] args) {
        
        Path words = Paths.get("/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt");
        Path text = Paths.get("/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt");
        Path output = Paths.get("/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/ex6_output.txt");

       try {
           List<String> wordsSentencesList = Files.readAllLines(words);
           List<String> textSenetencesList = Files.readAllLines(text);

           List<String> wordsList = convertSentencesToWords(wordsSentencesList);
           List<String> textWordsList = convertSentencesToWords(textSenetencesList);

           int counter = 0;
           HashMap <String, Integer> result = new HashMap<>();

           for (String w :
                   wordsList) {

               for (String t :
                       textWordsList) {
                   if (w.equals(t)){
                       counter++;
                   }
               }

               result.put(w, counter);
               counter = 0;

           }

           LinkedHashMap<String, Integer> sortedHM = sortByValuesDescending(result);

           StringBuilder r = new StringBuilder();
           for (Map.Entry<String, Integer> entry:sortedHM.entrySet()) {
               r.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");

           }
           Files.write(output, Collections.singleton(r));

       } catch (Exception ex){
           ex.printStackTrace();
       }



    
    }

    public static LinkedHashMap<String, Integer> sortByValuesDescending(HashMap<String, Integer> map) {
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        return sortedMap;
    }

    private static List<String> convertSentencesToWords(List<String> sentences) {
        List<String> words = new ArrayList<>();
        for (String sentence : sentences) {
            // Split the sentence into words using whitespace as delimiter
            String[] splitWords = sentence.split(",\\s+|\\s+|\\.");
            // Add each word to the list
            words.addAll(Arrays.asList(splitWords));
        }
        return words;
    }
}

package Streams.Excercise.Tasks;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Ex6_WordCount_DimoExample {

    public static void main(String[] args) throws IOException {

        String inputWords = "/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt";
        String inputText = "/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt";

        //we need to read word by word -> BufferedReader(reading from a File) or Scanner(reading from a File)
        BufferedReader br = new BufferedReader(new FileReader(inputWords));

        // read a line, put words in an array
        String s = br.readLine();
        String[] words = s.split(" ");

        //put them in a map in the order of finding
        LinkedHashMap <String, Integer> map = new LinkedHashMap<>();
        for (String word: words) {
            map.put(word, 0);
        }

        // for the long line from the text file we need either BufferedReaer or Scanner
        // Scanner is better, because the buffer might overflow even from one row
        Scanner sc = new Scanner(new FileReader(inputText));

        //use the convenient methods of the scanner to read word by word now
        String word = sc.next();
        while(sc.hasNext()){

            if (map.containsKey(word)){
                int occurrences = map.get(word);
                occurrences++;
                map.put(word, occurrences);

            }

            word = sc.next();
        }

        // print the map
        PrintWriter fr = new PrintWriter("/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/ex6_output_Dimo.txt");
        map.entrySet().stream().forEach(entry -> fr.printf("%s - %d\n", entry.getKey(), entry.getValue()));
        br.close();
        sc.close();
        fr.close();

    }
}

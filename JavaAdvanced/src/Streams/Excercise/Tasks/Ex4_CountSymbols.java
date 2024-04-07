package Streams.Excercise.Tasks;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Ex4_CountSymbols {
    public static void main(String[] args) {

        String inPath = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outPath = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/ex4_output.txt";

        Set <Character> voules = new HashSet<>();
        Collections.addAll(voules, 'a','o','u','e','i');

        Set<Character> puctuations = new HashSet<>();
        Collections.addAll(puctuations, '!',',','?','.');

        int voulesCounter = 0;
        int punctCounter = 0;
        int symbolsCounter = 0;


        try (BufferedReader reader = new BufferedReader(new FileReader(inPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outPath)) ){

            String line = reader.readLine();
            while(line != null){
                char[] symbols = line.toCharArray();
                for (char ch :
                        symbols) {
                    if (ch != 32) {
                        if (puctuations.contains(ch)) {
                            punctCounter++;

                        } else if (voules.contains(ch)) {
                            voulesCounter++;

                        } else {
                            symbolsCounter++;
                        }
                    }
                }
                line = reader.readLine();
            }


            writer.println("Vowels: " + voulesCounter);
            writer.println("Other symbols: " + symbolsCounter);
            writer.println("Punctuation: " + punctCounter);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

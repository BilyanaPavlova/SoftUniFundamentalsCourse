package Streams.Excercise.Tasks;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Ex4_CountSymbols_DimoExample {
    public static void main(String[] args) throws IOException {

        String inPath = "/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outPath = "/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/ex4_output_Dimo.txt";

        Set <Character> vowels = new HashSet<>();
        Collections.addAll(vowels, 'a','o','u','e','i');

        Set<Character> punctuations = new HashSet<>();
        Collections.addAll(punctuations, '!',',','?','.');

        int voulesCounter = 0;
        int punctCounter = 0;
        int symbolsCounter = 0;

        // we can use every type of readers,
        // but it's most convenient to use FileReader,
        // because it reads symbol by symbol (char by char)

        FileReader fr = new FileReader(inPath);

        int oneByte = fr.read();
        while(oneByte != -1) {

                char symbol = (char) oneByte;

                if (isVowel(vowels, symbol)) {
                    voulesCounter++;
                }else if(isPunctuation(punctuations, symbol)){
                    punctCounter++;
                }else if(symbol == ' ' || symbol == '\n'){
                    symbolsCounter++;
                }

            oneByte = fr.read();
        }

        FileWriter fw = new FileWriter(outPath);
        fw.write("Vowels: " + voulesCounter + "\n");
        fw.write("Other symbols: " + symbolsCounter + "\n");
        fw.write("Punctuation: " + punctCounter);
        fr.close();
        fw.close(); // if I do not close, the output file remains empty

    }

    public static Boolean isVowel (Set <Character> vowels, char symbol ){

        return vowels.contains(symbol);

    }

    public static Boolean isPunctuation (Set <Character> punctuations, char symbol ){

        return punctuations.contains(symbol);

    }
}

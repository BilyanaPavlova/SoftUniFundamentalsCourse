package Streams.Lec;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lec2_ReadAndWriteToFile {
    public static void main(String[] args)  {

        String pathIn = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String pathOut = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/02.WriteToFileOutput.txt";


        try (FileInputStream in = new FileInputStream(pathIn);
             FileOutputStream out = new FileOutputStream(pathOut)) {
            
            int oneByte = in.read();

            Set<Character> forbiddenSymbols = new HashSet<>();
            Collections.addAll(forbiddenSymbols, '.', ',', '!', '?');

            while (oneByte >= 0){

                char oneByteAsChar = (char) oneByte;
                if(!forbiddenSymbols.contains(oneByteAsChar)){
                    out.write(oneByteAsChar);
                }
                oneByte = in.read();
            }

        } catch (IOException e) {
            System.out.println("sorry");
        }


    }
}

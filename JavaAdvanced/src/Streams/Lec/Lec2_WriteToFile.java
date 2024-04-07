package Streams.Lec;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lec2_WriteToFile {
    public static void main(String[] args) {
        String pathIn = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String pathOut = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/output2.txt";

        Set<Character> forbidden = new HashSet<>();
        Collections.addAll(forbidden, ',', '.', '?', '!');

       try (
        FileInputStream inputStream = new FileInputStream(pathIn);
        FileOutputStream outputStream = new FileOutputStream(pathOut)) {

           int oneByte = inputStream.read();
           while (oneByte >= 0) {
               if (!forbidden.contains((char) oneByte)) {
                   outputStream.write(oneByte);
               }
               oneByte = inputStream.read();
           }
       } catch (Exception e){
           System.out.println("error");
       }
    }
}

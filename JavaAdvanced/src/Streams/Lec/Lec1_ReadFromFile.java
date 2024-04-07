package Streams.Lec;

import java.io.FileInputStream;
import java.io.IOException;

public class Lec1_ReadFromFile {

    public static void main(String[] args) throws IOException {

        String path = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";


        try (FileInputStream in = new FileInputStream(path)) {

            int oneByte = in.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = in.read();
            }

        } catch (IOException e) {
            System.out.println("exception");
        }
    }
}

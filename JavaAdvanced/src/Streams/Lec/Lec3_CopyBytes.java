package Streams.Lec;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Lec3_CopyBytes {
    public static void main(String[] args) {

        String path = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String pathOut = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/output3.txt";

        try (FileInputStream in = new FileInputStream(path);
             FileOutputStream out = new FileOutputStream(pathOut)) {

            int oneByte = in.read();
            while(oneByte >= 0) {
                if (oneByte == 32 || oneByte == 10) {
                    out.write(oneByte);
                } else {
                    String digitsOfTheCharCode = String.valueOf(oneByte);
                    for(int i = 0; i < digitsOfTheCharCode.length(); i++)
                    out.write(digitsOfTheCharCode.charAt(i));
                }
                oneByte = in.read();
            }

        }catch(Exception e){
            System.out.println("error");
        }
    }
}

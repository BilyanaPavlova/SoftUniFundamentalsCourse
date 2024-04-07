package Streams.Lec;

import java.io.FileInputStream;
import java.io.IOException;

public class Lec1_PrintInBytes {
    public static void main(String[] args) throws IOException {

        String pathIn = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String pathOut = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/output1.txt";

        FileInputStream in = new FileInputStream(pathIn);
//        FileOutputStream out = new FileOutputStream(pathOut);

        int oneByte = in.read();
        while(oneByte >= 0){
            System.out.printf("%s ", Integer.toBinaryString(oneByte));
//            out.write(Integer.toBinaryString(oneByte).getBytes());
            oneByte = in.read();
        }

    }
}

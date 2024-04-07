package Streams.Lec;

import java.io.*;
import java.util.Scanner;

public class Lec4_ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String inputPath = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(inputPath));
        PrintWriter out = new PrintWriter(new FileOutputStream(outputPath));

//        The term "token" generally refers to a complete unit of input, such as a word, a number, or a line,
//        depending on how the Scanner is configured.
//        By default, Scanner uses whitespace (spaces, tabs, newlines) as delimiters between tokens.
//        Therefore, hasNext() typically checks for the presence
//        of the next word (sequence of characters delimited by whitespace).

        while (scanner.hasNext()) {
            if (scanner.hasNextInt())
                out.println(scanner.nextInt());
            scanner.next();
        }
        out.close();


            }
        }






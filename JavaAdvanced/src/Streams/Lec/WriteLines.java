package Streams.Lec;

import java.io.*;

public class WriteLines {
    public static void main(String[] args) {
        String inputPath = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String outputPath = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(inputPath));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {
            int counter = 1;
            String line = in.readLine();
            while (line != null) {
                if (counter % 3 == 0)
                    out.println(line);
                counter++;
                line = in.readLine();
            }
        } catch (IOException e){

        }
    }
}

//BufferedReader:
//FileReader:
//
//FileReader is a class for reading character files. It reads the characters from a file in a character-by-character manner, returning them as int values in the range 0 to 65535 (0x00-0xffff).
//It's primarily used for reading small files or when you need to read the file character by character.
//It's not very efficient for reading large files because it involves a lot of I/O operations.
//
// BufferedReader is a class that reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
//It reads text from a character stream more efficiently by buffering the input and reading chunks of characters at a time, rather than reading them one by one.
//It's suitable for reading large files because it reduces the number of I/O operations, making the reading process faster.
//It's often used in conjunction with FileReader to wrap it and provide buffering capabilities.
//
// In summary, use FileReader when you need to read characters from a file one by one,
// and use BufferedReader when you need more efficient reading of text from a file,
// especially for larger files or when reading lines of text. Typically,
// BufferedReader is preferred for most text file reading tasks due to its buffering capabilities and efficiency.

package Streams.Lec;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Lec6_Files_Example {

    public static void main(String[] args) {

        //Files - Provides static methods for creating streams


//        Path inputPath = Paths.get("/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
//        Path outputPath = Paths.get("/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/files_example.txt");

//        try (BufferedReader reader = Files.newBufferedReader(inputPath);
//             BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
//
//            String s = reader.readLine();
//            writer.write(s);
//            writer.flush();
//
//        } catch (IOException e) {
//            // TODO: handle exception
//        }


//        Provides utility methods for easy file manipulation
        Path inputPath = Paths.get("/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
        Path outputPath = Paths.get("/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/04. Java-Advanced-Files-and-Streams-Lab-Resources/files_example.txt");

        try  {
            List<String> lines = Files.readAllLines(inputPath);
            Files.write(outputPath,lines);

        } catch (IOException e) {
            // TODO: handle exception
        }
    }
}

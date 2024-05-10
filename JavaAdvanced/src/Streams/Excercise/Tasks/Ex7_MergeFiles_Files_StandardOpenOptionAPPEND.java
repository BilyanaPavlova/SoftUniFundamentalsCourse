package Streams.Excercise.Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Ex7_MergeFiles_Files_StandardOpenOptionAPPEND {
    public static void main(String[] args) throws IOException {

        Path pathOne = Paths.get("/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt");
        Path pathTwo = Paths.get("/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt");
        Path pathThree = Paths.get("/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/ex7_output.txt");

        List<String> linesOne = Files.readAllLines(pathOne);
        List<String> linesTwo = Files.readAllLines(pathTwo);

        Files.write(pathThree, linesOne, StandardOpenOption.WRITE);
        Files.write(pathThree, linesTwo, StandardOpenOption.APPEND);




    }
}

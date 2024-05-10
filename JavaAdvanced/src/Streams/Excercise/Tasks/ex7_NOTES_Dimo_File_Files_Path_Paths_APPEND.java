package Streams.Excercise.Tasks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ex7_NOTES_Dimo_File_Files_Path_Paths_APPEND {
    public static void main(String[] args) throws IOException{

//Write a program that reads the contents of two text files ("inputOne.txt", "inputTwo.txt" from Resources - Exercises)
// and merges them into a third one.

    /*
    * File, Files
    * File - methods for getting information about the file. Should be initiated (File f = new File())
    * Files - methods for work with files - ex. directly creating a reader ...
            - static methods. Should not be initiated, but called directly: Files.newBufferedReader()/

     * Path - work with fileName - getName, getParent(), getRoot...
     * Paths - static. Paths.get("filename) - only one method. Returns the path to a file
     * String path = Paths.get("resources/result.text");
     * path. -> methods for getting information about the path
     * for ex. path.root()
     * path.parent()
     * which is the root , which is the parent, where is the file situated related to some other file
     * */

        Path path = Paths.get("Tasks/Notes_Dimo_File_Files_Path_Paths.java");
        System.out.println(path.toString());

        path.getFileName();

        //get info for a file
        File file = new File("/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/ex7_output.txt");

        // work with the file
        String parentName = file.getParent().toString();
        System.out.println(parentName);

        System.out.println(file.exists());

        //-----------
        // method 1 - how to append text to a file without overriding the existing text:
        BufferedWriter bw = new BufferedWriter(new FileWriter(
                "/Users/bilyana.aneva/" +
                        "IdeaProjects/" +
                        "SoftUniFundamentalsCourse/" +
                        "JavaAdvanced/src/Streams/Excercise/" +
                        "Tasks/Output_Files/" +
                        "ex7_Dimo_appendToFileExample", true));

        bw.write("Pesho");
        bw.write(" Dimo");

        bw.close();

        // method 2 - using File, Files, Path

        Path firstFile = Paths.get("/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt");
        List<String> firstFileLines = Files.readAllLines(firstFile);

        Path secondFile = Paths.get("/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt");
        List<String> secondFileLines = Files.readAllLines(secondFile);

        Path thirdFile = Paths.get("/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/ex7_Dimo_appendToFileExample_2");
        Files.write(thirdFile, firstFileLines, StandardOpenOption.APPEND);
        Files.write(thirdFile, secondFileLines, StandardOpenOption.APPEND);


    }
}

package Streams.Excercise.Tasks;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex1_SumLines {
    public static void main(String[] args) {

        // Define the relative path from the source root directory
        String relativePath = "Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"; // Modify this according to your file structure

        // Get the source root directory
        String sourceRoot = System.getProperty("user.dir"); // This gets the current working directory

        // Construct the absolute file path
        String filePath = sourceRoot + "/JavaAdvanced/src/" + relativePath;

        // Create a Path object from the file path
//        Path path = Paths.get(filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));){

            String line = reader.readLine();
            while(line != null) {
                int sum = 0;
                for(int i = 0; i < line.length(); i++){
                    sum += line.charAt(i);
                }
                System.out.println(sum);
                line = reader.readLine();
            }

        }catch (IOException e){

        }
    }
}

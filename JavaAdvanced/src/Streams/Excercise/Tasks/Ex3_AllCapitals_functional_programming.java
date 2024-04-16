package Streams.Excercise.Tasks;

import java.io.*;

public class Ex3_AllCapitals_functional_programming {
    public static void main(String[] args) {
        // Define the relative path from the source root directory
        String relativePath = "Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"; // Modify this according to your file structure

        // Get the source root directory
        String sourceRoot = System.getProperty("user.dir"); // This gets the current working directory

        // Construct the absolute file path
        String filePath = sourceRoot + "/JavaAdvanced/src/" + relativePath;

        // Output file
        String outputFile = System.getProperty("user.dir") + "/JavaAdvanced/src/" + "Streams/Excercise/Tasks/Output_Files/ex3_output_functional.txt"; // Modify this according to your file structure


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            //lines() method reads bby line in bufferred reader
            // then we use functional programing with lambda expression to print each line from the buffer
            reader.lines().forEach(line -> writer.write(line.toUpperCase() + "\n"));

            // if not defined in the try() both streams - reader and writer, should be closed here
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}






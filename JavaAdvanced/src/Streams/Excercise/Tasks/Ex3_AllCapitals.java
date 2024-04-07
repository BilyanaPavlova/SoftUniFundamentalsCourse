package Streams.Excercise.Tasks;

import java.io.*;

public class Ex3_AllCapitals {
    public static void main(String[] args) {
        // Define the relative path from the source root directory
        String relativePath = "Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"; // Modify this according to your file structure

        // Get the source root directory
        String sourceRoot = System.getProperty("user.dir"); // This gets the current working directory

        // Construct the absolute file path
        String filePath = sourceRoot + "/JavaAdvanced/src/" + relativePath;

        // Output file
        String outputFile = System.getProperty("user.dir") + "/JavaAdvanced/src/" + "Streams/Excercise/Tasks/Output_Files/ex4_output.txt"; // Modify this according to your file structure


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            String line = reader.readLine();


            while (line != null) {

//                The issue with your code is that you're not writing newline characters to the output file.
//                The readLine() method removes newline characters from the input,
//                so you need to add them back when writing to the output file.

//                char[] chars = line.toCharArray();

//                for (char ch : chars) {
//                        writer.print(Character.toUpperCase(ch));
//                }
//                writer.println();

                String upperCase = line.toUpperCase();
                writer.println(upperCase);

                line = reader.readLine();
            }



        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}






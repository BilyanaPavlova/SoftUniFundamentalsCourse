package Streams.Excercise.Tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex2_SumBytes {
    public static void main(String[] args) {

        // Define the relative path from the source root directory
        String relativePath = "Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"; // Modify this according to your file structure

        // Get the source root directory
        String sourceRoot = System.getProperty("user.dir"); // This gets the current working directory

        // Construct the absolute file path
        String filePath = sourceRoot + "/JavaAdvanced/src/" + relativePath;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));) {

            String line = reader.readLine();
            long sum = 0;

            while(line != null){

                char[] chars = line.toCharArray();
                for (char ch :
                        chars) {
                    sum += ch;
                }

                line = reader.readLine();
            }

            System.out.println(sum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

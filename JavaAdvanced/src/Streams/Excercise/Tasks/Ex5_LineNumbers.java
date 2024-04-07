package Streams.Excercise.Tasks;

import java.io.*;

public class Ex5_LineNumbers {
    public static void main(String[] args) {
        String inPath = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
        String outPath = "/Users/bilyana.aneva/Documents/SoftUniFundamentals/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/ex5_output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outPath))) {

            String line = reader.readLine();
            int counter = 1;

            while (line != null) {
                writer.println(counter + ". " + line);
                line = reader.readLine();
                counter++;
            }

        } catch (IOException e){
            throw new RuntimeException();
        }

    }
}

package Streams.Excercise.Tasks;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Ex13_ZipArchive {

//Write a program that reads three .txt files and creates a zip archive named "files.zip".
// Use FileOutputStream, ZipOutputStream, and FileInputStream.

    public static void main(String[] args) throws IOException {


        String[] fileNames = {"/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt",
                "/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt",
                "/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt"};

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/ex13_files.zip"));
            // Iterate over each file name
            for (String fileName : fileNames) {
                // Create a new zip entry
                ZipEntry zipEntry = new ZipEntry(fileName);

                // Add the zip entry to the zip output stream
                zos.putNextEntry(zipEntry);

                // Open the input stream for the file
               FileInputStream fileIn = new FileInputStream(fileName);
                    // Read data from the file and write it to the zip output stream
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = fileIn.read(buffer)) != -1) {
                        zos.write(buffer, 0, bytesRead);
                    }

                // Close the current zip entry
                zos.closeEntry();
            }


    }
}

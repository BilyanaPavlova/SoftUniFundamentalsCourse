package Streams.Excercise.Tasks;

import java.io.File;

public class Ex8_GetFolderSize_Recursion {

    public static void main(String[] args) {

//        Write a program that traverses a folder and calculates its size in bytes.
//        Use Folder Exercises Resources in Resources.


//        To calculate the size of a folder in Java,
//        you can recursively traverse the folder and sum up the sizes of all files within it.

                // Path to the folder
                String folderPath = "/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise";

                // Calculate and display folder size
                long folderSize = calculateFolderSize(new File(folderPath));
                System.out.println("Folder size: " + folderSize + " bytes");
            }

            // Method to calculate the size of a folder recursively
            private static long calculateFolderSize(File folder) {
                long size = 0;

                // Check if the file is a directory
                if (folder.isDirectory()) {
                    // List files and subdirectories in the folder
                    File[] files = folder.listFiles();

                    // Iterate through files and subdirectories
                    if (files != null) {
                        for (File file : files) {
                            // If it's a file, add its size to the total
                            if (file.isFile()) {
                                size += file.length();
                            }
                            // If it's a directory, recursively calculate its size
                            else if (file.isDirectory()) {
                                size += calculateFolderSize(file);
                            }
                        }
                    }
                }
                // If it's a file, just return its size
                else if (folder.isFile()) {
                    size = folder.length();
                }

                return size;
            }
        }



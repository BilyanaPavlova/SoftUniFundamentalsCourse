package Streams.Excercise.Tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex9_CopyPicture {

    public static void main(String[] args) throws IOException {

        //Write a program that makes a copy of a .jpg file using FileInputStream, FileOutputStream, and byte[] buffer.
        // Set the name of the new file as "picture-copy.jpg".

        FileInputStream fis = new FileInputStream("/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/img.png");
        FileOutputStream fos = new FileOutputStream("/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/copyPicture.jpg");

        byte[] buffer = new byte[1024];
        while(fis.read(buffer) >= 0) {
            fos.write(buffer);
        }

        fis.close();
        fos.close();

    }
}

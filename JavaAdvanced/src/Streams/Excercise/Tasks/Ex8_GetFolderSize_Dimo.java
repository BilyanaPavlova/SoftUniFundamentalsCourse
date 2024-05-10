package Streams.Excercise.Tasks;

import java.io.File;
import java.util.ArrayDeque;

public class Ex8_GetFolderSize_Dimo {

    public static void main(String[] args) {

//        Write a program that traverses a folder
//        and calculates its size in bytes. Use Folder Exercises Resources in Resources.

        File folder = new File("/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise");
        ArrayDeque<File> directories = new ArrayDeque<>();
        directories.offer(folder);

        long sumOfBytes = 0;

        while(!directories.isEmpty()){
            File current = directories.poll();
            File [] files = current.listFiles();
            for (File file: files){
                if (file.isFile()){
                    sumOfBytes += file.length();
                } else {
                    directories.offer(file);
                }
            }
        }

        System.out.println(sumOfBytes);
    }
}

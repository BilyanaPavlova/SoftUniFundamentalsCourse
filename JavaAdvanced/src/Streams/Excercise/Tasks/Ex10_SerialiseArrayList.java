package Streams.Excercise.Tasks;

import java.io.*;
import java.util.ArrayList;

public class Ex10_SerialiseArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        
//        Write a program that saves and loads an ArrayList of doubles to a file 
//        using ObjectInputStream and ObjectOutputStream. Set the name of the file as "list.ser".
        
        // ArrayLists are Serializable by default

        ArrayList<Double> arr = new ArrayList<>();
        arr.add(0.5);
        arr.add(0.7);
        arr.add(0.9);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/array.ser"));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/array.ser"));

        oos.writeObject(arr);
        ArrayList<Double> list = null;
        list = (ArrayList<Double>) ois.readObject();

        ois.close();
        oos.close();

        list.forEach(d -> System.out.println(d));

    }
}

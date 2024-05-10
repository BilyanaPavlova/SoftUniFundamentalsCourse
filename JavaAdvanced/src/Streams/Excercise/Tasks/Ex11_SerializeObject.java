package Streams.Excercise.Tasks;

import java.io.*;

public class Ex11_SerializeObject {
    
//    Write a program that saves and loads the information about a custom object 
//    using ObjectInputStream and ObjectOutputStream.
//
//Create a simple class called "Course" that has a String field containing its name and an integer field 
// containing the number of students attending the course. Set the name of the save file as "course.ser".

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        Course course = new Course("Java", 5);

        //load the Course object to the course.ser file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/course.ser"));

        //deserialize the object from the file course.ser to the operation memory
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/bilyana.aneva/IdeaProjects/SoftUniFundamentalsCourse/JavaAdvanced/src/Streams/Excercise/Tasks/Output_Files/course.ser"));

        oos.writeObject(course);
        Course deserializedCourse = (Course)ois.readObject();

        System.out.println(deserializedCourse.getName());
        System.out.println(deserializedCourse.getNumOfStudents());
    }
}

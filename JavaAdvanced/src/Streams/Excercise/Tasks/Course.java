package Streams.Excercise.Tasks;

import java.io.Serializable;

public class Course implements Serializable {

    private String name;
    private int numOfStudents;

    public Course(String name, int numOfStudents) {
        this.name = name;
        this.numOfStudents = numOfStudents;
    }

    public String getName() {
        return name;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }
}

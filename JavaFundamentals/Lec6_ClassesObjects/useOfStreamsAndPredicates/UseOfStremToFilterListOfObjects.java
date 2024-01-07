package Lec6_ClassesObjects.useOfStreamsAndPredicates;

import Lec6_ClassesObjects.students_2.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//input
/*Bi Ao 3 Mi
Ku Ei 2 JI
Bi Fu 3 ki
end*/

public class UseOfStremToFilterListOfObjects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        int searchhedAGe = Integer.parseInt(sc.nextLine());

        //fill the list
        String input = sc.nextLine();
        while(true){
            if(input.equals("end")){
                break;
            }
            String[] studentData = input.split(" ");
            String firstName = studentData[0];
            String lastName = studentData[1];
            String age = studentData[2];
            String city = studentData[3];
            Student student = new Student(firstName, lastName, age, city);
            students.add(student);
            input = sc.nextLine();
        }

        //filter the list by selecting students with equal first names = Bi
        List<Student> sameStudents = students.stream()
                .filter(student -> student.getFirstName().equals("Bi"))
                .collect(Collectors.toList());

        System.out.println(sameStudents.toString());

        //return the first searchedAge student, if not found, return default

        Student searched = students.stream()
                .filter(student -> student.getAge().equals(String.valueOf(searchhedAGe)))
                .findFirst()
                .orElse(null);
        System.out.println(searched.toString());

        //return all searchedAge students

        List<Student> searchedAgeStudents = students.stream()
                .filter(student -> student.getAge().equals(String.valueOf(searchhedAGe)))
                .collect(Collectors.toList());

        System.out.println(searchedAgeStudents.toString());
    }

}

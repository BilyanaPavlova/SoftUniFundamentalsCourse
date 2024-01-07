package Lec6_ClassesObjects.students_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        String input = sc.nextLine();

        while(true){
            if(input.equals("end")){
                break;
            }

            String[] in = input.split(" ");

            String firstName = in[0];
            String lastName = in[1];
            String age = in[2];
            String homeTown = in[3];

            if (students.isEmpty()){
                Student student = new Student(firstName, lastName, age, homeTown);
                students.add(student);
                input = sc.nextLine();
                continue;
            }

            if (isNameDuplicate(students, firstName, lastName, age, homeTown)){
                replaceIfDuplicate(students, firstName, lastName, age, homeTown);
            } else {
                Student student = new Student(firstName, lastName, age, homeTown);
                students.add(student);
            }

            input = sc.nextLine();

    }


        String filter = sc.nextLine();

        for (Student student :
                students) {
            if (filter.equals(student.getHomeTown())) {
                String output = String.format("%s %s is %s years old%n"
                        ,student.getFirstName()
                ,student.getLastName()
                ,student.getAge()
                ,student.getHomeTown());

                System.out.printf(output);
            }
        }

//        for (Student st:
//             students) {
//            System.out.println(st.toString());
//        }

    }

    public static boolean isNameDuplicate(List<Student> students, String firstName, String lastName, String age, String homeTown) {
        for (Student stud :
                students) {
            if ((stud.getFirstName().equals(firstName)
                    && stud.getLastName().equals(lastName))) {
                return true;
            }
        }
        return false;
    }


    public static void replaceIfDuplicate(List<Student> students, String firstName, String lastName, String age, String homeTown) {
        for (Student stud :
                students) {
            if ((stud.getFirstName().equals(firstName)
                    && stud.getLastName().equals(lastName))){
                stud.setAge(age);
                stud.setHomeTown(homeTown);
                break;
            }
        }
    }


}


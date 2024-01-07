package Ex6_Classes.students4;

import java.util.*;

public class Main_Comparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String[] input = sc.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            double grade = Double.parseDouble(input[2]);
            Student st = new Student(firstName, lastName, grade);
            students.add(st);

//            students.add(new Student(input[0],input[1], Double.parseDouble(input[2])));
        }

        Comparator<Student> byGrade = Comparator.comparingDouble(Student::getGrade).reversed(); //interface that sets the rule for comparison
        Collections.sort(students, byGrade);//the sorting itself
//        students.sort(byGrade); //the same

//        Iterator<Student> iterator = students.iterator();
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next().toString());
//        }

//        for (Student stud :
//                students) {
//            System.out.println(stud.toString());
//        }

        for (Student stud :
                students) {
            System.out.printf("%s %s: %.2f%n", stud.getFirstName(), stud.getLastName(), stud.getGrade());
        }

    }
}

package Ex2_DataTypes;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = Integer.parseInt(sc.nextLine());
        int capacity = Integer.parseInt(sc.nextLine());

        int numOfCourses = people / capacity;
        boolean leftPeople = people % capacity > 0; // 17%3 = 5


        if (leftPeople){
            System.out.println(numOfCourses + 1);
        } else {
            System.out.println(numOfCourses);
        }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int people = Integer.parseInt(sc.nextLine());
//        int capacity = Integer.parseInt(sc.nextLine());
//
//
//        //return a floqting point number
//        double check = (double) people / capacity;
//
//        System.out.println(Math.ceil());
//
//        // Math.ceil - if the remainder is bigger than the 0.50 it will round up the integer
//        int numOfCourses = (int) Math.ceil (check);
//
//
//
//
//
    }

}

package Ex5_Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Courses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // read and put in a list
        String courses = sc.nextLine();

        List<String> coursesList = Arrays.stream(courses.split(", "))
                .collect(Collectors.toList());

        //read commands
        String command = sc.nextLine();
        while (!command.equals("course start")) {

            List<String> commandList = Arrays.stream(command.split(":"))
                    .collect(Collectors.toList());

            if (command.contains("Add")) {
                String lessonTitle = commandList.get(1);
                if (!coursesList.contains(lessonTitle)) {
                    coursesList.add(lessonTitle);
                }

            } else if (command.contains("Insert")) {
                String lessonTitle = commandList.get(1);
                int index = Integer.parseInt(commandList.get(2));
                if (!coursesList.contains(lessonTitle)) {
                    coursesList.add(index, lessonTitle);
                }

            } else if (command.contains("Remove")) {
                String lessonTitle = commandList.get(1);
//
                remove(coursesList, lessonTitle);
                if(coursesList.contains(lessonTitle+"-Exercise")){
                    remove(coursesList, lessonTitle+"-Exercise");
                }

            } else if (command.contains("Swap")) {
                String lessonTitle1 = commandList.get(1);
                String lessonTitle2 = commandList.get(2);

                swap(coursesList, lessonTitle1, lessonTitle2);
                if(coursesList.contains(lessonTitle2+"-Exercise") ) {
                    int toremove = coursesList.indexOf(lessonTitle2+"-Exercise");
                   coursesList.add(coursesList.indexOf(lessonTitle2)+1, lessonTitle2+"-Excercise");
                   coursesList.remove(toremove+1);
                }
                if(coursesList.contains(lessonTitle1+"-Exercise") ) {
                    int toremove = coursesList.indexOf(lessonTitle1+"-Exercise");
                    coursesList.add(coursesList.indexOf(lessonTitle1)+1, lessonTitle1+"-Excercise");
                    coursesList.remove(toremove-1);
                }




            } else if (command.contains("Exercise")) {
                String lessonTitle = commandList.get(1);
                if (coursesList.contains(lessonTitle)) {
                    int i = coursesList.indexOf(lessonTitle);
                    coursesList.add(i+1, lessonTitle + "-Exercise");
                } else {
                    coursesList.add(lessonTitle);
                    coursesList.add(lessonTitle + "-Exercise");
                }
            }


            command = sc.nextLine();

        }
        for (int i = 1; i <= coursesList.size(); i++) {
            System.out.printf("%d.%s\n", i, coursesList.get(i-1));

        }
    }


    public static boolean doesLessonExist(String lessonTitle, List<String> commandList){
        if (!commandList.contains(lessonTitle)){
            return false;
        }else {
            return true;
        }
    }

    public static void remove(List <String> coursesList, String lessonTitle){
        if(coursesList.contains(lessonTitle)){
            coursesList.remove(lessonTitle);
        }
    }

    public static void swap(List <String> coursesList, String lessonTitle1, String lessonTitle2){
        if(coursesList.contains(lessonTitle1) && coursesList.contains(lessonTitle2)){
                    String temp = lessonTitle1;
                    int index1 = coursesList.indexOf(lessonTitle1);
                    int index2 = coursesList.indexOf(lessonTitle2);
                    coursesList.set(index1, lessonTitle2);
                    coursesList.set(index2, temp);
        }

}
}

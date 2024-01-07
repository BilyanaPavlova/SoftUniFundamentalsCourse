package Ex7_AssociativeArraya;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map <String, List<String>> courses = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (true) {
            if(input.equals("end")){
                courses.forEach((key, value) -> {
                    int num = value.size();
                    System.out.printf("%s: %d\n", key, num);
                    for (String str :
                            value) {
                        System.out.printf("-- %s\n", str);
                    }
                });
                return;
            }

            String[] inp = input.split(" : ");
            String course = inp[0];
            String student = inp[1];

            if(courses.containsKey(inp[0])){
                courses.get(course).add(student);
                input = sc.nextLine();
                continue;
            }

                List<String> students = new ArrayList<>();
                students.add(student);
                courses.put(course, students);

                input = sc.nextLine();





        }
    }
}

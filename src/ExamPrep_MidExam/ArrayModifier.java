package ExamPrep_MidExam;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] numbers = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        String command = sc.nextLine();

        while(!command.equals("end")){

            if (command.equals("decrease")){

                for (int i = 0; i < numbers.length; i++) {
                    numbers[i]= numbers[i] - 1;
                }
//                System.out.println(Arrays.toString(numbers));

                command = sc.nextLine();
                break;

            }

            String[] com = command.split(" ");
            int firstIdx = Integer.parseInt(com[1]);
            int secondIdx = Integer.parseInt(com[2]);

            switch(com[0]) {
                case "swap":

                    int temp = numbers[secondIdx];
                    numbers[secondIdx] = numbers[firstIdx];
                    numbers[firstIdx] = temp;
//                    System.out.println(Arrays.toString(numbers));
                    break;

                case "multiply":

                    int product = numbers[firstIdx] * numbers[secondIdx];
                    numbers[firstIdx] = product;
//                    System.out.println(Arrays.toString(numbers));
                    break;

            }




            command = sc.nextLine();

        }


        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\]]", ""));
    }
}

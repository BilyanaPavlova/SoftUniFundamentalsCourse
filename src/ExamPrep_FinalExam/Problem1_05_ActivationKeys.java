package ExamPrep_FinalExam;

import java.util.Scanner;

public class Problem1_05_ActivationKeys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder(input);

        String com = sc.nextLine();
        while(!com.equals("Generate")){
            String[] command = com.split(">>>");

            if(command[0].equals("Contains")){
                if(sb.toString().contains(command[1])){
                    System.out.printf("%s contains %s\n", sb, command[1]);
                }else{
                    System.out.println("Substring not found!");
                }
            }

            if(command[0].equals("Flip")){

                int idxStart = Integer.parseInt(command[2]);
                int idxEnd = Integer.parseInt(command[3]);
                String substring = sb.substring(idxStart, idxEnd);

                if(command[1].equals("Upper")){

                    sb = new StringBuilder(sb.toString().replace(substring, substring.toUpperCase()));


                }else if(command[1].equals("Lower")){

                    sb = new StringBuilder(sb.toString().replace(substring, substring.toLowerCase()));
                }

                System.out.println(sb);

            }

            if(command[0].equals("Slice")){
                int idxStart = Integer.parseInt(command[1]);
                int idxEnd = Integer.parseInt(command[2]);

                sb = new StringBuilder(sb.delete(idxStart, idxEnd));

                System.out.println(sb);
            }



            com = sc.nextLine();
        }

        System.out.printf("Your activation key is: %s", sb);
    }
}

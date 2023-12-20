package ExamPrep_FinalExam;

import java.util.Scanner;

public class Problem1_04_PasswordReset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();

        StringBuilder sb = new StringBuilder(password);

        String input = sc.nextLine();
        while(true){
            if(input.equals("Done")){
                System.out.printf("Your password is: %s", sb);
                return;
            }

            if (input.contains("TakeOdd")){
                for (int i = 0; i < sb.length(); i++) {
                    sb.delete(i, i+1);
                }
                System.out.println(sb);

            }

            if (input.contains("Cut")){
                int idx = Integer.parseInt(input.split(" ")[1]);
                int length = Integer.parseInt(input.split(" ")[2]);

                sb.delete(idx, idx + length);
                System.out.println(sb);

            }

            if (input.contains("Substitute")){
                String substring = input.split(" ")[1];
                String replacement = input.split(" ")[2];

                if(sb.toString().contains(substring)){
                    sb = new StringBuilder(sb.toString().replaceAll(substring, replacement));
                    System.out.println(sb);

                } else {
                    System.out.println("Nothing to replace!");
                }
            }

            input = sc.nextLine();

        }
    }
}

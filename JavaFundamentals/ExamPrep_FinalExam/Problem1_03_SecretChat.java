package ExamPrep_FinalExam;

import java.util.Scanner;

public class Problem1_03_SecretChat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder(input);

        String command = sc.nextLine();

        while (!command.equals("Reveal")) {
            String[] com = command.split(":\\|:");
            String instruction = com[0];

            if (instruction.equals("InsertSpace")) {
                int idx = Integer.parseInt(com[1]);
                sb.insert(idx, " ");
                System.out.println(sb);
            }

            if (instruction.equals("Reverse")) {
                String substring = com[1];
                if (sb.toString().contains(substring)) {

                    StringBuilder newSubstring = new StringBuilder(substring);
                    newSubstring.reverse();

                    int idx = sb.toString().indexOf(substring);
                    sb.replace(idx, idx + substring.length(), "");
                    sb.append(newSubstring);

                    System.out.println(sb);
                    command = sc.nextLine();
                    continue;

                } else {
                    System.out.println("error");
                    command = sc.nextLine();
                    continue;
                }

            }

            if (instruction.equals("ChangeAll")) {
                String substring = com[1];
                String replacement = com[2];

                String str = sb.toString().replaceAll(substring, replacement);
                sb = new StringBuilder(str);
                System.out.println(sb);

            }

                command = sc.nextLine();
            }

        System.out.printf("You have a new text message: %s", sb);
        }
    }


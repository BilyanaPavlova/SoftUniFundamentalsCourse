package ExamPrep_FinalExam;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Problem1_01_TheImitationGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String message = sc.nextLine();
        StringBuilder sb = new StringBuilder(message);

        String command = sc.nextLine();
        while(!command.equals("Decode")){
            String instruction = command.split("\\|")[0];

            if (instruction.equals("Move")){
                int n = Integer.parseInt(command.split("\\|")[1]);
                if(n >= 0 && n <= sb.length()) {
                    String substr = sb.substring(0, n);
                    sb.delete(0, n);
                    sb.append(substr);
                }


            }

            if (instruction.equals("Insert")){
                int idx = Integer.parseInt(command.split("\\|")[1]);
                String value = command.split("\\|")[2];
                if(idx >=0 && idx <= sb.length()) {
                    sb.insert(idx, value);
                }


            }

//            if (instruction.equals("ChangeAll")){
//                String substring = command.split("\\|")[1];
//                String replacement = command.split("\\|")[2];
//                if(sb.toString().contains(substring)){
//
//                    sb = new StringBuilder(sb.toString().replaceAll(substring, replacement));
//
//                }
//            }

//            if (instruction.equals("ChangeAll")) {
//                String substring = command.split("\\|")[1];
//                String replacement = command.split("\\|")[2];
//
//                // Escape special characters in the substring
//                String escapedSubstring = Pattern.quote(substring);
//
//                if (sb.toString().contains(escapedSubstring)) {
//                    sb = new StringBuilder(sb.toString().replaceAll(escapedSubstring, replacement));
//                }
//            }

            if(instruction.equals("ChangeAll")) {
                String substring = command.split("\\|")[1];
                String replacement = command.split("\\|")[2];
                if (sb.toString().contains(substring)) {

                    int index = sb.indexOf(substring);
                    while (index != -1) {   //-1 is returned if no such value exist for the index
                        sb.replace(index, index + substring.length(), replacement);
                        index = sb.indexOf(substring, index + substring.length()); // if no more such occurences exist, and no more indexes exist , the index will be == -1


                    }


                }
            }

            command = sc.nextLine();
        }

        System.out.printf("The decrypted message is: %s", sb);
    }
}

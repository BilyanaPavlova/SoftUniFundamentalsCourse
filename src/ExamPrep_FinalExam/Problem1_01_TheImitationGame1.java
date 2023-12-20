package ExamPrep_FinalExam;

import java.util.Scanner;

public class Problem1_01_TheImitationGame1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String message = sc.nextLine();


        String command = sc.nextLine();
        while(!command.equals("Decode")){
            String instruction = command.split("\\|")[0];

            switch (instruction){
                case "Move":
                    int n = Integer.parseInt(command.split("\\|")[1]);
                    if(n >= 0 && n <= message.length()){
                        String messLeft = message.substring(0, n);
                        message = message.replace(messLeft, "");
                        message = message.concat(messLeft);

                    }
                    break;

                case "Insert":
                    int idx = Integer.parseInt(command.split("\\|")[1]);
                    String value = command.split("\\|")[2];
                    if(idx >= 0 && idx <= message.length()) {
                        String messLeft = message.substring(0,idx);
                        String messRight = message.substring(idx);
                        message = messLeft.concat(value).concat(messRight);
                    }
                    break;

                case "ChangeAll":
                    String substring = command.split("\\|")[1];
                    String replacement = command.split("\\|")[2];
                    if(message.contains(substring)){
                        message = message.replaceAll(substring, replacement);
                    }
                    break;
            }


            command = sc.nextLine();
        }

        System.out.printf("The decrypted message is: %s", message);
    }
}

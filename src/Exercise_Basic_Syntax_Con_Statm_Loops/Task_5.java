package Exercise_Basic_Syntax_Con_Statm_Loops;

import java.util.*;

public class Task_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String username=sc.nextLine();;
        String password;
        String reversed = "";

        boolean willContinue = true;

        int count = 1;
        while (willContinue){

            password = sc.nextLine();

            for (int i = 0; i < username.length(); i++){
                reversed += username.charAt(username.length()-1 - i);
            }

            if (reversed.equals(password)){
                System.out.printf("User %s logged in.", username);
                willContinue = false;
            } else {
                if (count < 4) {
                    System.out.println("Incorrect password. Try again.");
                } else {
                    System.out.printf("User %s blocked!", username);
                    willContinue = false;
                }
            }
            reversed = "";
            count++;

        }
    }
}

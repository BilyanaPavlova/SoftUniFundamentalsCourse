package ExamPrep_FinalExam;

import java.util.Scanner;

public class Problem1_02_WorldTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String com = sc.nextLine();
        StringBuilder sb = new StringBuilder(input);

        while(!com.equals("Travel")){
            String[] command = com.split(":");
            String action = command[0];
            String firstEl = command[1];
            String secondEl = command[2];



            if(action.equals("Add Stop")){
                int idx = Integer.parseInt(firstEl);
                String str = secondEl;

                if (idx >=0 && idx <= input.length()-1){
                    sb.insert(idx, str);
                }
                System.out.println(sb);
                com = sc.nextLine();
                continue;
            }

            if(action.equals("Remove Stop")){
                int idx1 = Integer.parseInt(firstEl);
                int idx2 = Integer.parseInt(secondEl);

                if (idx1 >=0 && idx1 <= sb.length()-1
                && idx2 >=0 && idx2 <= sb.length()-1){
                    sb.delete(idx1, idx2+1);
                }
                System.out.println(sb);
                com = sc.nextLine();
                continue;
            }

            if(action.equals("Switch")){
                if(sb.toString().contains(firstEl)){

                    int index = sb.indexOf(firstEl);
                    while (index != -1) {
                        sb.replace(index, index + firstEl.length(), secondEl);
                        index = sb.indexOf(firstEl, index + secondEl.length());

                    }


                }
                System.out.println(sb);
                com = sc.nextLine();
                continue;
            }
        }

        System.out.printf("Ready for world tour! Planned stops: %s", sb);
    }
}

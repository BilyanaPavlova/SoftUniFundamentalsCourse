package Stacks_Queus;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        ArrayDeque<String> text = new ArrayDeque<>();

        ArrayDeque<String> deletedChars = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            String[] com = sc.nextLine().split("\\s+");
            String command = com[0];

            int last = 0;
            String deleted = "";

            switch(command){
                case "1":
                    text.push(com[1]); // add
                    last = 1;

                    break;
                case "2":

                    for (int j = 0; j < Integer.parseInt(com[1]); j++) {

                        deletedChars.offer(text.pop()); // add the deleted elements to a queue and delete them from the text
                        last = 2; //sets the flag
                    }

                    break;
                case "3":
                    int idx = Integer.parseInt(com[1]);


                    break;
                case "4":
                    // undo last adding or erasing
                    if (last == 1){
                        text.pop();
                        last = 0;
                    }
                    if (last == 2){
                        text.push(deletedChars.poll());
                        deleted = "";
                    }


                    break;
            }


        }
    }
}

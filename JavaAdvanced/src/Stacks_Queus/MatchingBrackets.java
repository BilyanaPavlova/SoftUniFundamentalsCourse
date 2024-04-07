package Stacks_Queus;

import javax.sound.midi.MidiDevice;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        Deque<Integer> idxs = new ArrayDeque<>();


        for(int i = 0; i <= expression.length()-1; i++){
            if (expression.charAt(i) == '('){
                idxs.push(i);
            }
            if (expression.charAt(i) == ')'){
                System.out.println(expression.substring(idxs.pop(), i + 1));
            }
        }
    }
}

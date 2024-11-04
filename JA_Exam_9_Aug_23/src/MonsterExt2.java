import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MonsterExt2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> monsterArmour = parseInputToQueue(sc.nextLine());
        Stack<Integer> strikeValues = parseInputToStack(sc.nextLine());

        int killedMonsters = 0;

        while (!monsterArmour.isEmpty() && !strikeValues.isEmpty()) {
            int armour = monsterArmour.poll();
            int strike = strikeValues.pop();

            if (strike >= armour) {
                killedMonsters++;
                int remainder = strike - armour;
                if (remainder > 0) {
                    if (!strikeValues.isEmpty()) {
                        strikeValues.push(strikeValues.pop() + remainder);
                    } else {
                        strikeValues.push(remainder);
                    }
                }
            } else {
                monsterArmour.offer(armour - strike);
            }
        }

        if (monsterArmour.isEmpty()) {
            System.out.println("All monsters have been killed!");
        } else {
            System.out.println("The soldier has been defeated.");
        }
        System.out.printf("Total monsters killed: %d", killedMonsters);
    }

    private static Queue<Integer> parseInputToQueue(String input) {
        Queue<Integer> queue = new LinkedList<>();
        for (String part : input.split(",\\s*")) {
            queue.offer(Integer.parseInt(part));
        }
        return queue;
    }

    private static Stack<Integer> parseInputToStack(String input) {
        Stack<Integer> stack = new Stack<>();
        for (String part : input.split(",\\s*")) {
            stack.push(Integer.parseInt(part));
        }
        return stack;
    }
}
import java.util.*;
import java.util.stream.Collectors;

public class NewMonster {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<Integer> monsterArmour = new ArrayDeque<>();

        String[] arr = sc.nextLine().split(",\\s*");
        List<Integer> collected = Arrays.stream(arr)
                .map(Integer::parseInt)
                .toList();
        for(Integer el: collected) {
            monsterArmour.offer(el);
        }

        Stack<Integer> strikeValues = new Stack<>();
        String[] arr1 = sc.nextLine().split(",\\s*");
        List<Integer> collectedValues = Arrays.stream(arr1)
                .map(Integer::parseInt)
                .toList();
        for(Integer el: collectedValues) {
            strikeValues.push(el);
        }

        int killedMonsters = 0;

        while (true) {
            if (monsterArmour.isEmpty()) {
                System.out.println("All monsters have been killed!");
                System.out.printf("Total monsters killed: %d", killedMonsters);
                return;
            }

            if (strikeValues.isEmpty()) {
                System.out.println("The soldier has been defeated.");
                System.out.printf("Total monsters killed: %d", killedMonsters);
                return;
            }

            int armour = monsterArmour.poll();
            int strike = strikeValues.pop();

            if (strike >= armour) {
                killedMonsters++;
                int remainder = strike - armour;

                if (!strikeValues.isEmpty() && remainder != 0) {
                    int next = strikeValues.pop();
                    strikeValues.push(next + remainder);
                } else if (remainder != 0) {
                    strikeValues.push(remainder);
                }
            } else {
                int remainder = armour - strike;
                if (remainder != 0) {
                    monsterArmour.offer(remainder);
                }
            }
        }
    }
}




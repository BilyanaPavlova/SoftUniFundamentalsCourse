import java.util.*;
import java.util.stream.Collectors;

public class MonsterExterminaion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        Queue<Integer> monsterArmour = Arrays.stream(sc.nextLine().split(",\\s*"))
//                .map(Integer::parseInt)
//                .collect(Collectors.toCollection(LinkedList::new));

        String input = sc.nextLine();
        String[] parts = input.split(",\\s*");
        Queue<Integer> monsterArmour = new LinkedList<>();

        for (String part : parts) {
            monsterArmour.offer(Integer.parseInt(part));
        }

//        Stack<Integer> strikeValues = Arrays.stream(sc.nextLine().split(",\\s*"))
//                .map(Integer::parseInt)
//                .collect(Stack::new, Stack::push, Stack::addAll);

        input = sc.nextLine();
        String[] parts2 = input.split(",\\s*");
        Stack<Integer> strikeValues = new Stack<>();

        for (String part : parts2) {
            strikeValues.push(Integer.parseInt(part));
        }

        int killedMonsters = 0;

        while (true) {
            if (monsterArmour.isEmpty() ) {
                System.out.println("All monsters have been killed!");
                System.out.printf("Total monsters killed: %d", killedMonsters);
                return;
            }

            if (strikeValues.isEmpty() ) {
                System.out.println("The soldier has been defeated.");
                System.out.printf("Total monsters killed: %d", killedMonsters);
                return;
            }

            int armour = monsterArmour.poll();
            int strike = strikeValues.pop();

            if (strike >= armour) {
                killedMonsters++;
                int remainder = strike - armour;

                if (!strikeValues.isEmpty()) {
                    if (remainder != 0) {

                        int next = strikeValues.pop();
                        strikeValues.push(next + remainder);

                    }
                }else {
                    if (remainder != 0) {
                        strikeValues.push(remainder);
                    }
                }


            } else {
             int remainder = armour - strike;
                    monsterArmour.offer(remainder);

            }
        }






    }
}

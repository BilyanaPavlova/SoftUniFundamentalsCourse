import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class OffroadChallemge {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String input = sc.nextLine();
        String[] numbers = input.split(" ");

        Stack<Integer> initialFuel = new Stack<>();

        for (String number : numbers) {
            initialFuel.push(Integer.parseInt(number));
        }
//
//        System.out.println("Stack contents:");
//        while (!initialFuel.isEmpty()) {
//            System.out.print(initialFuel.pop());
//        }


        Queue<Integer> additionalConsumtionIndex = new ArrayDeque<>();

        String[] additional = sc.nextLine().split(" ");

        for (String number : additional) {
            additionalConsumtionIndex.offer(Integer.parseInt(number));
        }
//
//        System.out.println("Queue contents:");
//        while (!additionalConsumtionIndex.isEmpty()) {
//            System.out.print(additionalConsumtionIndex.poll());
//        }

        String[] needed = sc.nextLine().split(" ");

        Queue<Integer> neededAmount = new ArrayDeque<>();
        for (String num : needed) {
            neededAmount.offer(Integer.parseInt(num));
        }

//        System.out.println("Queue contents:");
//        while (!neededAmount.isEmpty()) {
//            System.out.print(neededAmount.poll());
//        }

        int allAltitudes = initialFuel.size();
        int altitudeCounter = 0;

        while (!initialFuel.isEmpty()) {
            altitudeCounter++;
            int fuel = initialFuel.peek();
            int add = additionalConsumtionIndex.peek();
            int need = neededAmount.peek();
            if (fuel - add < need) {

                // print
                System.out.printf("John did not reach: Altitude %d\n", altitudeCounter);
                altitudeCounter--;

                break;
            }

            initialFuel.pop();
            additionalConsumtionIndex.poll();
            neededAmount.poll();
            allAltitudes--;

            System.out.printf("John has reached: Altitude %d\n", altitudeCounter);

        }

        if (allAltitudes > 0) {
            if (altitudeCounter > 0) {
                StringBuilder sb = new StringBuilder("John failed to reach the top.");
                sb.append(System.lineSeparator());
                sb.append("Reached altitudes: ");

                for(int i = 1; i <= altitudeCounter; i++){
                    sb.append("Altitude ").append(i);
                    if (i != altitudeCounter){
                        sb.append(", ");
                    }
                }

                System.out.println(sb.toString());

            } else if (altitudeCounter == 0) {
                System.out.println("John failed to reach the top.");
                System.out.println("John didn't reach any altitude.");
            }
        } else if (allAltitudes == 0) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");

        }


    }
}


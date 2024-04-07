package Stacks_Queus;

import java.util.*;

public class PrimeCyclePotato_PriorityQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split("\\s+");
        PriorityQueue<String> kidsQueue = new PriorityQueue<>();
        ArrayDeque<String> kids = new ArrayDeque<>();
//        Collections.addAll(kidsQueue, arr);
        Collections.addAll(kids, arr);

        for (String el :
                arr) {
            kidsQueue.add(el);
        }

        System.out.println(kids);
        System.out.println(kidsQueue);

        int n = Integer.parseInt(sc.nextLine());

        int cycle = 1;
        while(kidsQueue.size() > 1){
            if (cycle > n){
                break;
            }

                if (isPrime(cycle)){
                    //do not remove kids
                    System.out.println("Prime " + kidsQueue.peek());

                } else {
                    // remove kids
                    System.out.println("Removed " + kidsQueue.poll());
                }

                //rotate the kids
                kidsQueue.add(kidsQueue.poll());


                cycle++;
            }

        System.out.println("Last left " + kidsQueue.poll());
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

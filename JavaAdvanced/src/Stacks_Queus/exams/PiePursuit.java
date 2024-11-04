package Stacks_Queus.exams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PiePursuit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> capacity = null;
        Stack<Integer> pieces = null;


        String input = sc.nextLine();

        capacity = Arrays.stream(input.split("\\s+"))  // Split the input string by whitespace
                .map(Integer::parseInt)       // Convert each element to an Integer
                .collect(Collectors.toCollection(LinkedList::new));// Collect to a LinkedList


        input = sc.nextLine();
        pieces = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(Stack<Integer>::new));





        while (true) {

            if (capacity.isEmpty() && pieces.isEmpty()) {
                System.out.println("We have a champion!");
                return;
            } else if (capacity.isEmpty()) {
                System.out.println("Our contestants need to rest!");
                System.out.print("Pies left: ");
                printResultCollections(capacity, pieces);
                return;
            } else if (pieces.isEmpty()) {
                System.out.println("We will have to wait for more pies to be baked!");
                System.out.print("Contestants left: ");
                printResultCollections(capacity, pieces);

                return;
            }

           int leftCapacity = capacity.poll();
            int rightPieces = pieces.pop();

            if (leftCapacity > rightPieces){
                capacity.offer(leftCapacity - rightPieces);

            } else if(leftCapacity < rightPieces){

                int diff = rightPieces - leftCapacity;

                if (!pieces.isEmpty()) {

                    if (diff > 1) {
                        pieces.push(diff);
                    } else if (diff == 1) {
                        pieces.push(pieces.pop() + diff);
                    }
                } else {
                    pieces.push(diff);
                }


            }
//            System.out.println();
//            printResultCollections(capacity, pieces);

        }//while


    }//psvm



//-----

    public static void printResultCollections(Queue<Integer> q, Stack<Integer> s){
        if(!q.isEmpty()){
            String queueString = q.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            System.out.printf(queueString);
        }

        if(!s.isEmpty()){
            String stackString = s.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            System.out.print(stackString);
        }
    }


}//class

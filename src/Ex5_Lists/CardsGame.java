package Ex5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondDeck = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;
        while(!firstDeck.isEmpty() && !secondDeck.isEmpty()) {

            int cardFirst = firstDeck.get(0);
            int cardSecond = secondDeck.get(0);

                if(cardFirst > cardSecond){
                    firstDeck.add(cardFirst);
                    firstDeck.add(cardSecond);
                    firstDeck.remove(firstDeck.get(0)); //elementa, an estojnostta!
                    secondDeck.remove(secondDeck.get(0));

                }else if (cardFirst < cardSecond){
                    secondDeck.add(cardSecond);
                    secondDeck.add(cardFirst);
                    secondDeck.remove(secondDeck.get(0));
                    firstDeck.remove(firstDeck.get(0));
                }else if(cardFirst == cardSecond){
                    secondDeck.remove(secondDeck.get(0)); //elementa, a ne stojnostta!!!!
                    firstDeck.remove(firstDeck.get(0));
                }
            }

            if(firstDeck.isEmpty()){
                for (int card:
                     secondDeck) {
                    sum += card;
                }
                System.out.printf("Second player wins! Sum: %d", sum);
            } else if(secondDeck.isEmpty()){
                for (int card:
                        firstDeck) {
                    sum += card;
                }
                System.out.printf("First player wins! Sum: %d", sum);
            }
        }

    }


package iterable_iterator_comparable_comparator.exc.ex03;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MyStack<Integer> myStack = new MyStack<>();

        String str = sc.nextLine();
        while (!str.equals("END")) {
            String[] tokens = str.split("\\s+");
            String command = tokens[0];
            String[] data = Arrays.copyOfRange(tokens, 1, tokens.length);
            data = Arrays.stream(data).map(e -> e.replaceAll(",", "")).toArray(String[]::new);

            switch (command) {
                case "Push":
                    Arrays.stream(data).mapToInt(Integer::parseInt).forEach(myStack::push);
                    break;

                case "Pop":
                    try {
                        myStack.pop();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

            }

            str = sc.nextLine();
        }
        myStack.forEach(System.out::println);
        myStack.forEach(System.out::println);
    }
}

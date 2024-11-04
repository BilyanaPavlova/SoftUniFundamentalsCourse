package Generics.excercises.ex07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String[] com = sc.nextLine().split("\\s+");

        Store<String> store = new Store<>();

        while (!com[0].equals("END")) {

            switch (com[0]) {
                case "Add":
                    store.add(com[1]);
                    break;

                case "Remove":
                    store.remove(Integer.parseInt(com[1]));
                    break;

                case "Contains":
                    boolean contains = store.contains(com[1]);
                    System.out.println(contains);
                    break;

                case "Swap":
                    store.swap(Integer.parseInt(com[1]), Integer.parseInt(com[2]));
                    break;

                case "Greater":
                    int count = store.countGreaterThan(com[1]);
                    System.out.println(count);

                    break;
                case "Max":
                    System.out.println(store.getMax());

                    break;
                case "Min":
                    System.out.println(store.getMin());

                    break;
                case "Print":
                    System.out.println(store);

                    break;

                case "Sort":

                   Sorter.sort(store);

                    break;


            }

            com = sc.nextLine().split("\\s+");
        }


        for (String item : store) {
            System.out.println(item);}
    }
}

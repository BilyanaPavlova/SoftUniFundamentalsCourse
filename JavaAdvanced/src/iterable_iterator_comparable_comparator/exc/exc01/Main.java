package iterable_iterator_comparable_comparator.exc.exc01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String com = sc.nextLine();
        ListyIterator<String> listyIterator = null;
        while(!com.equals("END")){
            String [] command = com.split("\\s+");

            switch (command[0]){

                case "Create":
                    String[] data = Arrays.stream(command).skip(1).toArray(String[]::new);
                    listyIterator = new ListyIterator<>(data);
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                    case "PrintAll":
                    listyIterator.printAll();
                    break;
            }
            com = sc.nextLine();
        }
    }
}

package Lec6_ClassesObjects.useOfStreamsAndPredicates;

import java.util.Optional;
import java.util.Scanner;

public class UseOfOptional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String result = null;
        String input = sc.nextLine();
        while (true) {
            if(input.equals("end")){
                break;
            }
//        Optional<String> name = Optional.ofNullable(getNameFromDatabase());
            Optional<String> name = Optional.ofNullable(input);
           result = name.orElse("Default Name");
           input = sc.nextLine();
        }
        System.out.println(result);
    }
}

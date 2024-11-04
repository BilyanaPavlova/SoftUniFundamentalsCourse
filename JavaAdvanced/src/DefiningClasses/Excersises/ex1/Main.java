package DefiningClasses.Excersises.ex1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Set<Ex1_OptionalPoll> people = new HashSet<>();


        while(n-- > 0){
            String[] arr = sc.nextLine().split("\\s+");
            people.add(new Ex1_OptionalPoll(arr[0], Integer.parseInt(arr[1])));
        }

        people.stream()
                .filter(p -> p.getAge() > 30)
                .sorted(Comparator.comparing(Ex1_OptionalPoll::toString))
                .forEach(System.out::print);
    }
}

package FunctionalProgramming.Excersises;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EX_10_1_ProperDecisionOnPredicateParty {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> guests = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        Set<String> filters = new HashSet<>();

        String command = sc.nextLine();
        while (!command.equals("Party!")){

            filters.add(command);

            command = sc.nextLine();
        }

        //create Predicate with a Function, that takes each string from filters and returns a Predicate for each string from the set.
        //The Predicate should  take a string and check it for a condition
        //this function will be passed to the filters

        Function<String, Predicate<String>> condition = (str) -> {
                String[] elements = str.split("\\s+");
                switch (elements[1]) {
                    case "StartsWith":
                        return s -> s.startsWith(elements[2]);
                    case "EndsWith":
                        return s -> s.endsWith(elements[2]);
                    case "Length":
                        return s -> s.length() == Integer.parseInt(elements[2]);
                }
               return null;
        };

        //за всеки филтър(условие), приложи филтъра върху списъка с гостите
        List<String> filteredGuests = new ArrayList<>();

        for (String filter: filters){

            Predicate<String> filterToApply = condition.apply(filter);

            assert (filterToApply != null);
            if(filter.startsWith("Double")){

                //flatMap() - duplicates each list element corresponding to a condition. then assign to guest list to replace it with the new list
                guests = guests.stream()
                        .flatMap(guest -> filterToApply.test(guest) ? Arrays.stream(new String[]{guest, guest}) : Arrays.stream(new String[]{guest}))
                        .collect(Collectors.toList());

            }
            if(filter.startsWith("Remove")){
                guests.removeIf(filterToApply);
            }
        }


//        guests.stream().count() != 0 ? guests.stream().sorted().forEach(guest -> System.out.print(guest + " " + "are going to the party"))
//        : sout

        Optional.of(guests)
                .filter(list -> !list.isEmpty())
                .ifPresentOrElse(
                        list -> {
                            String collect = list.stream().collect(Collectors.joining(", "));
                            System.out.print(collect);
                            System.out.println(" are going to the party!");
                        },
                        () -> System.out.println("Nobody is going to the party!")); // Print a message if the list is empty
    }


    }






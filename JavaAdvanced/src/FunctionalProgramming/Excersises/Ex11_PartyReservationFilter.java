package FunctionalProgramming.Excersises;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Ex11_PartyReservationFilter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> guests = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        Set <String> commands = new HashSet<>();

        String command = sc.nextLine();
        while(!command.equals("Print")){
            String[] parts = command.split(";");
            String addorremove = parts[0];
            String type = parts[1];
            String parameter = parts[2];

            if (addorremove.equals("Add filter")) {
                commands.add(type + ";" + parameter);
            }
            if (addorremove.equals("Remove filter")){
                commands.remove(type + ";" + parameter);
            }

            command = sc.nextLine();
        }

        Function<String, Predicate<String>> getCondition = str -> {

                String[] com = str.split(";");
                String param = com[1];

                //в зависимост от командата връщаме нов предикат, който приема стринг и го проверява дали почва с параметъра от филтъра
                switch (com[0]) {
                    case "Starts with":
                        return s -> s.startsWith(param);
                    case "Ends with":
                        return s -> s.endsWith(param);
                    case "Length":
                        return s -> s.length() == Integer.parseInt(param);
                    case "Contains":
                        return s -> s.contains(param);
                }

            return  null;
        };

        commands.forEach(el -> {
            Predicate<String> filterToApply = getCondition.apply(el);
            guests.removeIf(filterToApply);
        });

        guests.stream().forEach(el -> System.out.print(el + " "));
    }
}

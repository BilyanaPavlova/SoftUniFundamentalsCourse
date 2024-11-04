package FunctionalProgramming.Excersises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Ex10_PredicatePArty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> guests = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        List<String> command = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        while(!command.get(0).equals("Party!")){

            Predicate<List<String>> chekDoubleNames = names -> names.get(0).equals("Double");
            Predicate<List<String>> checkRemoveNames = names -> names.get(0).equals("Remove");
            Predicate<List<String>> starts = names -> names.get(1).equals("StartsWith");
            Predicate<List<String>> ends = names -> names.get(1).equals("EndsWith");
            Predicate<List<String>> lenghty = names -> names.get(1).equals("Length");

            BiFunction<String,List<String>, List<String>> doubleTheNameWithPrefix = (pref, list) -> {
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).startsWith(pref)){
                        list.add( i + 1, list.get(i));
                        i++;
                    }
                }
                return list;
            };

            BiFunction<String,List<String>, List<String>> doubleTheNameWithSuffix = (suff, list) -> {
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).startsWith(suff)){
                        list.add( i + 1, list.get(i));
                        i++;
                    }
                }
                return list;
            };



            if (chekDoubleNames.test(command)){
                if (starts.test(command)){
                    String prefix = command.get(2);
//                    for (int i = 0; i < guests.size(); i++) {
//                        if(guests.get(i).startsWith(prefix)){
//                            guests.add( i + 1, guests.get(i));
//                            i++;
//                        }
//                    }
                    doubleTheNameWithPrefix.apply(prefix, guests);
                }
                if (ends.test(command)){
                    String suffix = command.get(2);
//                    for (int i = 0; i < guests.size(); i++) {
//                        if(guests.get(i).endsWith(suffix)){
//                            guests.add( i + 1, guests.get(i));
//                            i++;
//                        }
//                    }

                    doubleTheNameWithSuffix.apply(suffix, guests);
                }

                if (lenghty.test(command)){
                    int len = Integer.parseInt(command.get(2));
                    for (int i = 0; i < guests.size(); i++) {
                        if(guests.get(i).length() == len){
                            guests.add( i + 1, guests.get(i));
                            i++;
                        }
                    }
                }
            }

            if (checkRemoveNames.test(command)){
                if (starts.test(command)){
                    String prefix = command.get(2);
                    for (int i = guests.size() - 1; i >= 0; i--) {
                        if(guests.get(i).startsWith(prefix)){
                            guests.remove(i);

                        }
                    }
                }
                if (ends.test(command)){
                    String suffix = command.get(2);
                    for (int i = guests.size() - 1; i >= 0; i--) {
                        if(guests.get(i).endsWith(suffix)){
                            guests.remove( i);
                        }
                    }
                }

                if (lenghty.test(command)){
                    int len = Integer.parseInt(command.get(2));
                    for (int i = guests.size() - 1; i >= 0; i--) {
                        if(guests.get(i).length() == len){
                            guests.remove( guests.get(i));

                        }
                    }
                }
            }

            command = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        }

        if (guests.isEmpty()){
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(guests.stream().sorted().collect(Collectors.joining(", ")) + " are going to the party!");
        }
    }

}



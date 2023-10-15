package Ex5_Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());



        int sum = 0;

        while(numbers.size() > 0){

            int index = Integer.parseInt(sc.nextLine());

//            If the given index is LESS than 0,
//            remove the first element of the sequence, and COPY the last element to its place
            if(index < 0){
                int removed = numbers.get(0);
                sum += removed;
               numbers.remove(0);
               numbers.add(0,numbers.get(numbers.size()-1));

               modify(removed, numbers);


            }
            if (index > numbers.size()-1){
                int removed = numbers.get(numbers.size()-1);
                sum += removed;
                numbers.remove(numbers.size()-1);
                numbers.add(numbers.get(0));
                modify(removed, numbers);


            }
            if (index >=0 && index < numbers.size()){
                int removed = numbers.get(index);
                sum += removed;
                numbers.remove(index);

                modify(removed, numbers);

            }

        }

        System.out.println(sum);

    }

    public static List<Integer> modify (int removed, List<Integer> numbers){
        for (int i = 0; i < numbers.size(); i++) {
            int currentEl = numbers.get(i);
            if(currentEl <= removed){
                numbers.set(i, currentEl + removed) ;
            }else {
                numbers.set(i, currentEl - removed) ;
                }
            }

        return numbers;
        }








}

package Lec6_ClassesObjects;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RandomiseWords {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> words = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        int idx = 0;
        Random rdm = new Random();


        for (int i = 0; i < words.size(); i++) {
            idx = rdm.nextInt(words.size());
            System.out.println(words.get(idx));
            words.remove(idx);
            i--;

        }



    }

}
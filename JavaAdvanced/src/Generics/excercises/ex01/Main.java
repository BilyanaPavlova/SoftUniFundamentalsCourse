package Generics.excercises.ex01;

import Generics.excercises.ex03.Box;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Box<String> box = new Box<>();

        int i = 0;
        while (i++ < n) {
            String data = sc.nextLine();
            box.addElement(data);
        }

        String[] idxes = sc.nextLine().split("\\s+");
        int[] array = Arrays.stream(idxes).mapToInt(Integer::parseInt).toArray();
        box.swap(array[0], array[1]);
        System.out.println(box);


    }

}

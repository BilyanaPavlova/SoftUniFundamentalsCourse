package Generics.excercises.ex03;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
//        Box<Integer> box = new Box<>();
//
//        int i = 0;
//        while (i++ < n) {
//            String data = sc.nextLine();
//            box.addElement(Integer.parseInt(data));
//        }
//
//        String[] idxes = sc.nextLine().split("\\s+");
//        int[] array = Arrays.stream(idxes).mapToInt(Integer::parseInt).toArray();
//        box.swap(array[0], array[1]);
//        System.out.println(box);

        List<Double> list = new ArrayList<>();
        for(int i = 0; i < n; i++){

            list.add(Double.parseDouble(sc.nextLine()));
        }

        Double el = Double.parseDouble(sc.nextLine());

        Integer i = Utilities.countGreater(list, el);
        System.out.println(i);


    }

}

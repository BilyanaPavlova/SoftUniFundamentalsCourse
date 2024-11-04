package Generics.excercises.tuple;

import Generics.excercises.tuple.Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);




            String str = sc.nextLine();
            String[] tokens = str.split("\\s+");


                String name = tokens[0] + " " + tokens[1];
                String address = tokens[2];
                Tuple<String, String> tuple = new Tuple<>(name, address);
                System.out.println(tuple);

        String[] tokens1 = sc.nextLine().trim().split("\\s+");
        String name1 = tokens1[0] ;
        Integer litres = Integer.parseInt(tokens1[1]);
        Tuple<String, Integer> tuple2 = new Tuple<>(name1, litres);
        System.out.println(tuple2);

        String[] tokens2 = sc.nextLine().trim().split("\\s+");
                Integer number = Integer.parseInt(tokens2[0] );
                Double dob = Double.parseDouble(tokens2[1]);
                Tuple<Integer, Double> tuple1 = new Tuple<>(number, dob);
                System.out.println(tuple1);






    }}
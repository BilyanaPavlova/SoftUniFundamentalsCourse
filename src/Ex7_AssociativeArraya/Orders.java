package Ex7_AssociativeArraya;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        LinkedHashMap<String, double[]> orders = new LinkedHashMap<>();


        while(true){
            if(input.equals("buy")){

                //calculate price and print
                double total = 0;
                for (Map.Entry<String,double[]> entry : orders.entrySet()){
                    total = entry.getValue()[0] * entry.getValue()[1];
                    System.out.printf("%s -> %.2f\n", entry.getKey(), total);
                }
                return;
            }

            //initial input to array:
            String[] inp = input.split(" ");
            String key = inp[0];
//            int[] subInp = {Integer.parseInt(inp[1]), Integer.parseInt(inp[2])};

            //creating the orders value: an array of the price and the quantity
            String[] sub = {inp[1], inp[2]};
            double[] priceQ = Arrays.stream(sub)
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            double newPrice = priceQ[0];
            double newQuantity = priceQ[1];

            if(orders.containsKey(key)){
                //increase the quantity
                orders.get(key)[1] += newQuantity;

                //change the price:
                //old way
                double currentPrice = orders.get(key)[0];
                if (newPrice != currentPrice) {
                    orders.get(key)[0] = newPrice; //orders.get(key) - returns the value of the key , which is the array
                }
                //filling if the key exists, check the price and replace if diff, add the quantity

            }

            //filling the new entries to the orders
            orders.putIfAbsent(key, priceQ);

            input = sc.nextLine();
        }
    }


}

package Ex2_DataTypes;

import java.util.HashMap;
import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        double volume = 0;
        String model = null;

        for (int i = 0; i < n; i++) {
            String newModel = sc.nextLine();
            float radius = Float.parseFloat(sc.nextLine());
            int height = Integer.parseInt(sc.nextLine());

//            π * r^2 * h.
             double newVolume = Math.PI * Math.pow(radius, 2) * height;

             if (newVolume > volume){
                 volume = newVolume;
                 model = newModel;

             }
        }
        System.out.println(model);
    }
}

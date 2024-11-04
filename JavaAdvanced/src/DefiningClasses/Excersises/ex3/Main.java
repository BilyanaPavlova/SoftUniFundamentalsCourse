package DefiningClasses.Excersises.ex3;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Set<Car> cars = new LinkedHashSet<>(); //maintains order of insertion

        while(n-- > 0){

            String[] arr = sc.nextLine().split("\\s+");
            Car car = new Car(arr[0],Double.parseDouble(arr[1]),Double.parseDouble(arr[2]));
            cars.add(car);
        }

        String s = sc.nextLine();

        while(!s.equals("End")){

            String[] arr = s.split("\\s+");
            String command = arr[0];
            String carModel = arr[1];
            double amountKm = Double.parseDouble(arr[2]);

            Car foundCar = cars.stream()
                    .filter(c -> c.getModel().equals(carModel))
                    .findFirst()
                    .get();

            foundCar.drive(amountKm);


            s = sc.nextLine();
        }

        cars.stream().forEach(c -> System.out.println(c.toString()));
    }
}

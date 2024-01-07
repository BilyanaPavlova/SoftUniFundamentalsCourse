package Ex6_Classes.vehicles;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();
        String input = sc.nextLine();
        while (!input.equals("End")){
            String[] in = input.split(" ");
            vehicles.add(new Vehicle(in[0], in[1], in[2], in[3]));
            input = sc.nextLine();

        }

        String com = sc.nextLine();
        while(true){
            if(com.equals("Close the Catalogue")){
                List<Vehicle> cars = vehicles.stream()
                        .filter(v -> v.getTypeOfVehicle().equals("car"))
                        .collect(Collectors.toList());

                List<Vehicle> trucks = vehicles.stream()
                        .filter(v -> v.getTypeOfVehicle().equals("truck"))
                        .collect(Collectors.toList());

                double sumHPcars = 0;
                Iterator<Vehicle> iterator  = cars.iterator();
                while(iterator.hasNext()){
                   sumHPcars +=  Double.parseDouble(iterator.next().getHorsepower());
                }

                double sumHPtrucks = 0;
                Iterator<Vehicle> iterator1  = trucks.iterator();
                while(iterator1.hasNext()){
                    sumHPtrucks +=  Double.parseDouble(iterator1.next().getHorsepower());
                }

                if (!cars.isEmpty()){
                    System.out.printf("Cars have average horsepower of: %.2f.\n", sumHPcars / cars.size());
                } else {

                    System.out.printf("Cars have average horsepower of: 0.00.\n");
                }
                if (!trucks.isEmpty()) {
                    System.out.printf("Trucks have average horsepower of: %.2f.\n", sumHPtrucks / trucks.size());
                } else {
                    System.out.printf("Trucks have average horsepower of: 0.00.\n");
                }
                return;
            }
            String model = com;
            Vehicle foundVehicle = vehicles.stream()
                    .filter(v -> v.getModelOfVehicle().equals(model))
                    .findFirst()
                    .orElse(null);
            System.out.println(foundVehicle.toString());
            com = sc.nextLine();
        }


        
        
        
//        System.out.println("%s have average horsepower of %2.f.", typeOfVehicle, avHP);


    }
}

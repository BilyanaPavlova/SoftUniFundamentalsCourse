package vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

/*
To handle this input using polymorphism, you can follow these steps:
Create instances of Car and Truck using the getVehicle method.
Store these instances in a Map where the key is the vehicle type ("Car" or "Truck") and the value is the vehicle instance. This allows you to easily retrieve the correct vehicle based on the input.
Loop over the commands ("Drive" or "Refuel") and execute the corresponding method on the correct vehicle.
 */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        int n = 0;
        while (true) {
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                break;
            }
            Vehicle newVehicle = getVehicle(sc);
            vehicles.put(newVehicle.getClass().getSimpleName(), newVehicle);
        }

        sc.nextLine(); // Move scanner to the next line


        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");

            String command = input[0];
            String vehicleType = input[1];
            String quantity = input[2];

            switch (command) {
                case "DriveEmpty":
                    if(vehicles.get(vehicleType) instanceof Bus bus) {
                        bus.driveWithoutAdditionalConsumption(Double.parseDouble(quantity));
                    }

                case "Drive":
                    System.out.println(vehicles.get(vehicleType).drive(Double.parseDouble(quantity)));
                    break;
                case "Refuel":
                    try {
                        vehicles.get(vehicleType).refuel(Double.parseDouble(quantity));
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                }
        }


        vehicles.values().forEach(System.out::println);

        }





    public static Vehicle getVehicle(Scanner sc) {
        String[] vehicleInfo = sc.nextLine().split("\\s+");

        String vehicleType = vehicleInfo[0];
        double fuelQuant = Double.parseDouble(vehicleInfo[1]);
        double consumption = Double.parseDouble(vehicleInfo[2]);
        double tankCapacity = Double.parseDouble(vehicleInfo[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelQuant, consumption, tankCapacity);
            case "Truck":
                return new Truck(fuelQuant, consumption, tankCapacity);
            case "Bus":
                return new Bus(fuelQuant, consumption, tankCapacity );
            default:
                throw new IllegalArgumentException("Invalid vehicle type: " + vehicleInfo[0]);
        }
    }
}


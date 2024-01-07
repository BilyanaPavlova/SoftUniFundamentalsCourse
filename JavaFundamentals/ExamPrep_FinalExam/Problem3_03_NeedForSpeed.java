package ExamPrep_FinalExam;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem3_03_NeedForSpeed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map <String, String> carMileage = new LinkedHashMap<>();
        Map <String, String> carFuel = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] car = sc.nextLine().split("\\|");
//            Arrays.stream(car).forEach(el -> System.out.print(el));
            carMileage.put(car[0], car[1]);
            carFuel.put(car[0], car[2]);
        }

        String input = sc.nextLine();
        while(true){
            if(input.equals("Stop")){
                //print "{car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt."
                for (String car :
                        carMileage.keySet()) {
                    String mileage = carMileage.get(car);
                    String fuel = carFuel.get(car);

                    System.out.printf("%s -> Mileage: %s kms, Fuel in the tank: %s lt.\n", car, mileage, fuel);
                }


                return;
            }

            String[] in = input.split(" : ");
            if (in[0].equals("Drive")){
                String car = in[1];
                int distanceToDrive = Integer.parseInt(in[2]);
                int fuelNeeded = Integer.parseInt(in[3]);
                int fuelAvailable = Integer.parseInt(carFuel.get(car));
                int mileage = Integer.parseInt(carMileage.get(car));

                if((mileage + distanceToDrive) >= 100000){
                    carMileage.remove(car);
                    carFuel.remove(car);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n",
                            car, distanceToDrive, fuelNeeded);
                    System.out.printf("Time to sell the %s!\n", car);
                    input = sc.nextLine();
                    continue;
                }
                if (fuelNeeded > fuelAvailable){
                    System.out.println("Not enough fuel to make that ride");
                } else {
                    carMileage.put(car, String.valueOf(mileage + distanceToDrive));
                    carFuel.put(car, String.valueOf(fuelAvailable - fuelNeeded));
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n",
                            car, distanceToDrive, fuelNeeded);
                }
            }

            if (in[0].equals("Refuel")){
                String car = in[1];
                int fuelToRefill = Integer.parseInt(in[2]);
                int initialFuelAvailable = Integer.parseInt(carFuel.get(car));
                int fuelAvailable = initialFuelAvailable;
                if(fuelAvailable + fuelToRefill > 75){
                    fuelAvailable = 75;
                    carFuel.put(car, String.valueOf(fuelAvailable));
                    System.out.printf("%s refueled with %d liters\n", car, 75-initialFuelAvailable);
                } else {
                    carFuel.put(car, String.valueOf(fuelAvailable + fuelToRefill));
                    System.out.printf("%s refueled with %d liters\n", car, fuelToRefill);
                }
            }

            if (in[0].equals("Revert")) {
                String car = in[1];
                int kilometers = Integer.parseInt(in[2]);
                int currentMileage = Integer.parseInt(carMileage.get(car));
                int initialCurrentMileage = currentMileage;
                currentMileage -= kilometers;
                if (currentMileage < 10000){
                    currentMileage = 10000;
                    carMileage.put(car, String.valueOf(currentMileage));
                    input = sc.nextLine();
                    continue;
                } else{
                    carMileage.put(car, String.valueOf(currentMileage));
                    System.out.printf("%s mileage decreased by %d kilometers\n",car, kilometers);
                }

            }


            input = sc.nextLine();
        }




    }
}

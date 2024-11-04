package DefiningClasses.Excersises.ex4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Car> cars = new LinkedList<>();

        while (n-- > 0) {
            String[] arr = sc.nextLine().split("\\s+");
            String model = arr[0];
            int engineSpeed = Integer.parseInt(arr[1]);
            int enginePower = Integer.parseInt(arr[2]);
            int cargoWeight = Integer.parseInt(arr[3]);
            String cargoType = arr[4];
            double tyre1Pressure = Double.parseDouble(arr[5]);
            int tyre1Age = Integer.parseInt(arr[6]);
            double tyre2Pressure = Double.parseDouble(arr[7]);
            int tyre2Age = Integer.parseInt(arr[8]);
            double tyre3Pressure = Double.parseDouble(arr[9]);
            int tyre3Age = Integer.parseInt(arr[10]);
            double tyre4Pressure = Double.parseDouble(arr[11]);
            int tyre4Age = Integer.parseInt(arr[12]);

            Tyre tyre1 = new Tyre(tyre1Age, tyre1Pressure);
            Tyre tyre2 = new Tyre(tyre2Age, tyre2Pressure);
            Tyre tyre3 = new Tyre(tyre3Age, tyre3Pressure);
            Tyre tyre4 = new Tyre(tyre4Age, tyre4Pressure);

            Engine carEngine = new Engine(enginePower, engineSpeed);

            Cargo carCargo = new Cargo(cargoWeight, cargoType);

            Car car = new Car(model, carEngine, carCargo, tyre1, tyre2, tyre3, tyre4);
            cars.add(car);

        }

        Predicate<Car> flammableCargoTest = car -> car.getCargo().getCargoType().equals("flamable");
        Predicate<Car> fragileCargoTest = car -> car.getCargo().getCargoType().equals("fragile");
        Predicate<Car> pressureTest = car -> car.getTyres().stream()
                .anyMatch(tyre -> tyre.getTyrePressure() < 1);
        Predicate<Car> enginePowerTest = car -> car.getEngine().getEnginePower() > 250;

        String command = sc.nextLine();
        List<Car> foundCars = new LinkedList<>();



        switch (command) {

            case "fragile":

                List<Car> fragileCars = cars.stream()
                        .filter(fragileCargoTest)
                        .filter(pressureTest)
                        .collect(Collectors.toList());

                foundCars.addAll(fragileCars);


                break;

            case "flamable":
                List<Car> flammableCars = cars.stream()
                        .filter(flammableCargoTest)
                        .filter(enginePowerTest)
                        .collect(Collectors.toList());

                foundCars.addAll(flammableCars);

                break;
        }

        foundCars.stream()
                .forEach(e -> System.out.println(e.getModel()));
    }
}

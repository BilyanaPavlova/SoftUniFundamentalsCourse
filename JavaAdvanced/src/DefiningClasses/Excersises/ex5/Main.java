package DefiningClasses.Excersises.ex5;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Set<Engine> engineTypes = new LinkedHashSet<>();

        while (n-- > 0) {
            String[] arr = sc.nextLine().split("\\s+");
            String model = arr[0];
            int power = Integer.parseInt(arr[1]);
            if(arr.length == 2){
                Engine engine = new Engine(model, power);
                engineTypes.add(engine);
            } else if(arr.length == 3){
                if(arr[2].matches("\\d+")){
                    int displacement = Integer.parseInt(arr[2]);
                    Engine engine = new Engine(model, power, displacement);
                    engineTypes.add(engine);
                } else {
                    String efficiency = arr[2];
                    Engine engine = new Engine(model, power, efficiency);
                    engineTypes.add(engine);
                }
            } else if(arr.length == 4){
                int displacement = Integer.parseInt(arr[2]);
                String efficiency = arr[3];
                Engine engine = new Engine(model, power, displacement, efficiency);
                engineTypes.add(engine);
            }

        }

        int m = Integer.parseInt(sc.nextLine());
        List<Car> cars = new LinkedList<>();

        while (m-- > 0) {
            String[] arr = sc.nextLine().split("\\s+");
            String model = arr[0];
            String engineModel = arr[1];
            Engine engine = engineTypes.stream()
                    .filter(e -> e.getModel().equals(engineModel))
                    .findFirst()
                    .get();
            Car car = getCar(model, engine, arr);

            cars.add(car);
        }

        cars.stream().forEach(c -> System.out.print(c.toString()));


    }

    private static Car getCar(String model, Engine engine, String[] arr) {
        Car car = new Car(model, engine);
        if(arr.length == 3){
            if(arr[2].matches("\\d+")){
                int weight = Integer.parseInt(arr[2]);
                car.setWeight(weight);
            } else {
                String color = arr[2];
                car.setColor(color);
            }
        } else if(arr.length == 4){
            int weight = Integer.parseInt(arr[2]);
            String color = arr[3];
            car.setWeight(weight);
            car.setColor(color);
        }
        return car;
    }
}

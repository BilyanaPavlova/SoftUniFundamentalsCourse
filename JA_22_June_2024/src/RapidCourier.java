import java.util.*;

public class RapidCourier {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stackPackages = new Stack<>();

        String[] packages = sc.nextLine().split("\\s+");
        for (String p : packages) {
            stackPackages.push(Integer.parseInt(p));
        }

        Deque<Integer> queueCouriers = new ArrayDeque<>();

        String[] couriers = sc.nextLine().split("\\s+");
        for (String c : couriers) {
            queueCouriers.offer(Integer.parseInt(c));
        }

        int weight = 0;

        while (!queueCouriers.isEmpty() && !stackPackages.isEmpty() ) {

            int currentPack = stackPackages.pop();
            int currentCourier = queueCouriers.poll();

            if (currentCourier >= currentPack) {
                if (currentCourier > currentPack) {
                    int newCour = currentCourier - 2 * currentPack;
                    if (newCour > 0) {
                        queueCouriers.offer(newCour);
                    }
                }
                weight += currentPack;
            } else {

                int newPack = currentPack - currentCourier;

                stackPackages.push(newPack);
                weight += currentCourier;
            }


        }

        System.out.printf("Total weight: %d kg\n", weight);

        boolean allPackagesDelivered = stackPackages.isEmpty();
        boolean noCouriersAvailable = queueCouriers.isEmpty();

        if (allPackagesDelivered && noCouriersAvailable) {
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        }

        if (!allPackagesDelivered && noCouriersAvailable) {
            System.out.print("Unfortunately, there are no more available couriers to deliver the following packages: ");
            String result = String.join(", ", stackPackages.stream()
                    .map(String::valueOf)
                    .toArray(String[]::new));
            System.out.println(result);
        }

        if (allPackagesDelivered && !noCouriersAvailable) {
            System.out.print("Couriers are still on duty: ");

            String two = String.join(", ", queueCouriers.stream()
                    .map(String::valueOf)
                    .toArray(String[]::new));

            String three = " but there are no more packages to deliver.";

            System.out.print(two);
            System.out.print(three);

        }








    }
}

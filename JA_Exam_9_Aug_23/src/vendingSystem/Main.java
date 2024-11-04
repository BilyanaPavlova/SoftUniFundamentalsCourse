package vendingSystem;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // TODO

VendingMachine vm = new VendingMachine(6);
        Drink tea = new Drink("Tea", new BigDecimal("1.5"), 300);

        Drink coffee = new Drink("Coffee", new BigDecimal("2.0"), 120);

        Drink hotChocolate = new Drink("Hot Chocolate", new BigDecimal("2.5"), 200);
                Drink latte = new Drink("Latte", new BigDecimal("3.5"), 220);

        Drink cappuccino = new Drink("Cappuccino", new BigDecimal("2.8"), 180);

        Drink herbalTea = new Drink("Herbal Tea", new BigDecimal("1.75"), 300);

//Get Count

        System.out.println(vm.getCount()); //0



        vm.addDrink(tea);

        vm.addDrink(coffee);

        vm.addDrink(hotChocolate);

        vm.addDrink(latte);

        vm.addDrink(cappuccino);





        vm.addDrink (herbalTea);
        vm.addDrink(latte);
        System.out.println(vm.getCount());
        System.out.println(vm.report());
            System.out.println(vm.removeDrink("Tea"));
            System.out.println(vm.removeDrink("Herbal Tea"));
            System.out.println(vm.buyDrink("Latte"));

            System.out.println(vm.getLongest());

    }
}

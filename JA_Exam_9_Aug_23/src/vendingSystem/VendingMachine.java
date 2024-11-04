package vendingSystem;

import java.util.LinkedList;
import java.util.List;

public class VendingMachine {

    private List<Drink> drinks;
    private int buttonCapacity;

    public VendingMachine(int buttonCapacity) {
        this.drinks = new LinkedList<>();
        this.buttonCapacity = buttonCapacity;
    }

    public int getCount() {
        return drinks.size();
    }

    public void addDrink(Drink drink) {
        if(this.drinks.size() < buttonCapacity) {
            drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        return drinks.removeIf(d -> d.getName().equals(name));
    }

    public Drink getLongest() {
        return drinks.stream()
                .max((d1, d2) -> Integer.compare(d1.getVolume(), d2.getVolume()))
                .orElse(null);
    }

    public Drink getCheapest() {
        return  drinks.stream()
                .min((d1, d2) -> d1.getPrice().compareTo(d2.getPrice()))
                .orElse(null);
    }

    public String buyDrink(String name) {
        Drink drink = drinks.stream().filter(d -> d.getName().equals(name))
                .findFirst()
                .orElse(null);
        return drink.toString();
    }

    public String report() {
        StringBuilder sb = new StringBuilder("Drinks available:");
        sb.append(System.lineSeparator());
        drinks.forEach(drink -> sb.append(drink.toString()).append(System.lineSeparator()));

        return sb.toString();
    }
}

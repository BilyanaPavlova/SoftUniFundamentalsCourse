package vendingSystem;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Drink {

    private String name;
    private BigDecimal price;
    private int volume;

    public Drink(String name, BigDecimal price, int volume) {
        setName(name);
        setPrice(price);
        setVolume(volume);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: $%.1f, Volume: %d ml", this.name, this.price.setScale(1, RoundingMode.HALF_UP), this.volume);
    }
}

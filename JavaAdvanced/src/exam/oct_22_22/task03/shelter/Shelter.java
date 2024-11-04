package exam.oct_22_22.task03.shelter;

import java.util.Comparator;
import java.util.LinkedList;

public class Shelter {

    int capacity;
   LinkedList<Animal> data;

    public Shelter(int capacity) {
        setCapacity(capacity);
        this.data = new LinkedList<>();
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //•	Method add(Animal animal) – adds an entity to the data if there is an empty cell for the animal.
    public void add (Animal animal) {

            if(this.data.size() < this.capacity) {
                data.add(animal);
            }
    }

    //•	Method remove(String name) – removes the animal by given name, if such exists, and returns boolean.
    public boolean remove(String name) {

        return this.data.removeIf(animal -> animal.getName().equals(name));

    }

    //•	Method getAnimal(String name, String caretaker) – returns the animal with the given name and caretaker or null if no such animal exists.
    public Animal getAnimal(String name, String caretaker) {
        return this.data.stream()
                .filter(animal -> animal.getName().equals(name) && animal.getCaretaker().equals(caretaker))
                .findFirst()
                .orElse(null);
    }

    //•	Method getOldestAnimal() – returns the oldest Animal.
    public Animal getOldestAnimal() {
        return this.data.stream()
                .max(Comparator.comparingInt(Animal::getAge))
                .orElse(null);
    }

    //•	Getter getCount – returns the number of animals.
    public int getCount() {
        return this.data.size();
    }

    //•	getStatistics() – returns a String in the following format:
    //o	"The shelter has the following animals:
    //{name} {caretaker}
    //{name} {caretaker}
    public String getStatistics() {
       StringBuilder strb = new StringBuilder("The shelter has the following animals:");
       strb.append(System.lineSeparator());

       this.data.stream()
               .forEach(animal -> strb.append(animal.getName())
                       .append(" ")
                       .append(animal.getCaretaker())
                       .append(System.lineSeparator()));

       return strb.toString();
    }



}

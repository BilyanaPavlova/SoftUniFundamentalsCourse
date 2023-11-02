package groomingSalon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GroomingSalon {

    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(this.data.size() < this.capacity){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        Predicate<Pet> nameExists = pet -> pet.getName().equals(name);
        Pet pet = data.stream().filter(nameExists).findFirst().orElse(null);
        if (pet!=null) {
            data.remove(pet);
            return true;
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet foundPet = data.stream().filter(pet -> pet.getName().equals(name)).findFirst().orElse(null);
        if(foundPet.getOwner().equals(owner)){
            return foundPet;
        }

//        for (Pet pet : data) {
//            if (pet.getName().equals(name) && pet.getOwner().equals("owner")) {
//
//                return pet;
//            }
//        }

            return null;

    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder statistics = new StringBuilder("The grooming salon has the following clients: \n");
        for (Pet pet : this.data) {
            statistics.append(pet.getName()).append(" ").append(pet.getOwner()).append("\n");
        }
        return statistics.toString();
    }
}

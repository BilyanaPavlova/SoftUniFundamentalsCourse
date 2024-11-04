package iterable_iterator_comparable_comparator.exc.ex08_Pets_Clinics;

public class Room {
    private Pet pet;
    private boolean isOccupied;

    public Room() {
        this.isOccupied = false;
    }

    public void occupy(Pet pet) {
        this.pet = pet;
        this.isOccupied = true;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void release() {
        this.pet = null;
        this.isOccupied = false;
    }

    public Pet getPet() {
        return this.pet;

    }
}

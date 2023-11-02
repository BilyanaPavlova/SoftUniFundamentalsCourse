package groomingSalon;

public class Main {

    public static void main(String[] args) {

        GroomingSalon salon = new GroomingSalon(20);

        Pet dog = new Pet("Ellias",5, "Tim");
        System.out.println(dog);

        salon.add(dog);

        System.out.println(salon.remove("Ellias"));
        System.out.println(salon.remove("Pufa"));

        Pet cat = new Pet("Bella", 2, "Mia");
        Pet bunny = new Pet("Zak", 4, "Jon");
        salon.add(cat); salon.add(bunny);

        Pet pet = salon.getPet("Bella", "Mia");
        System.out.println(pet); // Bella 2 - (Mia)

        salon.add(new Pet("Bella", 2, "Gogo"));
        Pet pet1 = salon.getPet("Bella", "Mia");
        System.out.println(pet1); // Bella 2 - (Mia)

        Pet pet2 = salon.getPet("Bella", "Gogo");
        System.out.println(pet2);

        System.out.println(salon.getCount());

        System.out.println(salon.getStatistics());

    }
}

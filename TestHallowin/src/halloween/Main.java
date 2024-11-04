package halloween;


public class Main {
    public static void main(String[] args) {

       //TODO
        House house = new House(6);
        Kid firstKid = new Kid("Yoana", 10, "Oso");
        house.addKid(firstKid);
        System.out.println(house.removeKid("Sara"));
        System.out.println(house.removeKid("Yoana"));
        Kid secondtKid = new Kid("Lily", 5, "Pirina");
        Kid thirdKid = new Kid("Anna", 7, "Pirotska");
        house.addKid(secondtKid);
        house.addKid(thirdKid);
        Kid kid = house.getKid("Pirotska");
        System.out.println(kid);
        System.out.println(house.getStatistics());
        System.out.println(house.getAllKids());
    }
}

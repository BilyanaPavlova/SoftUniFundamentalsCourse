package iterable_iterator_comparable_comparator.exc.ex08_Pets_Clinics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Store the pets and clinics in maps, key is the name of the pet/clinic, value is the object
        // so we can easily retrieve them by name
        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Create":
                    String type = tokens[1];
                    if (type.equals("Pet")) {
                        String name = tokens[2];
                        int age = Integer.parseInt(tokens[3]);
                        String kind = tokens[4];
                        Pet pet = new Pet(name, age, kind);
                        pets.put(name, pet);  // Store the pet in the map

                    } else if(type.equals("Clinic")) {

                            String name = tokens[2];
                            int rooms = Integer.parseInt(tokens[3]);
                            Clinic clinic = null;
                            try {
                                clinic = new Clinic(name, rooms);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage()); // Print the exception message and continues running the program
                            }
                        try {
                            clinics.put(name, clinic);  // Store the clinic in the map
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case "Add":
                    String petName = tokens[1];
                    String clinicName = tokens[2];
                    if(!clinics.containsKey(clinicName) || !pets.containsKey(petName)) {
                        System.out.println("Invalid Operation!");
                        continue;
                    }
                    // Retrieve the pet and clinic from the maps and add the pet to the clinic
                   Clinic clinicToAddTo = clinics.get(clinicName);
                    Pet petToAdd = pets.get(petName);

                    try {
                        System.out.println(clinicToAddTo.addPet(petToAdd));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "Release":
                    clinicName = tokens[1];
                    // Retrieve the clinic from the map and release a pet from it
                    Clinic clinicToReleaseFrom = clinics.get(clinicName);
                    try {
                        System.out.println(clinicToReleaseFrom.releasePet());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasEmptyRooms":
                    clinicName = tokens[1];
                    // Retrieve the clinic from the map and check if it has empty rooms
                    Clinic clinicToCheck = clinics.get(clinicName);
                    System.out.println(clinicToCheck.hasEmptyRooms());
                    break;
                case "Print":
                    clinicName = tokens[1];
                    // Retrieve the clinic from the map and print its rooms
                    Clinic clinicToPrint = clinics.get(clinicName);
                    if (tokens.length == 2) {
                        clinicToPrint.print();
                    } else {
                        int roomIndex = Integer.parseInt(tokens[2]);
                        clinicToPrint.print(roomIndex);
                    }
                    break;
            }
        }
    }
}

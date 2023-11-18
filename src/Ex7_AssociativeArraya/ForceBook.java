package Ex7_AssociativeArraya;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<String>> forces = new LinkedHashMap<>();

        String input = sc.nextLine();
        while(true){
            if(input.equals("Lumpawaroo")){

                //print
                forces.entrySet().forEach(entry -> {
                    if (!entry.getValue().isEmpty()) {
                        System.out.printf("Side: %s, Members: %d\n",
                                entry.getKey(), entry.getValue().size());
                        List<String> str = entry.getValue();
                        for (String user :
                                str) {
                            System.out.printf("! %s\n", user);
                        }
                    }
                });

                return;
            }
            String[] inputElements;

            String forceSide = "";
            String forceUser = "";

            if(input.contains(" | ")){
            inputElements = input.split( " \\| ");


//            if(inputElements[1].equals("|")){
                forceSide = inputElements[0];
                forceUser = inputElements[1];
            }

            if(input.contains(" -> ")){
//            if(inputElements[1].equals("->")){
                inputElements = input.split( " -> ");

                forceSide = inputElements[1];
                forceUser = inputElements[0];
            }

                boolean isSuchForceSide = false;
                boolean isSuchForceUser = false;

                // iterate the map to check for keys and values
            String foundKey = "";
                for(Map.Entry<String, List<String>> entry : forces.entrySet()){
                    if (entry.getKey().equals(forceSide)){
                        isSuchForceSide = true;
                    }
                    if(entry.getValue().contains(forceUser)){
                        foundKey = entry.getKey();
                        isSuchForceUser = true;
                    }
                }

// If there is no such force user and no such force side -> create a new force side and add the force user to the corresponding side.
            if(input.contains("|")){

                if(!isSuchForceSide && !isSuchForceUser){
                    forces.put(forceSide, new ArrayList<>());
                    forces.get(forceSide).add(forceUser);
                    isSuchForceUser = false;
                    isSuchForceSide = false;
                }

//Only if there is no such force user on any force side -> add the force user to the corresponding side.

                if(isSuchForceSide && !isSuchForceUser){

                    forces.get(forceSide).add(forceUser);
                    isSuchForceUser = false;
                    isSuchForceSide = false;
                }
            }

            if(input.contains("->")){

//if there is such force user already -> change their side.
                if(isSuchForceUser) {

                    //remove from its original side
                    forces.get(foundKey).remove(forceUser);

                    //add to the other side
                    List<String> entry = forces.get(forceSide);
                    entry.add(forceUser);
                }
//If there is no such force user on any force side -> add the force user to the corresponding force side.
                if(!isSuchForceUser && isSuchForceSide){
                    forces.get(forceSide).add(forceUser);
                }

//If there is no such force user and no such force side -> create a new force side and add the force user to the corresponding side.
                if(!isSuchForceUser && !isSuchForceSide){
                    forces.putIfAbsent(forceSide, new ArrayList<>());
                    forces.get(forceSide).add(forceUser);
                }

// Then you should print on the console: "{force_user} joins the {force_side} side!".
                System.out.printf("%s joins the %s side!\n", forceUser, forceSide);
                input = sc.nextLine();
                continue;

            }






            input = sc.nextLine();
        }


    }
}

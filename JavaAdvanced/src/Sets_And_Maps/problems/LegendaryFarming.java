package Sets_And_Maps.problems;

import com.sun.jdi.Value;

import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        Map<String, Integer> junk = new TreeMap<>();

        String input = sc.nextLine();;
        while(true){

            String[] materials = input.split("\\s+");
            for (int i = 0; i < materials.length; i+=2) {
                int numberOfMaterial = Integer.parseInt(materials[i]);
                String material = materials[i+1].toLowerCase();
                if (material.equals("fragments")
                    || material.equals("shards")
                    || material.equals("motes")){

                    int newValue = keyMaterials.get(material) + numberOfMaterial;
                    if (newValue > 250){
                        newValue = newValue - 250;
                        keyMaterials.put(material, newValue);
                        printResult(material, keyMaterials, junk);
                        return;
                    }
                    keyMaterials.put(material, newValue);
                }else {

                    if(junk.containsKey(material)){

                        junk.put(material, junk.get(material) + numberOfMaterial);
                    } else {
                        junk.putIfAbsent(material, numberOfMaterial);
                    }
                }
            }

            input = sc.nextLine();
        }
    }






    public static void printResult(String winningMaterial, Map<String, Integer> keyMaterials, Map<String, Integer> junk){

        if(winningMaterial.equals("shards")){

            System.out.print("Shadowmourne obtained!");
        }else if(winningMaterial.equals(("fragments"))){

            System.out.println("Valanyr obtained!");
        }else {

            System.out.println("Dragonwrath obtained!");
        }

        TreeMap<String, Integer> reversed = reverseMap(keyMaterials);
        for (Map.Entry<String, Integer> entry :
                reversed.entrySet()) {

            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue() );
        }

        for (Map.Entry<String, Integer> entry :
                junk.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue() );
        }


    }

    private static TreeMap<String, Integer> reverseMap (Map<String, Integer> keyMaterials){

        TreeMap<String, Integer> reversedTreeMap = new TreeMap<>(Collections.reverseOrder());
        reversedTreeMap.putAll(keyMaterials);

        return reversedTreeMap;
    }

}

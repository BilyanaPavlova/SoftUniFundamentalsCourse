package Ex7_AssociativeArraya;

import java.util.*;

public class Students {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List <Double>> hm = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());

        int count = 0;

        for (int i = 0; i < n; i++) {
            String student = sc.nextLine();
            double grade = Double.parseDouble(sc.nextLine());

            if(hm.containsKey(student)){
                hm.get(student).add(grade);
                continue;
            }

            hm.putIfAbsent(student, new ArrayList<>());
            hm.get(student).add(grade);


        }

        Map<String, Double> bestStudents = new LinkedHashMap<>();

        for(Map.Entry <String, List<Double>> entry : hm.entrySet()){

            double average = entry.getValue()
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.00);

            if(average >= 4.50){
                bestStudents.put(entry.getKey(), average);
            }
        }

        bestStudents.forEach((student, stGarde)-> System.out.printf("%s -> %.2f\n", student, stGarde));


    }
}

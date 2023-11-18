package Ex7_AssociativeArraya;

import java.util.*;

public class CompanyNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Map <String, List<String>> companyEmployees = new LinkedHashMap<>();

        while(true){
            if(input.equals("End")){

                for(Map.Entry<String, List<String>> entry : companyEmployees.entrySet()){
                    System.out.printf("%s\n", entry.getKey());
                    List<String> list = entry.getValue();
                    for (String str :
                            list) {
                        System.out.printf("-- %s\n", str);
                    }

                }
                return;
            }

            String[] inp = input.split(" -> ");

            String company = inp[0];
            String id = inp[1];

            boolean isIn = false;

                if(!companyEmployees.containsKey(company)){
                    companyEmployees.put(company, new ArrayList<>());
                    companyEmployees.get(company).add(id);
                } else{
                    for (String emplID : companyEmployees.get(company)) {
                        if(emplID.equals(id)){
                            isIn = true;
                            break;
                        }
                    }
                    if(!isIn){
                        companyEmployees.get(company).add(id);
                        isIn = true;
                    }
                }


            input = sc.nextLine();
        }


    }
}

package ExamPrep_MidExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> items = Arrays.stream(sc.nextLine().split(", "))
                .collect(Collectors.toList());

        List <String> inventory = new ArrayList<>();

        String command = sc.nextLine();

        while(!command.equals("Craft!")){

//            	•	"Collect - {item}" -
//            	you should add the given item to your inventory.
//            	If the item already exists, you should skip this line.
            if(command.contains("Collect")){
                String[] commandArr = command.split(" ");
                String item = commandArr[2];
                if (inventory.contains(item)){
                    continue;
                }else {
                    inventory.add(item);
                }
            }

            command = sc.nextLine();
        }

        System.out.println(inventory);
    }
}

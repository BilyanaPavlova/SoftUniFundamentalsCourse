package Ex3_Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class More6_LadyBugs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //read the number of cells
        int n = Integer.parseInt(sc.nextLine());

        //creates an array
        int[] cells = new int[n];

        // read the indexes of the bugs
        int [] bugsIndexes = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        // пълни масива с началните бъгс:

        for (int i = 0; i < bugsIndexes.length; i++) {
            cells[bugsIndexes[i]] = 1; //клетка с индекс на буболечка
        }
//        System.out.println(Arrays.toString(cells));


       String command = sc.nextLine();
        String [] commandArr = command.split(" ");

        while (!command.equals("end")){
            //чете команда и намира индексите и посоката

            commandArr = command.split(" ");
            int startIndex = Integer.parseInt(commandArr[0]);
            int aimedIndex = Integer.parseInt(commandArr[2]);
            String direction = commandArr[1];

           // given index is outside the field -> nothing happens

                if (startIndex > n-1 || startIndex < 0){
                    command = sc.nextLine();
                    continue; // skip the rest of the code in the loop
                            // and starts the loop again with the next iteration

                }



            if(direction.equals("right")){

                if (((startIndex + aimedIndex ) >= n)){
                    cells[startIndex] = 0;
//                    System.out.println(Arrays.toString(cells));
                }

                for (int j = startIndex + aimedIndex; j < n; j += aimedIndex) {

                    if (cells[j] != 1){
                        cells[j] = 1;
                        cells[startIndex] = 0;
//                        System.out.println(Arrays.toString(cells));
                        break;
                    } else if (cells[j] == 1 && j == n-1){
                        cells[startIndex] = 0;
                    }
                }
                }



            if(direction.equals("left")){
                if (((startIndex - aimedIndex ) < 0)){
                    cells[startIndex] = 0;
//                    System.out.println(Arrays.toString(cells));

                }
                for (int j = startIndex - aimedIndex; j >= 0; j -= aimedIndex) {
                    if (cells[j] != 1){
                        cells[j] = 1;
                        cells[startIndex] = 0;
//                        System.out.println(Arrays.toString(cells));
                        break;
                    }else if (cells[j] == 1 && j == 0){
                        cells[startIndex] = 0;
                    }
                }
            }
            command = sc.nextLine();
        }

        System.out.println(Arrays.toString(cells)
                .replace("[", "")
                .replace("]", "")
                .replace(",", ""));
    }
}

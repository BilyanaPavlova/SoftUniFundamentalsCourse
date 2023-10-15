package Ex5_Lists;

import java.util.*;

public class OrderArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String [] strArr = input.split("\\|+");
//        System.out.println(Arrays.toString(strArr));

        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = strArr[i].replaceAll("\\s+", " "); //чисти сртинга от спейсове
        }


        List<String> strList = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {

            strList.add(strArr[i].trim()); //трим = чисти всички спейсове птреди и след стринга
        }

        Collections.reverse(strList);
//        strList.forEach(el -> System.out.print(el + " "));
//        System.out.println();

        System.out.println(String.join(" ", strList));

        }





    }


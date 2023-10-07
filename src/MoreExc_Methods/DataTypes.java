package MoreExc_Methods;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        printOutput(command, sc);

    }

    public static void printOutput (String dataType, Scanner sc){
        if(dataType.equals("int")){
            System.out.println(Integer.parseInt(sc.nextLine())*2);
        }else if(dataType.equals("real")){
            System.out.printf("%.2f%n", Double.parseDouble(sc.nextLine())*1.5);
        }else if(dataType.equals("string")){
            System.out.printf("$%s$", sc.nextLine());
        }
    }
}

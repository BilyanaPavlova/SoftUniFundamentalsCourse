package exam;

import java.util.Scanner;

public class ScannerHasNextExample {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String song = sc.nextLine();
            while (true) {
                System.out.println("Now playing: " + song + " " + "by Artist");
                if (!sc.hasNext()) {
                    System.out.println("No more songs!");
                    return;
                }

                song = sc.nextLine();
            }
        }




}

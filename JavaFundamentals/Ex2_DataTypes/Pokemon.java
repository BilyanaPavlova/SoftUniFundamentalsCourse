package Ex2_DataTypes;

import java.util.Scanner;

public class Pokemon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int M = Integer.parseInt(sc.nextLine());
        int Y = Integer.parseInt(sc.nextLine());
        int count = 0;
        int originalN = N;

        while (N >= M){
            N = N - M;
            count++;

            if (N == 0.5*originalN){
                if (Y != 0) {
                    N = N / Y;
                }
            }
        }
        System.out.println(N);
        System.out.println(count);
    }
}

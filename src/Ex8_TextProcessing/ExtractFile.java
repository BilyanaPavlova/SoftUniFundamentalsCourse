package Ex8_TextProcessing;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\\\");

        String file = input[input.length - 1];
        String fileName = file.split("\\.")[0];
        String fileExtension = file.split("\\.")[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);

    }
}

package Ex6_Classes.articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(", ");
        Article article = new Article(input[0], input[1], input[2]);

        int n = Integer.parseInt(sc.nextLine());


        for (int i = 0; i < n; i++) {
            String [] command = sc.nextLine().split(": ");
            if (command[0].equals("Edit")){
                article.edit(command[1]);


            }
            if (command[0].equals("ChangeAuthor")){
                article.changeAuthor(command[1]);

            }
            if (command[0].equals("Rename")){
                article.rename(command[1]);

            }
        }

        System.out.println(article.toString());
    }
}

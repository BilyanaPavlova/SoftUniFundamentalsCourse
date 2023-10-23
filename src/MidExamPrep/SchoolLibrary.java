package MidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> books = Arrays.stream(sc.nextLine().split("&"))
                .collect(Collectors.toList());

        String command = sc.nextLine();


        while (!command.equals("Done")) {
            String[] com = command.split(" \\| ");

            if (command.contains("Add")) {
                String bookName = com[1];
                if (!isBookPresent(books, bookName)) {
                    books.add(0, bookName);
                }
            }

            if (command.contains("Take Book")) {
                String bookName = com[1];
//                if (isBookPresent(books, bookName)) {
                    books.remove(bookName);
//                }
            }

            if (command.contains("Swap Books")) {
                String bookName1 = com[1];
                String bookName2 = com[2];

                if(isBookPresent(books, bookName1) && isBookPresent(books, bookName2)){
                    String temp = bookName2;
                    int idx2 = books.indexOf(bookName2);
                    int idx1 = books.indexOf(bookName1);
                    books.set(idx2, bookName1);
                    books.set(idx1, temp);


                }
            }

            if (command.contains("Insert Book")) {
                String bookName = com[1];
                if(!isBookPresent(books, bookName)){
                    books.add(bookName);
                }


            }

            if (command.contains("Check Book")) {
                int idx = Integer.parseInt(com[1]);
                if(idx >= 0 && idx <= books.size()-1){
                    String bookName = books.get(idx);
                    System.out.println(bookName);
                }
            }

                command = sc.nextLine();
            }
        System.out.println(String.join(", ", books));

        }

        public static boolean isBookPresent (List < String > books, String bookName){
            for (int i = 0; i <= books.size() - 1; i++) {
                if (books.get(i).equals(bookName)) {
                    return true;
                }
            }
            return false;
        }
    }


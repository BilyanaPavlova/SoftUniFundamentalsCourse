package ExamPrep_FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem3_01_ThePianist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> pieceComposer = new LinkedHashMap<>();
        Map<String, String> pieceKey = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            pieceComposer.put(input.split("\\|")[0], input.split("\\|")[1]);
            pieceKey.put(input.split("\\|")[0], input.split("\\|")[2]);
        }

        String com = sc.nextLine();
        while(!com.equals("Stop")){
            String[] command = com.split("\\|");
            String instruction = command[0];
            String piece = command[1];

            if(instruction.equals("Add")){
                if(pieceComposer.containsKey(piece) && pieceKey.containsKey(piece)){
                    System.out.printf("%s is already in the collection!\n", piece);
                } else {
                    pieceComposer.put(piece, command[2]);
                    pieceKey.put(piece, command[3]);
                    System.out.printf("%s by %s in %s added to the collection!\n", piece, command[2], command[3]);
                }
            }

            if(instruction.equals("Remove")){
                if(pieceComposer.containsKey(piece) && pieceKey.containsKey(piece)){
                    pieceComposer.remove(piece);
                    pieceKey.remove(piece);
                    System.out.printf("Successfully removed %s!\n", piece);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
                }
            }

            if(instruction.equals("ChangeKey")){
                String newKey = command[2];

                if(pieceComposer.containsKey(piece) && pieceKey.containsKey(piece)){
                    pieceKey.put(piece, newKey);
                    System.out.printf("Changed the key of %s to %s!\n", piece, newKey);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
                }
            }


            com = sc.nextLine();
        }

//        "{Piece} -> Composer: {composer}, Key: {key}"
        pieceComposer.entrySet().forEach(entry ->
                System.out.println(entry.getKey() + " -> Composer: " + entry.getValue()
                        + ", Key: " + pieceKey.get(entry.getKey())));
    }
}

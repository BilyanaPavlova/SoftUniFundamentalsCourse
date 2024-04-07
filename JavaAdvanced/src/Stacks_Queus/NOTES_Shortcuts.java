package Stacks_Queus;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NOTES_Shortcuts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //четене на лист - ако съм декларирала лист в началото, след точка и ентер ми връща директно
        //правилната функция колект то лист
        List<String> list = Arrays.stream(sc.nextLine().split(""))
                .collect(Collectors.toList());
        
        //въртим фор цикъл през листа -> list.iter + enter = foreach цикъл
        for (String s : list) {
            
        }

        //въртим цикъл до n -> n.fori + enter
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {

        }

        //екстрактване на метод -> маркираме целия метод -> option+command+M (refacttor->extract->method)


    }
}

package Sets_And_Maps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IMPORTANT_differences_between_Sets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Sets
        // - very fast searching, removing, adding
        //- unique elements - no duplicates (if you add a duplicate , it is ignored !!!!!!!!!
        //-backed by hash tables

        //HashSet - not ordered (tree)
        //Use HashSet when you need fast access to elements and do not require them to be stored in any particular
        // order.

        //TreeSet - ordered in a natural (ascending) order (black-red tree)(backed by binary search tree)
        // Use TreeSet when you need the elements to be stored in sorted order or when you need to perform operations
        // like finding elements greater than or less than a given element.

        //LinkedHashSet -(backed by LinkedList) LinkedHashSet maintains the insertion order of elements,
        // which means that when you iterate over the set,
        // the elements are returned in the order in which they were inserted.
//----------------------------
        //Maps
        //-key -value pairs
        //unique keys
        //very fast
        //backed by hash tables

        //HashMap - unordered keys
        //TreeMap - ordered ascending keys, navigation methods (backed by binary search tree)
        //LinkedHashMap - keys ordered in the order of insertion

        //read line of integers and put them in a LinkedHashSet
//        LinkedHashSet<Integer> mySet = Arrays.stream(sc.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .collect(Collectors.toCollection(LinkedHashSet::new));

        //read line of Strings and put them in a LinkedHashSet
        LinkedHashSet<String> myStringsSet = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(LinkedHashSet::new)); //poslednoto w skobite e konstruktor
    
    

    }

    }


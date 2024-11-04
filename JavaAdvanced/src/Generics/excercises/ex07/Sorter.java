package Generics.excercises.ex07;

import java.util.Collections;
import java.util.List;

public class Sorter <T>{

    public static <T extends Comparable<T>> List<T> sort (Store<T> store){

        List <T> nStore = store.getList();

        Collections.sort(nStore);

        return nStore;
    }
}

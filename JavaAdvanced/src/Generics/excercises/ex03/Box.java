package Generics.excercises.ex03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Box <T> {

    private List<T> list;

    public Box() {
        list = new ArrayList<>();
    }

    public  void addElement (T e){
        this.list.add(e);
    }

    public List<T> swap (int idx1, int idx2){

        T first = this.list.get(idx1);
        T second = this.list.get(idx2);

        this.list.add(idx1, second);
        this.list.remove(idx1 + 1);
        this.list.add(idx2, first);
        this.list.remove(idx2 + 1);

        return this.list;
    }

//    public String swappedList(){
//        StringBuilder str = new StringBuilder();
//        for (T t : this.list) {
//            str.append(t);
//            str.append("\n");
//        }
//        return str.toString();
//    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        this.list.forEach(e -> {
            str.append( e.getClass().getName());
            str.append(": ");
            str.append(e);
            str.append("\n");
        });
        return str.toString();
    }
}

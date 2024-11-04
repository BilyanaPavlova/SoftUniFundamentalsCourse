package Generics.excercises.ex07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Store<T extends Comparable<T>> implements Iterable<T> {

    List<T> items;

    public Store() {
        this.items = new ArrayList<>();
    }

    public void add(T element) {
        this.items.add(element);
    }

    public T remove(int index) {
        T el = items.get(index);
        this.items.remove(index);
        return el;
    }

    public boolean contains(T element){

        return this.items.contains(element);
    }

    public void swap(int idx1, int idx2){
        T temp = this.items.get(idx1);
        this.items.set(idx1, this.items.get(idx2));
        this.items.set(idx2, temp);

    }

    public int countGreaterThan(T element){

        long c = this.items.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();

        return (int)c;
    }

    public T getMax(){
        return this.items.stream().max(Comparator.naturalOrder()).orElse(null);

    }

    public T getMin(){
        return this.items.stream().min(Comparator.naturalOrder()).orElse(null);

    }

//    public void print(){
//        for(T el: items){
//            System.out.println(el);
//        }
//    }

//
    public void print(){
        this.items.forEach(System.out::println);
    }




    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
       this.items.forEach(e -> str.append(e).append("\n"));
       return str.toString().trim();
    }

    public List<T> getList() {
        return this.items;
    }

    @Override
    public Iterator<T> iterator() {
        return this.items.iterator();
    }
}

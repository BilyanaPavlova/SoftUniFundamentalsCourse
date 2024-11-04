package Generics.lecture.scale;

public class Thing implements Comparable<Thing>{
    private int a;

    public Thing(int a){
        this.a = a;
    }

    @Override
    public int compareTo(Thing thing) {
        if (this.a < thing.a) {
            return -1;
        }
        if (this.a == thing.a) {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString(){
        return String.valueOf(this.a);
    }
}

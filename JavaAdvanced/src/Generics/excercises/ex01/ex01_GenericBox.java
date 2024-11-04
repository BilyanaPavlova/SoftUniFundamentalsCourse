package Generics.excercises.ex01;

public class ex01_GenericBox <T> {

    T data;

    public ex01_GenericBox(T data){
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        Class<?> clazz = this.data.getClass();
        strb.append(clazz.getName()).append(": ").append(this.data);
        return strb.toString();
    }





}

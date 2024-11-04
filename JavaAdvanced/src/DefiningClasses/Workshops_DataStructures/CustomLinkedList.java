package DefiningClasses.Workshops_DataStructures;

import java.util.function.Consumer;

public class CustomLinkedList {

    // има само една глава и един щаблон за създаване на елементи, който се навързват към главата
    // не е лист от елементи, а просто една глава, като самата глава има аадреса на следващата глава
    private Node head;
    int size = 0; //  броя на вързанните за главата елементи

    private static class Node {
        int element;
        Node next;

        Node (int element){
            this.element = element;
        }
    }

    public boolean isEmpty () {
        return this.head == null;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        if (this.isEmpty()){
            return null;
        }
        str.append(head.element + " ");
        Node currentNode = head;
        while(currentNode.next != null) {
            str.append(currentNode.next.element + " ");
            currentNode = currentNode.next;
        }
        return str.toString();
    }

    public void addFirst(int element) {
        if (this.isEmpty()){
            this.head = new Node(element);
        } else {
            Node first = new Node(element);
            first.next = this.head;
            this.head = first;
        }
        this.size++;
    }

    public void addLast(int element) {
        if (this.isEmpty()){
            this.head = new Node(element);
        } else {
            Node last = new Node(element);
            Node current = this.head;
            while(true){

                if (current.next == null){
                    current.next = last;
                    return;
                }
                current = current.next;

            }
        }

        this.size++;
    }

    public int get(int index){
        if (this.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int counter = 0;

        Node current = this.head;
        while (counter < index){
            if (current.next == null){
                throw new IndexOutOfBoundsException();
            }
            current = current.next;
            counter++;
        }
        return current.element;
    }

    public int removeFirst() {
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        int first = head.element;
        head = head.next;
        size--;
        return first;
    }

    public int removeLast(){
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        if (this.size == 1){
            int element = head.element;
            head = null;
            size--;
            return element;
        }
        Node current = this.head;
        Node last = null;
        while (current.next != null){
            last = current;
            current = current.next;
        }
        int element = current.element;
        last.next = null;
        size--;
        return element;
    }
    //– goes through the collection and executes a given action
    public void forEach(Consumer<Integer> consumer){
        Node current = this.head;
        while (current != null){
            consumer.accept(current.element);
            current = current.next;
        }
    }

    //int[] toArray() – returns the collection as an array
    public int[] toArray(){
        int[] arr = new int[this.size];
        Node current = this.head;
        int index = 0;
        while (current != null){
            arr[index++] = current.element;
            current = current.next;
        }
        return arr;
    }


}

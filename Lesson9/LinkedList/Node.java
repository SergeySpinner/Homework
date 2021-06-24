package Lesson9.LinkedList;

public class Node<T> {
    public T value;
    public Node<T> next;

    public Node(T value) {
        this.next = null;
        this.value = value;
    }
}

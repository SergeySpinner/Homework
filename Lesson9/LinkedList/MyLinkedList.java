package Lesson9.LinkedList;

public class MyLinkedList<T> {
    private Node<T> head;
    private T value;

    private int length = 0;

    public MyLinkedList() {
        this.head = null;
    }

    public void add(T value) {
        Node<T> temp = new Node<>(value);

        if (this.head == null)
            this.head = temp;
        else {
            Node<T> tempNode = this.head;
            while (tempNode.next != null)
                tempNode = tempNode.next;
            tempNode.next = temp;
        }
        length++;
    }

    public void add(int position, T value) {
        if (position > length + 1) {
            System.out.println("Out of range");
            return;
        }
        if (position == 1) {
            Node<T> tempNode = this.head;
            this.head = new Node<>(value);
            this.head.next = tempNode;
            return;
        }

        Node<T> tempNode = this.head;
        Node<T> prev = new Node<>(null);
        while (position - 1 > 0) {
            prev = tempNode;
            tempNode = tempNode.next;
            position--;
        }
        prev.next = new Node<T>(value);
        prev.next.next = tempNode;
    }

    public void remove(T value) {
        Node<T> prev = new Node<>(null);

        prev.next = this.head;
        Node<T> next = this.head.next;
        Node<T> tempNode = this.head;
        boolean exists = false;
        if (this.head.value == value) {
            this.head = this.head.next;
            exists = true;
        }
        while (tempNode.next != null) {
            if (tempNode.value == value) {
                prev.next = next;
                exists = true;
                break;
            }
            prev = tempNode;
            tempNode = tempNode.next;
            next = tempNode.next;
        }
        if (!exists && tempNode.value == value) {
            prev.next = null;
            exists = true;
        }
        if (exists)
            length--;
        else
            System.out.println("There is no same value in Linked List");

    }

    public void clear() {
        this.head = null;
        length = 0;
    }

    public boolean empty() {
        if (this.head != null)
            return false;
        else
            return true;
    }

    public int length() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{" + this.getClass().toString().split("\\.")[this.getClass().toString().split("\\.").length - 1] + ":");
        Node<T> tempNode = this.head;
        int numb = 1;
        while (tempNode != null) {
            result.append("Value#" + numb++ + '=' + tempNode.value + ',');
            tempNode = tempNode.next;
        }
        result.delete(result.length() - 1, result.length());
        result.append('}');
        return result.toString();
    }

}

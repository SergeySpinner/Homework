package Lesson15;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static ListNode generate() {
        List<Integer> integers = Arrays.asList(2,4,5,4,6,4,5,2,5,2);

        List<Integer> sorted = integers.stream().sorted().collect(Collectors.toList());

        ListNode head = new ListNode(0);
        ListNode current = head;

        for (Integer number : sorted) {
            current.next = new ListNode(number);
            current = current.next;
        }


        return head.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode iterationList = head;
        ListNode returnableList = new ListNode(0);
        returnableList.next = new ListNode(iterationList.val);
        ListNode current = returnableList.next;

        while (iterationList.hasNext()) {
            iterationList = iterationList.next;
            if (current.val != iterationList.val) {
                current.next = new ListNode(iterationList.val);
                current = current.next;
            }
        }
        return returnableList.next();
    }

    public static void main(String[] args) {
        ListNode test = generate();

        test = deleteDuplicates(test);

        ListNode printer = test;

        while (printer.hasNext()){
            System.out.println(printer.val);
            printer = printer.next();
        }
    }

    public static class ListNode implements Iterator {
        int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public boolean hasNext() {
            if (this.next == null)
                return false;
            else return true;
        }

        @Override
        public ListNode next() {
            return this.next;
        }
    }
}
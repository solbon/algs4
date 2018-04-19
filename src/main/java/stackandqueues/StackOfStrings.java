package stackandqueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class StackOfStrings implements Iterable<String> {
    private Node first;

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<String> {

        // keep current node as pointer which we can move
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        String item;
        Node next;
    }

    public void push(String item) {
        Node oldFirst = first;      // make reference to first node
        first = new Node();    // replace first node with new Node()
        first.item = item;          // set new first node with values
        first.next = oldFirst;      // link new first node with old first node
    }

    public String pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        String item = first.item;   // get value of the first node
        first = first.next;         // make next node as the first node, old first node will be removed as it has no connections anymore
        return item;                // return value
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        StackOfStrings stack = new StackOfStrings();
//        Stack<String> stack = new Stack<>();          //java.util.Stack iterator return in FIFO mode (like Queue)
//        Deque<String> stack = new ArrayDeque<>();     //java.util.Deque iterator in LIFO mode (like Stack) - better version of Stack
        stack.push("first");
        stack.push("second");
        stack.push("third");
        stack.push("forth");
        System.out.printf("iterator: ");
        for (String s : stack) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.print("stack.pop: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}
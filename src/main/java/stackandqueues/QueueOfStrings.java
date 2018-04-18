package stackandqueues;

import java.util.NoSuchElementException;

public class QueueOfStrings {

    private Node first;
    private Node last;
    private int n;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(String item) {
        Node oldLast = last;
        Node last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        String item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
}

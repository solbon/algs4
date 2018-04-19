package stackandqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueOfStrings implements Iterable<String> {

    private Node first;
    private Node last;
    private int n;

    @Override
    public Iterator<String> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<String> {

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

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(String item) {
        Node oldLast = last;

        // create last Node
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            // avoid loitering (праздное шатание)
            first = last;
        } else {
            // add to the end of the queue
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

    public static void main(String[] args) {
        QueueOfStrings queue = new QueueOfStrings();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.print(item + " ");
        }
    }
}

package assignment2_queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int n;

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node<Item> oldFirst = first;
        first = new Node<>();
        first.value = item;
        first.next = oldFirst;
        first.prev = null;
        if (last == null) last = first;
        if (oldFirst != null) oldFirst.prev = first;
        n++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node<Item> oldLast = last;
        last = new Node<>();
        last.value = item;
        last.next = null;
        last.prev = oldLast;
        if (first == null) first = last;
        if (oldLast != null) oldLast.next = last;
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item value = first.value;
        first.prev = null;
        first = first.next;
        if (first == null) last = null;
        n--;
        return value;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item value = last.value;
        last.next = null;
        last = last.prev;
        if (last == null) first = null;
        n--;
        return value;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeStackIterator();
//        return new DequeQueueIterator();
    }

    private class DequeStackIterator implements Iterator<Item> {
        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item value = current.value;
            current = current.next;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class DequeQueueIterator implements Iterator<Item> {
        private Node<Item> current = last;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item value = current.value;
            current = current.prev;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node<Item> {
        Node<Item> next;
        Node<Item> prev;
        Item value;
    }

    // unit testing (optional)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.addLast("1st");
        deque.addLast("2nd");
        deque.addLast("3rd");
        System.out.println("size = " + deque.size());
        for (String s : deque) {
            System.out.printf(s + " ");
        }
        System.out.println();
        while (!deque.isEmpty()) {
            System.out.print(deque.removeLast() + " ");
        }
    }
}

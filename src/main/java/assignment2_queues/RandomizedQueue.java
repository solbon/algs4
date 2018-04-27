package assignment2_queues;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private static final int INIT_CAPACITY = 8;
    private Item[] items;
    private int n;

    // construct an empty randomized queue
    public RandomizedQueue() {
        items = (Item[]) new Object[INIT_CAPACITY];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (n == items.length) resize(items.length * 2);
        items[n++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (n == 0) throw new NoSuchElementException();

        int random = StdRandom.uniform(n--);
        Item value = items[random];

        // copy all items beside item removed at random index
        items = shrink(items, n, random);

        // resize the array if needed
        if (n < items.length / 4) resize(items.length / 2);
        return value;
    }

    private Item[] shrink(Item[] values, int pointer, int random) {
        Item[] temp = (Item[]) new Object[values.length];
        for (int i = 0, j = 0; i < pointer; i++, j++) {
            if (i == random) {
                temp[i] = values[++j];
                continue;
            }
            temp[i] = values[j];
        }
        return temp;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (n == 0) throw new NoSuchElementException();
        return items[StdRandom.uniform(n)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedIterator();
    }

    private class RandomizedIterator implements Iterator<Item> {
        private int counter = n;

        private Item[] copy = (Item[]) new Object[n];

        RandomizedIterator() {
            for (int i = 0; i < n; i++) {
                copy[i] = items[i];
            }
        }

        @Override
        public boolean hasNext() {
            return counter > 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            int random = StdRandom.uniform(counter--);
            Item value = copy[random];
            copy = shrink(copy, counter, random);
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void resize(int capacity) {
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    // unit testing (optional)
    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        for (int i = 0; i < 10; i++) {
            rq.enqueue(i);
        }
        System.out.println(rq.dequeue());
        System.out.println(rq.dequeue());
        for (Integer i : rq) {
            System.out.printf(i + " ");
        }
        System.out.println();
        for (Integer i : rq) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }
}
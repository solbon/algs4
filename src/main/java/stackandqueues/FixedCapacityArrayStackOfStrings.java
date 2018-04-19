package stackandqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityArrayStackOfStrings implements Iterable<String> {
    private String[] array;
    private int n;

    public FixedCapacityArrayStackOfStrings(int capacity) {
        array = new String[capacity];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(String item) {
        array[n++] = item;
    }

    public String pop() {
        return array[--n];
    }

    @Override
    public Iterator<String> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<String> {
        private int pointer = n - 1;

        @Override
        public boolean hasNext() {
            return pointer >= 0;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[pointer--];
        }
    }


    public static void main(String[] args) {
        FixedCapacityArrayStackOfStrings stack = new FixedCapacityArrayStackOfStrings(10);
        stack.push("first");
        stack.push("second");
        stack.push("third");
        Iterator<String> it = stack.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.print(item + " ");
        }
    }
}

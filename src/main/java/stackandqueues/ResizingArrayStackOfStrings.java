package stackandqueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStackOfStrings implements Iterable<String>{
    private int n;
    private String[] array;

    ResizingArrayStackOfStrings() {
        array = new String[2];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(String item) {
        if (n == array.length) {        // if array is full, resize it to double (twice bigger)
            resize(2 * array.length);
        }
        array[n++] = item;
    }

    // this method resize the array by @capacity value
    private void resize(int capacity) {
        String[] copy = new String[capacity];
        System.arraycopy(array, 0, copy, 0, n);
        array = copy;
    }

    public String pop() {
        String item = array[--n];
        array[n] = null;                // this is for garbage collector
        if (n < array.length / 4) {     // resize to half only if size of array is quarter empty
            resize(array.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<String> iterator() {
        return new ResizingArrayIterator();
    }

    private class ResizingArrayIterator implements Iterator<String> {
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
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        stack.push("forth");
        Iterator<String> it = stack.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}

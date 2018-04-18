package stackandqueues;

public class ResizingArrayStackOfStrings {
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
}

package stackandqueues;

public class FixedCapacityArrayStackOfStrings {
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
}

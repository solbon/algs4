package stackandqueues;

public class StackOfStrings {
    private Node first;

    private class Node {
        String item;
        Node next;
    }

    public void push(String item) {
        Node oldFirst = first;      // make reference to first node
        Node first = new Node();    // replace first node with new Node()
        first.item = item;          // set new first node with values
        first.next = oldFirst;      // link new first node with old first node
    }

    public String pop() {
        String item = first.item;   // get value of the first node
        first = first.next;         // make next node as the first node, old first node will be removed as it has no connections anymore
        return item;                // return value
    }

    public boolean isEmpty() {
        return first == null;
    }

}


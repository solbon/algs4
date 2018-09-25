import assignments.ch2_queues.Deque;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    private Deque<String> deque;

    @BeforeEach
    void setUp() {
        deque = new Deque<>();
    }

    @AfterEach
    void tearDown() {
        deque = null;
    }

    @Test
    void isEmpty() {
        assertTrue(deque.isEmpty());
        deque.addFirst("1st");
        assertFalse(deque.isEmpty());
    }

    @Test
    void size() {
        deque.addFirst("1");
        deque.addFirst("2");
        deque.addFirst("3");
        assertEquals(3, deque.size());
    }

    @Test
    void addFirst() {
        deque.addFirst("1");
        deque.addFirst("2");
        deque.addFirst("3");
        assertEquals("3", deque.removeFirst());
        assertEquals("2", deque.removeFirst());
        assertEquals("1", deque.removeFirst());
    }

    @Test
    void addLast() {
        deque.addLast("1");
        deque.addLast("2");
        assertEquals("1", deque.removeFirst());
        assertEquals("2", deque.removeFirst());
    }

    @Test
    void removeFirst() {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(0);
        deque.removeLast();
        deque.isEmpty();//         ==> true
        deque.addLast(6);
        deque.size();     //       ==> 1
//        deque.removeFirst();//     ==> 0
        assertEquals(new Integer(6), deque.removeFirst());
    }

    @Test
    void removeLast() {
        deque.addLast("1");
        deque.addLast("2");
        deque.addLast("3");
        assertEquals("3", deque.removeLast());
        assertEquals("2", deque.removeLast());
        assertEquals("1", deque.removeLast());
    }

    @Test
    void iterator() {
        deque.addLast("1");
        deque.addLast("2");
        deque.addLast("3");
        Iterator<String> iterator = deque.iterator();
        assertNotNull(iterator);
        assertEquals("1", iterator.next());
        assertEquals("2", iterator.next());
        assertEquals("3", iterator.next());
    }

}
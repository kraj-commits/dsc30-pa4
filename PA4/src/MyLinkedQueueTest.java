import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedQueueTest {
    MyLinkedQueue q1;
    MyLinkedQueue q2;
    MyLinkedQueue q3;
    MyLinkedQueue q4;

    @BeforeEach
    public void initDefaultConstructor() {
        q1 = new MyLinkedQueue();
        q2 = new MyLinkedQueue();
        q3 = new MyLinkedQueue();
        q3.enqueue("a");
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0, q1.size());
        assertTrue(q1.isEmpty());
        assertEquals(null, q1.peek());

    }

    @Test
    public void testSize() {
        assertEquals(0, q1.size());
        assertEquals(1, q3.size());
        for (int i = 0; i < 10; i++) {
            q3.enqueue("h");
        }
        assertEquals(11, q3.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(q1.isEmpty());
        assertFalse(q3.isEmpty());
        q3.dequeue();
        assertTrue(q3.isEmpty());
    }

    @Test
    public void testEnqueue() {
        q1.enqueue("s");
        assertFalse(q1.isEmpty());
        assertEquals(1, q1.size());
        for (int i = 0; i < 10; i++) {
            q1.enqueue("h");
        }
        assertEquals(11, q1.size());
        q2.enqueue("g");
        String x = q2.dequeue();
        assertEquals("g", x);
        assertEquals("a", q3.peek());
    }

    @Test
    public void testPeek(){
        assertEquals(null, q2.peek());
        q2.enqueue("f");
        assertEquals("f", q2.peek());
        q1.enqueue("w");
        for (int i = 0; i < 10; i++){
            q1.enqueue("h");
        }
        assertEquals("w", q1.peek());

    }

    @Test
    public void testDequeue(){
        q2.enqueue("g");
        assertEquals("g", q2.dequeue());
        q3.dequeue();
        assertTrue(q3.isEmpty());
        assertEquals(null, q1.dequeue());

    }

    @Test
    public void toStringTest(){
        assertEquals("[(head) -> (tail)]", q1.toString());
        q1.enqueue("3");
        q1.enqueue("4");
        q1.enqueue("5");
        assertEquals("[(head) -> 3 -> 4 -> 5 -> (tail)]", q1.toString());
        q1.dequeue();
        assertEquals("[(head) -> 4 -> 5 -> (tail)]", q1.toString());

    }
}
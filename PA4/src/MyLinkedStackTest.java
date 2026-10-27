import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedStackTest {


    MyLinkedStack s1 = new MyLinkedStack();
    MyLinkedStack s2 = new MyLinkedStack();

    @Test
    public void testDefaultConstructor() {
        assertEquals(0, s1.size());
        Assertions.assertThrows(EmptyStackException.class, () -> {
            s2.pop();
        });
        Assertions.assertThrows(EmptyStackException.class, () -> {
            s2.peek();
        });

    }

    @Test
    public void testSize() {
        s1 = new MyLinkedStack();
        assertEquals(0, s1.size());
        s1.push("e");
        assertEquals(1, s1.size());
        s1.pop();
        s1.push("e");
        s1.push("e");
        assertEquals(2, s1.size());

    }

    @Test
    public void testisEmpty() {
        s1 = new MyLinkedStack();
        assertTrue(s1.isEmpty());
        s1.push("e");
        assertFalse(s1.isEmpty());
        s1.clear();
        assertTrue(s1.isEmpty());

    }

    @Test
    public void testPeek() {
        s1 = new MyLinkedStack();
        s1.push("Hello");
        assertEquals("Hello", s1.peek());
        assertEquals(1, s1.size());
        s1.pop();
        Assertions.assertThrows(EmptyStackException.class, () -> {
            s1.peek();
        });

    }

    @Test
    public void testPush() {
        s1.push("e");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            s1.push(null);
        });
        assertEquals("e", s1.pop());

        s2.push("e");
        s2.push("f");
        assertEquals("f", s2.pop());
    }

    @Test
    public void testPop() {
        Assertions.assertThrows(EmptyStackException.class, () -> {
            s2.pop();
        });
        s2.push("6");
        s2.push("8");
        assertEquals("8", s2.pop());
        assertEquals("6", s2.pop());
    }

    @Test
    public void toStringTest(){
        assertEquals("[]", s1.toString());
        s1.push("3");
        s1.push("4");
        s1.push("5");
        assertEquals("[5 -> 4 -> 3]", s1.toString());
        s1.pop();
        assertEquals("[4 -> 3]", s1.toString());

    }

    @Test
    public void clear() {
        s2.push("e");
        s2.clear();
        assertTrue(s2.isEmpty());
        Assertions.assertThrows(EmptyStackException.class, () -> {
            s2.pop();
        });
        Assertions.assertThrows(EmptyStackException.class, () -> {
            s2.peek();
        });
    }
}
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    DoublyLinkedList d = new DoublyLinkedList();

    @Test
    public void DoublyLinkedListTest(){
        assertEquals(0, d.size());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            d.get(0);
        });
        d.add("Hello");
        assertEquals(1, d.size());
        assertEquals("Hello", d.get(0));
    }

    @Test
    public void BoolAddTest(){
        d.add("G");
        d.add("F");
        assertTrue(d.add("H"));
        assertEquals("H", d.get(2));
        assertEquals(3, d.size());
        assertThrows(NullPointerException.class, () -> {
            d.add(null);
        });

    }

    @Test
    public void addTest(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            d.add(1, "Help");
        });
        d.add(0,"yes");
        d.add(1,"no");
        d.add(0,"maybe");
        assertEquals("no", d.get(2));
        assertEquals(3, d.size());
    }

    @Test
    public void clearTest() {
        d.add("J");
        assertEquals(1, d.size());
        d.clear();
        assertEquals(0, d.size());
        assertTrue(d.isEmpty());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            d.get(1);
        });
    }


    @Test
    public void containsTest(){
        d.add("belgium");
        d.add("france");
        assertFalse(d.contains("blue"));
        assertTrue(d.contains("france"));
        d.add("france");
        assertTrue(d.contains("france"));

    }

    @Test
    public void getTest(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            d.get(0);
        });
        d.add("s");
        assertEquals("s", d.get(0));
        d.remove(0);
        d.add("r");
        d.add("g");
        assertEquals("g", d.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            d.get(2);
        });

    }

    @Test
    public void isEmptyTest(){
       assertTrue(d.isEmpty());
       d.add("g");
       assertFalse(d.isEmpty());
       d.remove(0);
       assertTrue(d.isEmpty());
       d.add("j");
       d.add("o");
       d.add("b");
       d.clear();
       assertTrue(d.isEmpty());

    }

    @Test
    public void removeTest(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            d.remove(1);
        });
        d.add("g");
        d.remove(0);
        assertTrue(d.isEmpty());
        d.add("h");
        d.add("p");
        assertEquals("p", d.remove(1));
    }

    @Test
    public void setTest(){
        d.add("g");
        d.add("j");
        d.add("k");
        assertEquals("j", d.set(1, "h"));
        assertThrows(IndexOutOfBoundsException.class, () -> {
            d.set(5, "l");
        });
        assertThrows(NullPointerException.class, () -> {
            d.set(1, null);
        });

    }

    @Test
    public void sizeTest(){
        assertEquals(0, d.size());
        d.add("j");
        d.add("o");
        assertEquals(2, d.size());
        d.remove(0);
        assertEquals(1, d.size());
        d.clear();
        assertEquals(0, d.size());
    }

    @Test
    public void toStringTest(){
        assertEquals("[(head) -> (tail)]", d.toString());
        d.add("3");
        d.add("4");
        d.add("5");
        assertEquals("[(head) -> 3 -> 4 -> 5 -> (tail)]", d.toString());
        d.remove(2);
        assertEquals("[(head) -> 3 -> 4 -> (tail)]", d.toString());

    }


}
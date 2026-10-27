/*
    Name: Karan Raj
    PID:  200175861
 */

import java.util.EmptyStackException;

/**
 * Adapter pattern stack
 * adapting from dll
 *
 * @author Karan Raj
 * @since October 27th, 2026
 */

public class MyLinkedStack {

    private DoublyLinkedList dll;

    /**
     * Default constructor
     * for stack, steals
     * from dll
     */
    public MyLinkedStack() {
        dll = new DoublyLinkedList();
    }

    /**
     * Size method
     * returns num
     * elements in stack
     * steals from dll
     */
    public int size() {

        return dll.size();
    }

    /**
     * IsEmpty method, steals
     * from dll
     * @return boolean result
     */
    public boolean isEmpty() {

        return dll.isEmpty();
    }

    /**
     * Peek method, looks
     * at top value and returns it
     * Steals from dll
     * @return String data of node
     * @throws EmptyStackException catches index out of bounds
     * and throws exception
     */
    public String peek() {

        try {
            return dll.get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new EmptyStackException();
        }
    }

    /**
     * Push method, steals from dll
     * by adding to 0th index
     * @param element String data of
     *                new node
     * @throws IllegalArgumentException if element is null
     */
    public void push(String element) {
        try {
            dll.add(0, element);
        } catch (NullPointerException e){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Pop method, adapts
     * from dll by removing
     * at 0th index
     * @throws EmptyStackException catches index out of bounds
     * and throws exception
     */
    public String pop() {

        try {
            return dll.remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw new EmptyStackException();
        }
    }

    /**
     * Returns contents of stack
     * as a string
     * @return output string
     */
    @Override
    public String toString() {
        String output = "[";
        if (!dll.isEmpty()) {
            output = output + dll.get(0);
            for (int i = 1; i < dll.size(); i++) {
                output = output + " -> " + dll.get(i);
            }
        }
        return output + "]";
    }

    /**
     * Clears the contents of
     * the stack,steals from
     * dll
     */
    public void clear() {
        dll.clear();
    }
}

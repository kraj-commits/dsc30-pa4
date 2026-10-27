/*
    Name: Karan Raj
    PID:  200175861
 */

/**
 * Adapter pattern queue
 * from linked list
 *
 * @author Karan Raj
 * @since October 27th, 2026
 */

public class MyLinkedQueue {

    /* instance variables, feel free to add if you need */
    private DoublyLinkedList dll;

    /**
     * Constructor for queue
     * Uses DLL default constructor
     */
    public MyLinkedQueue() {
        dll = new DoublyLinkedList();
    }

    /**
     * Size method for queue
     * Steals from dll
     * @return the size
     */
    public int size() {

        return dll.size();
    }

    /**
     * isEmpty method stolen
     * from dll
     * @return the boolean result
     */
    public boolean isEmpty() {

        return dll.isEmpty();
    }

    /**
     * Adds to the end
     * of the dll
     * steals the default
     * add method from dll
     * @param data the value of the new
     *             elem
     * @throws IllegalArgumentException by catching
     * and throwing the null pointer
     * of the add method
     */
    public void enqueue(String data) {
         try {
             dll.add(data);
         } catch (NullPointerException e){
             throw new IllegalArgumentException();
         }
    }

    /**
     * The peek method
     * returns but does not
     * dequeue the element at
     * the front of the queue,
     * Steals the get method
     * from dll
     * @return the string value
     * of the front elem or null if
     * error
     */
    public String peek() {
        try{
            return dll.get(0);
        } catch (IndexOutOfBoundsException e){
            return null;
        }

    }

    /**
     * Removes node
     * from front of queue
     * Steals dll remove method
     * @return the string value of the
     * removed elem or null if error
     */
    public String dequeue() {
        try{
            return dll.remove(0);
        } catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    /**
     * Converts contents of the queue
     * to a string
     * steals toString method from dll
     * @return the string output
     */
    @Override
    public String toString() {
        String output = dll.toString();
        return output;
    }
}

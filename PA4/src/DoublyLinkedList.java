/*
 * NAME: Karan Raj
 * PID: 200175861
 */

import java.util.AbstractList;

/**
 * Doubly linked list
 *
 * @author Karan Raj
 * @since October 23rd 2026
 */
public class DoublyLinkedList extends AbstractList<String> {

    /* DLL instance variables */
    private int size = 1;
    private Node head;
    private Node tail;
    private static final int TWO = 2;

    /**
     * inner class that specifies the
     * behavior of node objects.
     */
    protected class Node {

        /* Node instance variables */
        String elem;
        Node next;
        Node prev;

        /**
         * Default node constructor
         * @param element the String value
         *                held by the node
         */
        private Node(String element) {
            elem = element;
            next = null;
            prev = null;

        }

        /**
         * Custom node constructor
         * @param element the String value
         *                held by the node
         * @param nextNode the node that proceeds
         * @param prevNode the node that precedes
         */
        private Node(String element, Node nextNode, Node prevNode) {
            elem = element;
            next = nextNode;
            prev = prevNode;
        }

        /**
         * A node method that alters
         * the String data of the node
         * @param element the new data
         */
        public void setElement(String element) {
            elem = element;
        }

        /**
         * A node method that returns
         * the data of the node
         * @return the String data of the node
         */
        public String getElement() {

            return elem;
        }

        /**
         * A node method that assigns
         * the next value of the node
         * to another node
         * @param n the next node
         */
        public void setNext(Node n) {
            next = n;
        }

        /**
         * A node method that returns
         * the node stored in the next field
         * of this node
         * @return the Next node
         */
        public Node getNext() {

            return next;
        }

        /**
         * A node method that
         * changes the previous field
         * of the node to another node
         * or null
         * @param p the new value of the prev
         *          field
         */
        public void setPrev(Node p) {
            prev = p;
        }

        /**
         * A node method that returns
         * the node stored in the prev
         * field of the node.
         * @return the previous node
         */
        public Node getPrev() {

            return prev;
        }

        /**
         * A node method that deletes a node
         */
        public void remove() {
            next = null;
            prev = null;
        }
    }

    /**
     * The default constructor that creates
     * an empty DLL with a head and tail
     */
    public DoublyLinkedList() {
        head = new Node(null);
        tail = new Node(null);
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;

    }

    /**
     * Returns the number of non-dummy
     * nodes in the list
     * @return the int size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Appends a node and returns true
     * @param element the string data of the new
     *                node
     * @return boolean True after execution
     * @throws NullPointerException if the data
     * of the new node is null
     */
    @Override
    public boolean add(String element) throws NullPointerException {
        if (element == null){
            throw new NullPointerException();
        }

        if (size == 0){
            Node currNode = new Node(element, tail, head);
            head.setNext(currNode);
            tail.setPrev(currNode);
        }

        else {
            Node prevNode = tail.getPrev();
            Node appendNode = new Node(element, tail, prevNode);
            prevNode.setNext(appendNode);
            tail.setPrev(appendNode);
        }

        size++;

        return true;
    }

    /**
     * Inserts the node at the
     * specified index
     * @param element the data of the
     *                new node
     * @param index the position the node
     *              is added at
     * @throws IndexOutOfBoundsException if
     * index takes an inappropriate value
     * via getNth.
     * @throws NullPointerException if value of
     * node is null
     */
    @Override
    public void add(int index, String element) throws
            IndexOutOfBoundsException, NullPointerException {
        if ((index < 0) || (index > size)){
            throw new IndexOutOfBoundsException();
        }

        if (element == null){
            throw new NullPointerException();
        }

        Node prevNode = head;


        for (int i = 0; i < index; i++) {
            prevNode = prevNode.getNext();
            }

        Node nextNode = prevNode.getNext();
        Node currNode = new Node(element, nextNode, prevNode);
        prevNode.setNext(currNode);
        nextNode.setPrev(currNode);
        size++;
        }


    /**
     * Delinks the entire list
     */
    @Override
    public void clear() {
        head.setNext(null);
        tail.setNext(null);
        size = 0;
    }

    /**
     * Loops through the list
     * and returns true if the value
     * of a node is equal to the specified
     * element.
     * @param element the search term
     * @return the boolean result of the search
     */
    @Override
    public boolean contains(Object element) {
        if (size == 0){
            return false;
        }
        Node currNode = head.getNext();
        for (int i = 1; i <= size; i++){
            if (currNode.getElement().equals(element)){
                return true;
            }
            else {
                currNode = currNode.getNext();
            }
        }
        return false;
    }

    /**
     * A helper method that runs in O(N)
     * it finds the node at the specified index
     * using getNth
     * and returns its data
     * @param index the index of the node
     * @return the string value of the node
     * @throws IndexOutOfBoundsException via getNth
     */
    @Override
    public String get(int index) throws IndexOutOfBoundsException {
        Node target = getNth(index);
        String data = target.getElement();
        return data;
    }

    /**
     * A helper method that gets the
     * node at the specified index
     * @param index the index of the node being gotten
     * @return the Node that was gotten
     * @throws IndexOutOfBoundsException if below 1 or greater than size-1
     */
    private Node getNth(int index) throws IndexOutOfBoundsException {
        if ((index < 0) || (index >= size)){
            throw new IndexOutOfBoundsException();
        }

        Node currNode = head;

        for (int i = 0; i <= index; i++) {
            currNode = currNode.getNext();
        }

        return currNode;
    }

    /**
     * Returns true if the list
     * is empty and false otherwise
     * @return the boolean result
     */
    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    /**
     * Removes the node at the specified i
     * @param index the specified index
     * @return the String data
     * @throws IndexOutOfBoundsException via getNth
     * if index is not between 0 and size-1
     */
    @Override
    public String remove(int index) throws IndexOutOfBoundsException {

        Node target = getNth(index);
        String data = target.getElement();
        Node prevNode = target.getPrev();
        Node nextNode = target.getNext();

        target.setPrev(null);
        target.setNext(null);
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);

        size--;
        return data;
    }

    /**
     * Replaces the data at an index
     * and returns the old data
     * @param index the specified index
     * @param element the new data
     * @return the old data
     * @throws NullPointerException if the new
     * data is null
     * @throws IndexOutOfBoundsException via getNth
     * if index is not between 0 and size-1
     */
    @Override
    public String set(int index, String element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (element == null){
            throw new NullPointerException();
        }

        Node currNode = getNth(index);
        String oldData = currNode.getElement();
        currNode.setElement(element);

        return oldData;
    }

    /**
     * Converts the contents
     * of the list to a string.
     * @return the output string
     */
    @Override
    public String toString() {
       String output = "[(head) -> ";
       Node currNode = head;
       for (int i = 0; i < size; i++){
           currNode = currNode.getNext();
           String toAdd = currNode.getElement() + " -> ";
           output += toAdd;
       }

       output += "(tail)]";
       return output;
    }


    /* ==================== EXTRA CREDIT ==================== */

//    /**
//     * TODO
//     */
//    public void slice(int start, int end, int step) {
//        // TODO: complete implementation
//    }
//
//    /**
//     * TODO
//     */
//    public void swapHalves(int n, int start, int end) {
//        // TODO: complete implementation
//    }

}

/*
 * NAME: TODO
 * PID: TODO
 */

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Web browser implementing
 * dll, queue, and stack
 *
 * @author Karan Raj
 * @since October 27th, 2026
 */
public class WebBrowser {

    /* instance variables, feel free to add more if you need */
    private DoublyLinkedList openTabs;
    private MyLinkedQueue waiting;
    private MyLinkedStack closedTabs;
    private int currentIndex;

    /**
     * Default constructor
     * initiates empty dll,
     * empty stack and empty
     * queue
     */
    public WebBrowser() {
        openTabs = new DoublyLinkedList();
        waiting = new MyLinkedQueue();
        closedTabs = new MyLinkedStack();
        currentIndex = -1;
    }

    /**
     * Enqueue a website
     * @param website the website being added
     * @throws IllegalArgumentException if website
     * is null
     */
    public void addToQueue(String website) {
        waiting.enqueue(website);
    }

    /**
     * Dequeue's the website
     * from waiting and appends
     * it to open tabs.
     * @return the String name
     * of the website
     * @throws NoSuchElementException if
     * there are no waiting websites
     */
    public String openNextTab() {
        if (waiting.peek() == null) {
            throw new NoSuchElementException();
        }
        else {
            String website = waiting.dequeue();
            openTabs.add(website);
            currentIndex = openTabs.size() - 1;
            return website;
        }
    }

    /**
     * Removed the tab from
     * open tabs and pushes it to closed
     * tabs
     * @return the string value of the removed
     * tab
     * @throws NoSuchElementException if there isn't
     * an open tab to remove
     */
    public String closeCurrentTab() {

        try {
            String removedTab = openTabs.remove(currentIndex);
            if (currentIndex == openTabs.size()) {
                currentIndex--;
            }
            closedTabs.push(removedTab);
            return removedTab;
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    /**
     * Pops the tab at the top
     * of the stack of closed tabs
     * and prepends it
     * to the dll and makes it
     * the current tab
     * @return the string value
     * of the popped tab
     * @throws EmptyStackException if there
     * is no stack to pop from
     */
    public String reopenClosedTab() {

        String reopenedTab = closedTabs.pop();
        openTabs.add(0, reopenedTab);
        currentIndex = 0;
        return reopenedTab;
    }

    /**
     * Changes the current tab to
     * the tab at the specified index
     * @param index the index being switched to
     * @throws IndexOutOfBoundsException if the tab
     * being switched to doesn't exist
     */
    public void switchTab(int index) {
        if (index < 0 || index >= openTabs.size()) {
            throw new IndexOutOfBoundsException();
        }
        currentIndex = index;
    }

    /**
     * Returns the website stored in the current tab
     * @return the string of the current website
     * @throws NoSuchElementException if there aren't
     * open tabs
     */
    public String getCurrentTab() {

        try{
            return openTabs.get(currentIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    /**
     * Returns the number of open tabs
     * @return the int number of tabs
     */
    public int getNumOpenTabs() {

        return openTabs.size();
    }

    /**
     * clears all open tabs
     * closed tabs
     * and waiting tabs
     * (complete reset)
     * Just copies the constructor
     */
    public void clear() {
        openTabs = new DoublyLinkedList();
        waiting = new MyLinkedQueue();
        closedTabs = new MyLinkedStack();
        currentIndex = -1;

    }
}

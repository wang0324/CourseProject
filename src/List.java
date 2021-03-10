/**
 * Defines a doubly-linked list class
 * @author Robert Dam
 * @author Tram Nguyen
 * CIS 22C, Final Project
 */

import java.util.NoSuchElementException;

public class List<T> {
    private class Node {
        private T data;
        private Node next;
        private Node prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private int length;
    private Node first;
    private Node last;
    private Node iterator;

    /**** CONSTRUCTOR ****/

    /**
     * Instantiates a new List with default values
     *
     * @postcondition A List object is created with null nodes and length 0
     */
    public List() {
        first = null;
        last = null;
        iterator = null;
        length = 0;
    }

    /**** COPY CONSTRUCTOR ****/

    /**
     * Instantiates a new List by copying another List
     *
     * @param original the List to make a copy of
     * @postcondition a new List object, which is an identical but separate copy of
     *                the List original
     */
    public List(List<T> original) {
        if (original == null) { // No copying for null value
            return;
        }
        if (original.length == 0) { // Default values for empty list
            length = 0;
            first = null;
            last = null;
            iterator = null;
        } else { // Add nodes with same value as original
            Node temp = original.first;
            while (temp != null) {
                addLast(temp.data);
                temp = temp.next;
            }
            iterator = null;
        }
    }

    /**** ACCESSORS ****/

    /**
     * Returns the value stored in the first node
     *
     * @precondition length != 0
     * @return the value stored at node first
     * @throws NoSuchElementException when precondition is violated
     */
    public T getFirst() throws NoSuchElementException {
        if (length == 0) {
            throw new NoSuchElementException("getFirst: " + "No first element to access in empty list");
        }
        return first.data;
    }

    /**
     * Returns the value stored in the last node
     *
     * @precondition length != 0
     * @return the value stored in the node last
     * @throws NoSuchElementException when precondition is violated
     */
    public T getLast() throws NoSuchElementException {
        if (length == 0) {
            throw new NoSuchElementException("getLast: " + "No last element to access in empty list");
        }
        return last.data;
    }

    /**
     * Returns the current length of the list
     *
     * @return the length of the list from 0 to n
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns the element currently pointed at by iterator
     *
     * @precondition iterator != null
     * @return the value of node pointed at by the iterator
     * @throws NullPointerException when the precondition is violated
     */
    public T getIterator() throws NullPointerException {
        if (iterator == null) {
            throw new NullPointerException("getIterator: " + "Iterator is null. No data to access.");
        }
        return iterator.data;
    }

    /**
     * Returns whether the list is currently empty
     *
     * @return whether the list is empty
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Returns whether or not the iterator is off the end of the List, i.e. null
     *
     * @return whether the iterator is null
     */
    public boolean offEnd() {
        return iterator == null;
    }

    /**
     * Determines whether two Lists have the same data in the same order
     *
     * @param L the List to compare to this List
     * @return whether the two Lists are equal
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (o == this) { // Check for same memory location
            return true;
        } else if (!(o instanceof List)) { // Check for same type
            return false;
        } else {
            List<T> L = (List<T>) o;
            if (this.length != L.length) { // Check for same length
                return false;
            } else { // Go through both lists and check for same data
                Node node1 = this.first;
                Node node2 = L.first;
                while (node1 != null) {
                    if (!(node1.data.equals(node2.data))) {
                        return false;
                    }
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return true;
            }
        }
    }

    /**
     * Searches the List for the specified value using the linear search algorithm
     *
     * @param value the value to search for
     * @return the location of value in the List or -1 to indicate not found Note
     *         that if the List is empty we will consider the element to be not
     *         found post: position of the iterator remains unchanged
     */
    public int linearSearch(T value) {
        Node temp = first;
        for (int i = 1; i <= this.length; i++) {
            if (temp.data.equals(value))
                return i;
            else
                temp = temp.next;
        }
        return -1;
    }

    /**** MUTATORS ****/

    /**
     * Creates a new first element
     *
     * @param data the data to insert at the front of the list
     * @postcondition New node is created at first position
     */
    public void addFirst(T data) {
        if (length == 0) { // edge case
            first = last = new Node(data);
        } else { // general case
            Node newNode = new Node(data);
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        length++;
    }

    /**
     * Points the iterator at first and then advances it to the specified index
     *
     * @param index the index where the iterator should be placed
     * @precondition 0 < index <= length
     * @throws IndexOutOfBoundsException when precondition is violated
     */
    public void iteratorToIndex(int index) throws IndexOutOfBoundsException {
        if (index > length || index <= 0) {
            throw new IndexOutOfBoundsException("iteratorToIndex(): Index given is out of bounds.");
        }
        placeIterator();
        for (int i = 1; i < index; i++) {
            advanceIterator();
        }
    }

    /**
     * Creates a new last element
     *
     * @param data the data to insert at the end of the list
     * @postcondition A new last element is created
     */
    public void addLast(T data) {
        if (length == 0) { // edge case
            first = new Node(data);
            last = first;
        } else { // general case
            Node newNode = new Node(data);
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        length++;
    }

    /**
     * Removes the element at the front of the list
     *
     * @precondition list != 0
     * @postcondition Old first element removed from list
     * @throws NoSuchElementException when precondition is violated
     */
    public void removeFirst() throws NoSuchElementException {
        if (length == 0) {
            throw new NoSuchElementException("removeFirst: " + "Cannot remove from an empty List!");
        } else if (length == 1) { // edge case
            first = last = null;
            iterator = null;
        } else { // general case
            if (iterator == first) {
                iterator = null;
            }
            first = first.next;
            first.prev = null;
        }
        length--;
    }

    /**
     * Removes the element at the end of the list
     *
     * @precondition length != 0
     * @postcondition Old last element is removed
     * @throws NoSuchElementException when precondition is violated
     */
    public void removeLast() throws NoSuchElementException {
        if (length == 0) {
            throw new NoSuchElementException("removeLast: " + "Cannot remove last from empty list");
        } else if (length == 1) { // edge case
            first = null;
            last = null;
            iterator = null;
        } else { // general case
            if (iterator == last) {
                iterator = null;
            }
            last = last.prev;
            last.next = null;
        }
        length--;
    }

    /**
     * Places the iterator at the first node's position of the List
     */
    public void placeIterator() {
        iterator = first;
    }

    /**
     * Add the element after node referenced by the iterator
     *
     * @precondition iterator != null
     * @throws NullPointerException when iterator is off end
     * @postcondition the new data will be added next to the node pointed by
     *                iterator
     */
    public void addIterator(T data) throws NullPointerException {
        if (iterator == null) {
            throw new NullPointerException("addIterator: The iterator is null. Cannot add its data.");
        } else if (iterator == last) { // edge case
            addLast(data);
        } else { // general case
            Node newNode = new Node(data);
            newNode.next = iterator.next;
            iterator.next.prev = newNode;
            iterator.next = newNode;
            newNode.prev = iterator;
            length++;
        }
    }

    /**
     * Removes the element currently referenced by the iterator
     *
     * @precondition iterator != null
     * @throws NullPointerException when iterator is off end
     * @postcondition iterator will be null and node removed
     */
    public void removeIterator() throws NullPointerException {
        if (iterator == null) {
            throw new NullPointerException("removeIterator: Iterator is null, cannot remove node.");
        } else if (iterator == last) { // edge case 1
            removeLast();
        } else if (iterator == first) { // edge case 2
            removeFirst();
        } else { // general case
            iterator.next.prev = iterator.prev;
            iterator.prev.next = iterator.next;
            iterator = null;
            length--;
        }

    }

    /**
     * Advances the iterator by one node in the List
     *
     * @precondition !offEnd()
     * @throws NullPointerException when the precondition is violated
     */

    public void advanceIterator() throws NullPointerException {
        if (iterator == null) {
            throw new NullPointerException("advanceIterator: " + "Iterator is null and cannot advance.");
        }
        iterator = iterator.next;
    }

    /**
     * Reverse the iterator by one node in the List
     *
     * @precondition !offEnd()
     * @throws NullPointerException when the precondition is violated
     */

    public void reverseIterator() throws NullPointerException {
        if (iterator == null) {
            throw new NullPointerException("reverseIterator: Iterator is null. Cannot reverse it.");
        }
        iterator = iterator.prev;
    }

    /**** ADDITIONAL OPERATIONS ****/

    /**
     * Converts list into a String where elements are concatenated in order
     * separated by a space
     *
     * @return the List as a String for display
     */
    @Override
    public String toString() {
        String listAsString = "";
        Node temp = first;
        while (temp != null) {
            listAsString += temp.data + " ";
            temp = temp.next;
        }
        return listAsString;
    }

    /**
     * Prints the contents of the linked list to the screen In the format #:
     * <element> followed by a newline
     */
    public void printNumberedList() {
        Node temp = first;
        int i = 1;
        while (temp != null) {
            System.out.println(i + ". " + temp.data);
            temp = temp.next;
            i++;
        }
    }

}
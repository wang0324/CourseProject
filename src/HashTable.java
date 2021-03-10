/**
 * HashTable.java
 * @author Samhith Kakarla
 * CIS 22C Course Project
 */
import java.util.ArrayList;
import java.util.Comparator;

public class HashTable<T> {

    private int numElements;
    private ArrayList<List<T>> Table;

    /**
     * Constructor for the hash table. Initializes the Table to be sized according
     * to value passed in as a parameter Inserts size empty Lists into the table.
     * Sets numElements to 0
     *
     * @param size the table size
     */
    public HashTable(int size) {
        Table = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Table.add(i, new List<T>());
        }

        numElements = 0;

    }

    private int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            char a = key.charAt(i);
            sum += a;
        }
        return sum % Table.size();
    }

    /**
     * counts the number of keys at this index
     *
     * @param index the index in the Table
     * @precondition 0 <= index < Table.length
     * @return the count of keys at this index
     * @throws IndexOutOfBoundsException
     */
    public int countBucket(int index) throws IndexOutOfBoundsException {
        return Table.get(index).getLength();
    }

    /**
     * returns total number of keys in the Table
     *
     * @return total number of keys
     */
    public int getNumElements() {
        return numElements;
    }

    /**
     * Accesses a specified key in the Table
     *
     * @param t the key to search for
     * @return the value to which the specified key is mapped, or null if this table
     *         contains no mapping for the key.
     * @precondition t != null
     * @throws NullPointerException if the specified key is null
     */
    public T get(T t, String key, Comparator<T> c) throws NullPointerException {
        if (t == null) {
            throw new NullPointerException("search(): key is null");
        }

        int location = hash(key);
        Table.get(location).placeIterator();
        while(!Table.get(location).offEnd()) {
            if(c.compare(t,Table.get(location).getIterator()) == 0) {
                return Table.get(location).getIterator();
            }else {
                Table.get(location).advanceIterator();
            }
        }

        return null;
    }

    public List<T> search(T t, String key, Comparator<T> c) throws NullPointerException{
        if (t == null) {
            throw new NullPointerException("search(): key is null");
        }
        int location = hash(key);
        List<T> returnList = new List<T>();
        Table.get(location).placeIterator();
        while(!Table.get(location).offEnd()) {
            if(c.compare(t,Table.get(location).getIterator()) == 0) {
                returnList.addLast(Table.get(location).getIterator());
            }
            Table.get(location).advanceIterator();
        }
        return returnList;
    }

    /**
     * Determines whether a specified key is in the Table
     *
     * @param t the key to search for
     * @return whether the key is in the Table
     * @precondition t != null
     * @throws NullPointerException if the specified key is null
     */
    public boolean contains(T t, String key, Comparator<T> c) throws NullPointerException {
        if (get(t, key, c) == null) {
            return false;
        }
        return true;
    }

    /** Mutators */

    /**
     * Inserts a new element in the Table at the end of the chain in the bucket to
     * which the key is mapped
     *
     * @param t the key to insert
     * @precondition t != null
     * @throws NullPointerException for a null key
     */
    public void put(T t, String key) throws NullPointerException {
        int location = hash(key);
        Table.get(location).addLast(t);
        numElements++;

    }

    /**
     * removes the key t from the Table calls the hash method on the key to
     * determine correct placement has no effect if t is not in the Table or for a
     * null argument
     *
     * @param t the key to remove
     * @throws NullPointerException if the key is null
     */
    public void remove(T t, String key, Comparator<T> c) throws NullPointerException {
        if (t == null) {
            throw new NullPointerException("remove(): key is null");
        }

        int location = hash(key);
        Table.get(location).placeIterator();
        while(!Table.get(location).offEnd()) {
            if(c.compare(t,Table.get(location).getIterator()) == 0) {
                Table.get(location).removeIterator();
                numElements--;
            }else {
                Table.get(location).advanceIterator();
            }
        }

    }

    /**
     * Clears this hash table so that it contains no keys.
     */
    public void clear() {
        for (int i = 0; i < Table.size(); i++) {
            Table.set(i, new List<T>());
        }

        numElements = 0;
    }

    /** Additional Methods */

    /**
     * Prints all the keys at a specified bucket in the Table. Tach key displayed on
     * its own line, with a blank line separating each key Above the keys, prints
     * the message "Printing bucket #<bucket>:" Note that there is no <> in the
     * output
     *
     * @param bucket the index in the Table
     */
    public void printBucket(int bucket) {
        String printString = Table.get(bucket).toString();
        System.out.print(printString);
    }

    /**
     * Prints the first key at each bucket along with a count of the total keys with
     * the message "+ <count> -1 more at this bucket." Each bucket separated with
     * two blank lines. When the bucket is empty, prints the message "This bucket is
     * empty." followed by two blank lines
     */
    public void printTable() {
        for (int i = 0; i < Table.size(); i++) {
            if (!Table.get(i).isEmpty()) {
                System.out.println(
                        Table.get(i).getFirst() + " " + (Table.get(i).getLength() - 1) + " more at this bucket.");
            }
        }

    }

    /**
     * Starting at the first bucket, and continuing in order until the last bucket,
     * concatenates all elements at all buckets into one String
     *
     * @return
     */
    @Override
    public String toString() {
        String returnString = "";
        for (int i = 0; i < Table.size(); i++) {
            returnString += Table.get(i).toString();
        }
        return returnString;

    }

}
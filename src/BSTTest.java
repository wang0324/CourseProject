
/**
* BSTTest.java
* @author Tram
* Final Project 22C
*/

import java.util.NoSuchElementException;
import java.util.Comparator;

public class BSTTest {
	public static void main(String[] args) {
		TestComparator c = new TestComparator();

		// Default constructor test
		System.out.println("**Testing default constructor**");
		BST<String> B = new BST<String>();
		System.out.println("Should print nothing (empty tree): ");
		B.preOrderPrint();
		BST<String> B2 = new BST<String>();


		// insert test
		B.insert("D", c);
		B.insert("J", c);
		B.insert("G", c);
		B.insert("Z", c);
		B.insert("B", c);
		B.insert("C", c);
		B.insert("A", c);
		B.insert("E", c);
		

		// preOrderPrint test
		System.out.println("\n**Testing insert and preOrderPrint**");
		System.out.println("Should print D B A C J G E Z: ");
		B.preOrderPrint();
		System.out.println("Should print nothing (empty tree): ");
		B2.preOrderPrint();

		// postOrderPrint test
		System.out.println("\n**Testing postOrderPrint**");
		System.out.println("Should print A C B E G Z J D: ");
		B.postOrderPrint();
		System.out.println("Should print nothing (empty tree): ");
		B2.postOrderPrint();

		// inOrderPrint test
		System.out.println("\n**Testing inOrderPrint**");
		System.out.println("Should print A B C D E G J Z: ");
		B.inOrderPrint();
		System.out.println("Should print nothing (empty tree): ");
		B2.inOrderPrint();

		// getHeight test
		System.out.println("\n**Testing getHeight**");
		System.out.println("Should print 3: " + B.getHeight());
		System.out.println("Should print -1: " + B2.getHeight());

		// getSize test
		System.out.println("\n**Testing getSize**");
		System.out.println("Should print 8: " + B.getSize());
		System.out.println("Should print 0: " + B2.getSize());

		// getRoot test
		System.out.println("\n**Testing getRoot**");
		System.out.println("Should print D: " + B.getRoot());
		System.out.print("Should print error message for empty tree: ");
		try { // testing precondition
			B2.getRoot();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		// isEmpty test
		System.out.println("\n**Testing isEmpty**");
		System.out.println("Should print false: " + B.isEmpty());
		System.out.println("Should print true: " + B2.isEmpty());

		// findMin test
		System.out.println("\n**Testing findMin**");
		System.out.println("Should print A: " + B.findMin());
		System.out.print("Should print error message for empty tree: ");
		try { // testing precondition
			B2.findMin();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		// findMax test
		System.out.println("\n**Testing findMax**");
		System.out.println("Should print Z: " + B.findMax());
		System.out.print("Should print error message for empty tree: ");
		try { // testing precondition
			B2.findMax();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

		// Copy Constructor test
		System.out.println("\n**Testing copy constructor**");
		BST<String> B3 = new BST<String>(B, c);
		System.out.println("Should print D B A C J G E Z: ");
		B3.preOrderPrint();
		BST<String> B4 = new BST<String>(B2, c);
		System.out.println("Should print nothing (empty tree): ");
		B4.preOrderPrint();

		// search test
		System.out.println("\n**Testing search**");
		System.out.println("Should print null (value not found): " + B.search("alex", c));
		System.out.println("Should print null (empty tree): " + B2.search("A", c));
		System.out.println("Should print J: " + B.search("J", c));
		System.out.println("Should print E: " + B.search("E", c));
		System.out.println("Should print Z (search with lower case): " + B.search("z", c));

		// remove test
		System.out.println("\n**Testing remove**");
		B3.remove("M", c);
		System.out.println("Should print A B C D E G J Z (nothing removed): ");
		B3.inOrderPrint();
		B3.remove("Z", c);
		System.out.println("Should print A B C D E G J (Z removed, easy case): ");
		B3.inOrderPrint();
		B3.remove("G", c);
		System.out.println("Should print A B C D E J (G removed, medium case): ");
		B3.inOrderPrint();
		B3.remove("B", c);
		System.out.println("Should print A C D E J (B removed, hard case): ");
		B3.inOrderPrint();
		B2.remove("A", c);
		System.out.println("Should print nothing (no change when removing from empty tree): ");
		B2.inOrderPrint();
	}

}

class TestComparator implements Comparator<String> {
	@Override
	public int compare(String a, String b) {
		if (a.equalsIgnoreCase(b))
			return 0;
		else if (a.compareTo(b) > 0)
			return 1;
		else
			return -1;
	}
}

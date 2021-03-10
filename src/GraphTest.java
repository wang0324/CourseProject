import java.util.NoSuchElementException;

public class GraphTest {
    public static void main(String[] args) {
        // Default constructor test
        System.out.println("**Testing default constructor**");
        Graph G = new Graph(9);
        System.out.println("Should print 9 empty lists: \n" + G);

        // addDirectedEdge test
        System.out.println("\n**Testing addDirectedEdge**");
        G.addDirectedEdge(0, 1);
        G.addDirectedEdge(0, 2);
        G.addDirectedEdge(1, 0);
        G.addDirectedEdge(1, 2);
        G.addDirectedEdge(1, 3);
        G.addDirectedEdge(2, 3);
        G.addDirectedEdge(3, 8);
        G.addDirectedEdge(4, 5);
        G.addDirectedEdge(7, 6);
        System.out.println("Should print\n0: 1 2\n" + "1: 0 2 3\n" + "2: 3\n" + "3: 8\n" + "4: 5\n" + "5:\n" + "6:\n"
                + "7: 6\n" + "8:\n\n" + G);

        // getNumEdges test
        System.out.println("\n**Testing getNumEdges**");
        System.out.println("Should print 9: " + G.getNumEdges());
        Graph G2 = new Graph(5);
        System.out.println("Should print 0: " + G2.getNumEdges());

        // getNumVertices test
        System.out.println("\n**Testing getNumVertices**");
        System.out.println("Should print 9: " + G.getNumVertices());
        System.out.println("Should print 5: " + G2.getNumVertices());

        // BFS and printBFS test
        System.out.println("\n**Testing BFS and printBFS**");
        G.BFS(0);
        G.printBFS();
        System.out.print("Should print error message for empty graph: ");
        try { // testing precondition
            G2.BFS(0);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Should print error message for vertex out of graph: ");
        try { // testing precondition
            G.BFS(11);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // isEmpty test
        System.out.println("\n**Testing isEmpty**");
        System.out.println("Should print false: " + G.isEmpty());
        System.out.println("Should print true: " + G2.isEmpty());

        // getDistance test
        System.out.println("\n**Testing getDistance**");
        System.out.println("Should print 3: " + G.getDistance(8));
        System.out.print("Should print error message for vertex out of bounds: ");
        try { // testing precondition
            G.getDistance(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // getParent test
        System.out.println("\n**Testing getParent**");
        System.out.println("Should print 0: " + G.getDistance(2));
        System.out.print("Should print error message for vertex out of bounds: ");
        try { // testing precondition
            G.getParent(9);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // getColor test
        System.out.println("\n**Testing getColor**");
        System.out.println("Should print B: " + G.getColor(2));
        System.out.print("Should print error message for vertex out of bounds: ");
        try { // testing precondition
            G.getColor(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        //addUndirectedEdge test
        System.out.println("\n**Testing addUndirectedEdge**");
        G2.addUndirectedEdge(0,1);
        G2.addUndirectedEdge(0,2);
        G2.addUndirectedEdge(1,4);
        G2.addUndirectedEdge(3,4);
        G2.addUndirectedEdge(3,2);
        System.out.println("Should print\n0: 1 2\n1: 0 4\n" +
                "2: 0 3\n3: 4 2\n4: 1 3\n\n" + G2);
    }
}
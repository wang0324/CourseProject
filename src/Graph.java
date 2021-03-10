/**
 * Graph.java
 * @author Robert Dam
 * CIS 22C, Final Project
 */

import java.util.ArrayList;

public class Graph {
    private int vertices;
    private int edges;
    private ArrayList<List<Integer>> adj;
    private ArrayList<Character> color;
    private ArrayList<Integer> distance;
    private ArrayList<Integer> parent;

    /**Constructors*/

    /**
     * initializes an empty graph, with n vertices
     * and 0 edges
     * @param n the number of vertices in the graph
     */
    public Graph(int n) {
        vertices = n;
        edges = 0;
        adj = new ArrayList<List<Integer>>();
        color = new ArrayList<Character>();
        distance = new ArrayList<Integer>();
        parent = new ArrayList<Integer>();
        for (int i=0; i < vertices; i++) {
            adj.add(new List<Integer>());
        }
    }


    /*** Accessors ***/

    /**
     * Returns the number of edges in the graph
     * @return the number of edges
     */
    public int getNumEdges() {
        return edges;
    }

    /**
     * Returns the number of vertices in the graph
     * @return the number of vertices
     */
    public int getNumVertices() {
        return vertices;
    }

    /**
     * returns whether the graph is empty (no edges)
     * @return whether the graph is empty
     */
    public boolean isEmpty() {
        return edges == 0;
    }

    /**
     * Returns the value of the distance[v]
     * @param v a vertex in the graph
     * @precondition 0 <= v < vertices
     * @return the distance of vertex v
     * @throws IndexOutOfBoundsException when
     * the precondition is violated
     */
    public Integer getDistance(Integer v) throws IndexOutOfBoundsException{
        if (v < 0 || v >= vertices) {
            throw new IndexOutOfBoundsException("getDistance(): " + v + " is out of bounds");
        }
        return distance.get(v);
    }

    /**
     * Returns the value of the parent[v]
     * @param v a vertex in the graph
     * @precondition 0 <= v < vertices
     * @return the parent of vertex v
     * @throws IndexOutOfBoundsException when
     * the precondition is violated
     */
    public Integer getParent(Integer v) throws IndexOutOfBoundsException {
        if (v < 0 || v >= vertices) {
            throw new IndexOutOfBoundsException("getParent(): " + v + " is out of bounds");
        }
        return parent.get(v);
    }

    /**
     * Returns the value of the color[v]
     * @param v a vertex in the graph
     * @precondition 0 <= v < vertices
     * @return the color of vertex v
     * @throws IndexOutOfBoundsException when
     * the precondition is violated
     */
    public Character getColor(Integer v) throws IndexOutOfBoundsException {
        if (v < 0 || v >= vertices) {
            throw new IndexOutOfBoundsException("getColor(): " + v + " is out of bounds");
        }
        return color.get(v);
    }

    /*** Mutators ***/

    /**
     * Inserts vertex v into the adjacency list of vertex u
     * (i.e. inserts v into the list at index u)
     * @precondition, 0 <= u, v < vertices
     * @throws IndexOutOfBounds exception when the precondition
     * is violated
     */
    public void addDirectedEdge(Integer u, Integer v) throws IndexOutOfBoundsException {
        if (v < 0 || v >= vertices || u < 0 || u >= vertices) {
            throw new IndexOutOfBoundsException("addDirectedEdge(): " + v + " is out of bounds");
        }
        adj.get(u).addLast(v);
        edges++;
    }

    /**
     * Inserts vertex v into the adjacency list of vertex u
     * (i.e. inserts v into the list at index u)
     * and inserts u into the adjacent vertex list of v
     * @precondition, 0 <= u, v < vertices
     *
     */
    public void addUndirectedEdge(Integer u, Integer v) {
        if (v < 0 || v >= vertices || u < 0 || u >= vertices) {
            throw new IndexOutOfBoundsException("addUndirectedEdge(): " + v + " is out of bounds");
        }
        adj.get(u).addLast(v);
        adj.get(v).addLast(u);
        edges++;
    }

    /*** Additional Operations ***/

    /**
     * Creates a String representation of the Graph
     * Prints the adjacency list of each vertex in the graph,
     * vertex: <space separated list of adjacent vertices>
     */
    @Override public String toString() {
        String result = "";
        for (int i=0; i < vertices; i++) {
            result += i + ": ";
            result += adj.get(i) + "\n";
        }
        return result;
    }


    /**
     * Prints the current values in the parallel ArrayLists
     * after executing BFS. First prints the heading:
     * v <tab> c <tab> p <tab> d
     * Then, prints out this information for each vertex in the graph
     * Note that this method is intended purely to help you debug your code
     */
    public void printBFS() {
        System.out.println("v\tc\tp\td");
        for (int i=0; i < vertices; i++) {
            System.out.print(i);
            System.out.print("\t" + color.get(i));
            System.out.print("\t" + parent.get(i));
            System.out.println("\t" + distance.get(i));
        }

    }

    /**
     * Performs breath first search on this Graph give a source vertex
     * @param source
     * @precondition graph must not be empty
     * @precondition source is a vertex in the graph
     * @throws IllegalStateException if the graph is empty
     * @throws IndexOutOfBoundsException when the source vertex
     * is not a vertex in the graph
     */

    public void BFS(Integer source) throws IllegalStateException, IndexOutOfBoundsException {
        if (edges == 0) {
            throw new IllegalStateException("BFS(): Cannot perform BFS on an empty graph.");
        }

        if (source < 0 || source > vertices) {
            throw new IndexOutOfBoundsException("BFS(): " + source + " is not in the graph.");
        }

        Queue<Integer> Q = new Queue<Integer>();

        for (int j=0; j < vertices; j++) {
            color.add('W');
            distance.add(-1);
            parent.add(null);
        }

        int current;
        color.set(source, 'G');
        distance.set(source, 0);
        Q.enqueue(source);

        while (!Q.isEmpty()) {
            current = Q.getFront();
            Q.dequeue();
            adj.get(current).placeIterator();
            for (int k=0; k < adj.get(current).getLength(); k++) {
                if (color.get(adj.get(current).getIterator()).equals('W')) {
                    color.set(adj.get(current).getIterator(), 'G');
                    distance.set(adj.get(current).getIterator(), distance.get(current) + 1);
                    parent.set(adj.get(current).getIterator(), current);
                    Q.enqueue(adj.get(current).getIterator());
                }
                adj.get(current).advanceIterator();
            }
            color.set(current, 'B');
        }
    }

} 
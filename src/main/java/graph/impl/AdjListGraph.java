package graph.impl;

import graph.UndirectedGraph;

import java.util.ArrayList;
import java.util.List;

/**
 *  A graph, implemented using an array of sets.
 *  Parallel edges and self-loops allowed.
 */
public class AdjListGraph extends UndirectedGraph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private final List<List<Integer>> adj;

    /**
     * Initializes an empty graph with {@code V} vertices and 0 edges.
     * param V the number of vertices
     *
     * @param V number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public AdjListGraph(int V) {
        super(V);
        if (V < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative");
        }
        this.V = V;
        this.E = 0;
        this.adj = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            this.adj.add(new ArrayList<>());
        }
    }

    /**
     * @return the number of vertices in this graph
     */
    @Override
    public int V() {
        return V;
    }

    /**
     * @return the number of edges in this graph
     */
    @Override
    public int E() {
        return E;
    }

    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param v one vertex in the edge
     * @param w the other vertex in the edge
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    @Override
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        this.adj.get(v).add(w);
        this.adj.get((w)).add(v);
    }

    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    @Override
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return this.adj.get(v);
    }

    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj.get(v)) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }


}

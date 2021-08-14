package graph.impl;

import graph.UndirectedGraph;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  A graph, implemented using an adjacency matrix.
 *  Parallel edges are disallowed; self-loops are allowed.
 */
public class AdjMatrixGraph extends UndirectedGraph  {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private boolean[][] adj;

    /**
     * Empty graph with V vertices
     * @param V number of vertices
     */
    public AdjMatrixGraph(int V) {
        super(V);
        if (V < 0) throw new IllegalArgumentException("Too few vertices");
        this.V = V;
        this.E = 0;
        this.adj = new boolean[V][V];
    }

    /**
     * @return the number of vertices in this graph
     */
    public int V() {
        return V;
    }

    /**
     * @return the number of edges in this graph
     */
    public int E() {
        return E;
    }

    // add undirected edge v-w
    public void addEdge(int v, int w) {
        if (!adj[v][w]) E++;
        adj[v][w] = true;
        adj[w][v] = true;
    }

    // return list of neighbors of v
    public Iterable<Integer> adj(int v) {
        return new AdjIterator(v);
    }

    // string representation of Graph - takes quadratic time
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj(v)) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    // support iteration over graph vertices
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        private int v;
        private int w = 0;

        AdjIterator(int v) {
            this.v = v;
        }

        public Iterator<Integer> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w]) return true;
                w++;
            }
            return false;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }

        public void remove()  {
            throw new UnsupportedOperationException();
        }
    }

}

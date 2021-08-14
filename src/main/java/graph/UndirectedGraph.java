package graph;

/**
 * Represents Undirected Graph
 * Be careful which implementation is used
 */
public abstract class UndirectedGraph {


    /**
     * Create a V-vertex graph with no edges
     * @param V number of vertex
     */
    public UndirectedGraph(int V) {
        // empty constructor because is emphasise on enforcing contract
    }

    /**
     * @return the number of vertices in this graph
     */
    protected abstract int V();

    /**
     * @return the number of edges in this graph
     */
    protected abstract int E();

    /**
     * Add edge to c-w this graph
     * @param c start vertices
     * @param w end vertices
     */
    protected abstract void addEdge(int c, int w);

    /**
     * Returns the vertices adjacent to vertex {@code v}.
     * @param v
     * @return Iterable<Integer> graph
     */
    protected abstract Iterable<Integer> adj(int v);
}

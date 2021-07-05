package tsp.simple;

import java.util.*;

public class WeightedGraph<VERTEX> {
    private Map<VERTEX, LinkedList<Edge>> adjacencyMap = new HashMap();

    public void addEdge(VERTEX source, VERTEX destination, int weight) {
        if (!isValid(source, destination)) {
            return;
        }
       Edge edge = new Edge(source, destination, weight);
       LinkedList<Edge> edges = this.adjacencyMap.get(source);

       if (edges == null) {
           edges = new LinkedList<>();
           edges.add(edge);
           this.adjacencyMap.put(source, edges);
       } else {
           edges.add(edge);
       }

       LinkedList<Edge> edgesDestinationUpdate = this.adjacencyMap.get(destination);
       if (edgesDestinationUpdate != null) {
            Optional<Edge> optionalEdge = edgesDestinationUpdate.stream().filter(edge1 ->  edge1.getSource().equals(edge.getDestination())
                   && edge1.getDestination().equals(edge.getSource())).findFirst();
            if(optionalEdge.isPresent()) {
                Edge edgeValue = optionalEdge.get();
                edgeValue.setWeight(edge.getWeight());
            }
       }
    }

    public void print() {
        this.adjacencyMap.forEach((vertex, edges) -> {
            System.out.println(vertex);
            edges.forEach(el -> System.out.print(el));
            System.out.println();
        });
    }

    public Map<VERTEX, LinkedList<Edge>> getAdjacencyMap() {
        return this.adjacencyMap;
    }

    private boolean isValid(VERTEX source, VERTEX destination) {
        if (source != null && destination != null && !source.equals(destination)) {
            return true;
        }
        return false;
    }

}

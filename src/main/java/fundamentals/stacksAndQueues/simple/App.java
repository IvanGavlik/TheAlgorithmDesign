package fundamentals.stacksAndQueues.simple;

import java.util.Set;

/**

 The Brute Force approach, also known as the Naive Approach, calculates and compares all possible permutations of routes
 or paths to determine the shortest unique solution. To solve the TSP using the Brute-Force approach, you must calculate
 the total number of routes and then draw and list all the possible routes. Calculate the distance of each route and then
 choose the shortest one—this is the optimal solution.

 */
public class App {

    /**
     * Given is graph
     * A
     * A-B 25, A-C 10, A-D 15
     * B
     * B-A 25, B-C 10, B-D 45
     * C
     * C-A 10, C-B 10, C-D 5
     * D
     * D-A 15, D-B 45, D-C 5
     *
     * Calculate TSP (Best route form A to D)
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("test ;) ");
        WeightedGraph<String> stringWeightedGraph = new WeightedGraph<>();
        stringWeightedGraph.addEdge("A", "B", 25);
        stringWeightedGraph.addEdge("A", "C", 10);
        stringWeightedGraph.addEdge("A", "D", 15);
        stringWeightedGraph.addEdge("B", "A", 25);
        stringWeightedGraph.addEdge("B", "C", 10);
        stringWeightedGraph.addEdge("B", "D", 45);
        stringWeightedGraph.addEdge("C", "A", 10);
        stringWeightedGraph.addEdge("C", "B", 10);
        stringWeightedGraph.addEdge("C", "D", 5);
        stringWeightedGraph.addEdge("D", "A", 15);
        stringWeightedGraph.addEdge("D", "B", 45);
        stringWeightedGraph.addEdge("D", "C", 5);

        Set<String> vedges = stringWeightedGraph.getAdjacencyMap().keySet();

        stringWeightedGraph.print();

    }

    private static void calculate(Set<String> vedges, WeightedGraph<String> graph) {
        String first = vedges.stream().findFirst().get();
    }
}

class PathGraph {
    String path;
    int weight;

    public PathGraph(String path, int weight) {
        this.path = path;
        this.weight = weight;
    }
}


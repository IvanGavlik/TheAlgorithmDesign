package graph.simple;

import java.util.Objects;

public class Edge <VERTEX> {
    private VERTEX source;
    private VERTEX destination;
    private int weight;


    public Edge(VERTEX source, VERTEX destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public void setSource(VERTEX source) {
        this.source = source;
    }

    public void setDestination(VERTEX destination) {
        this.destination = destination;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public VERTEX getSource() {
        return source;
    }

    public VERTEX getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "{" + source +
                "-" + destination +
                ":" + weight +
                '}';
    }

}

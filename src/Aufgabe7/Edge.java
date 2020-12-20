package Aufgabe7;

public class Edge {
    private Node toNode = null;
    private Node fromNode = null;
    private int weight = 0; //contains this sum of bags

    public Edge(Node toNode, Node fromNode, int weight){
        this.toNode = toNode;
        this.fromNode = fromNode;
        this.weight = weight;
    }

    public Node getToNode() {
        return toNode;
    }

    public Node getFromNode() {
        return fromNode;
    }

    public int getWeight() {
        return weight;
    }
}

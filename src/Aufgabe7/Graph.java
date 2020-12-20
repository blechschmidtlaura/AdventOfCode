package Aufgabe7;

import java.util.List;

public class Graph {
    private List<Node> nodes;

    public Graph(){

    }

    public Graph(List<Node> nodeList){
        this.nodes = nodeList;
    }

    public void addNode(Node newNode){
        if(!nodes.contains(newNode)){
            nodes.add(newNode);
        }
    }

    public void addEdge(Node toNode, Node fromNode, int weight){
        Edge newEdge = new Edge(toNode, fromNode, weight);
        toNode.addEdge(newEdge);
        fromNode.addEdge(newEdge);
    }
}

package Aufgabe7;

import java.util.LinkedList;
import java.util.List;

public class Node {
    private String color;
    private List<Edge> edgeList;

    public Node(String color){
        this.color = color;
    }

    public Node(String color, List<Edge> edgeList){
        this.color = color;
        this.edgeList = edgeList;
    }

    public String getColor() {
        return color;
    }

    public void addEdge(Edge newEdge){
        edgeList.add(newEdge);
    }

    //allBags - über alle Kanten
    public int numberOfBags(){
        int number = 0;
        for (Edge edges: edgeList) {
            number = number + edges.getWeight();
        }
        return number;
    }

    public List<Node> getParents(){
        List<Node> parents = new LinkedList<>();
        for(Edge edges : edgeList){
            if(edges.getToNode() == this){
                parents.add(edges.getFromNode());
            }
        }
        return parents;
    }

}

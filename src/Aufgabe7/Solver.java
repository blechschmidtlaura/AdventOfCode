package Aufgabe7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solver {

    public static List<String> getInputList(String filename){
        String[] rules = getInputAsStringArray(filename);
        List<String> list = new LinkedList<>();
        for (String rule: rules) {
            list.addAll(getInput(rule));
        }
        return list; //todo
    }

    public static List<String> getInput(String str){
        Graph graph = new Graph();
        String node_color = "";
        String bags = "";
        Pattern p = Pattern.compile("([\\w ]*) bags contain (\\d[\\w, ]*)");
        Matcher matcher = p.matcher(str);
        if(matcher.find()){
            node_color = matcher.group(1);
            graph.addNode(new Node(node_color));
            bags = matcher.group(2);
            //todo: add Edges to graph, a new Pattern to find weight, color (?)
        }
        return new LinkedList<>(Arrays.asList(node_color,bags));
    }

    public static List<String> arrayToList(String[] arr){
        return new LinkedList<>(Arrays.asList(arr));
    }

    public static String[] getInputAsStringArray(String fileName) {
        Path filePath = Path.of(fileName);
        String actual = null;
        try {
            actual = Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arrOfStr = actual.split(".\n");
        return arrOfStr;
    }
}

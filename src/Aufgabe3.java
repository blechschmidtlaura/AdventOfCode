import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aufgabe3 {

    public static long solve2(String file){
        List<String> input = getInputAsList(file);
        List <List<String>> completeList = createInnerLists(input);
        return multiply(slope(completeList));
    }

    public static long multiplyListElements(List<Integer> list){ //just no long ...
        return list.stream().reduce(1, (a, b) -> a * b); //reduce to an int, identity: is used if the stream is empty, (a,b) - first element and next element in stream,
        //goes through the stream (the list) and takes out first and follow element, until the last element (where the next element ist the identity, a*b - what happens with the element
    }

    public static long multiply(List<Integer> list){
        int i = list.size();
        int elem = list.get(list.size()-1);
        if(i > 1){
            list.remove(list.size()-1);
            return elem * multiply(list);
        } else {
            return list.get(0);
        }
    }

    public static List<Integer> slope(List<List<String>> list){
        int numberOfTrees = 0;
        List<Integer> treeList = new ArrayList<>();
        List<List<Integer>> myList = createSlopeList();
        for(int i = 0; i < myList.size(); i++) {
            int x = myList.get(i).get(0);
            int y = myList.get(i).get(1);
            numberOfTrees = goThroughListVariable(list, x, y);
            treeList.add(numberOfTrees);
        }
        return treeList;
    }

    public static int goThroughListVariable(List<List<String>> list, int horizontal, int vertikal) {
        int length_inner = list.get(0).size();
        int counter = 0;
        int position_x = horizontal;
        int position_y = 0;
        int k = 0;
        for (int j = position_y; j < list.size(); j = position_y){
            for (int i = position_x; i < length_inner; i = i + horizontal) {
                position_x = i;
                position_y = k + vertikal;
                String object = list.get(position_y).get(position_x);
                if (isTree(object)) {
                    counter++;
                }
                if(position_y + vertikal < list.size()) {
                    k= k+vertikal;
                } else{
                    return counter;
                }
            }
            position_x = (horizontal-1)-((length_inner-1)-position_x);
        }
        return counter;
    }

    private static List<List<Integer>> createSlopeList(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(1);

        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        list3.add(1);

        List<Integer> list4 = new ArrayList<>();
        list4.add(7);
        list4.add(1);

        List<Integer> list5 = new ArrayList<>();
        list5.add(1);
        list5.add(2);

        List<List<Integer>> fullList = new ArrayList<>();
        fullList.add(list1);
        fullList.add(list2);
        fullList.add(list3);
        fullList.add(list4);
        fullList.add(list5);
        return fullList;
    }

    public static int solve(String file){
        List<String> input = getInputAsList(file);
        List <List<String>> completeList = createInnerLists(input);
        return goThroughList(completeList);
    }

    public static int goThroughList(List<List<String>> list) {
        int length_inner = list.get(0).size();
        int counter = 0;
        int position_x = 3;
        int position_y = 0;
        int k = 0;
        for (int j = position_y; j < list.size(); j = position_y){
            for (int i = position_x; i < length_inner; i = i + 3) {
                position_x = i;
                position_y = k + 1;
                String object = list.get(position_y).get(position_x);
                if (isTree(object)) {
                    counter++;
                }
                if(position_y + 1 < list.size()) {
                    k++;
                } else{
                    return counter;
                }
            }
            position_x = 2-((length_inner-1)-position_x);
        }
        return counter;
    }

    public static boolean isTree(String string){
        return string.equals("#");
    }

    public static List<List<String>> createInnerLists(List<String> list){
        List<List<String>> newList = new ArrayList<>();
        List<String> inner = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            String[] innerArr = list.get(i).split("((?<=.)|(?=.))");
            newList.add(Arrays.asList(innerArr));
        }
        return newList;
    }

    /*public static List<String> fillList(List<String> list){

    }*/

    public static List<String> getInputAsList(String filename){
        Path fileName = Path.of(filename);
        String actual = null;
        try {
            actual = Files.readString(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arrOfStr = actual.split("\n");
        List<String> listString = new ArrayList<>();
        for(int i = 0; i < arrOfStr.length; i++){
            String mStr = arrOfStr[i];
            listString.add(mStr);
        }
        return listString;
    }

}

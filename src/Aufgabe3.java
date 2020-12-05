import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aufgabe3 {

    public static int goThroughList(List<List<String>> list) {
        int length_inner = list.get(0).size();
        System.out.println(length_inner);

        int counter = 0;
        int position_x = 3;
        int position_y = 0;
        int k = 0;
        for (int j = position_y; j < list.size()-3; j = position_y){ //warum -3 --> sonst indexOutOfBounce (letztes ist ein Baum)
            for (int i = position_x; i < length_inner; i = i + 3) {
                position_x = i;
                position_y = k + 1;
                System.out.println(position_x);
                System.out.println(position_y);
                String object = list.get(position_y).get(position_x);
                System.out.println(object);
                if (isTree(object)) {
                    counter++;
                }
                if(position_y <= list.size()) {
                    k++;
                } else{
                    return counter;
                }
            }
            position_x = 2;
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

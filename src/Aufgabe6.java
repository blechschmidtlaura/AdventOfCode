import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Aufgabe6 {
    public static int count2(String filename){
        int counter = 0;
        List<List<String>> answers = getGroupsOfAnswers(filename);
        for(int i = 0; i < answers.size(); i++){
            List<List<String>> innerList = listWithInner(answers.get(i));
            counter = counter + getIntersections(innerList).size();
        }
        return counter;
    }

    public static List<List<String>> listWithInner(List<String > list){
        List<List<String>> newList = new LinkedList<>();
        for(int i = 0; i < list.size(); i++){
            newList.add(convertStringToCharList(list.get(i)));
        }
        return newList;
    }

    public static List<String> convertStringToCharList(String str) {
        // Create an empty List of character
        List<String> chars = new ArrayList<>();

        // For each character in the String
        // add it to the List
        for (char ch : str.toCharArray()) {

            chars.add(String.valueOf(ch));
        }

        // return the List
        return chars;
    }

    public static List<String> getIntersections(List<List<String>> answerList){
        List<String> newList;
        if(answerList.size() <= 1){
            return answerList.get(0);
        } else{

            List<String> first = answerList.get(0);
            List<String> second = answerList.get(1);
            newList = getIntersection(first,second);
            answerList = removeElemFromList(answerList,0);
            answerList = removeElemFromList(answerList,0); //because elem2 is the first after removing elem1
            answerList.add(0,newList);
            return getIntersections(answerList);
        }
    }

    public static List<String> getIntersection(List<String> firstList, List<String> secondList){
        List<String> newList = new LinkedList<>();
        for (int i = 0; i < firstList.size(); i++) {
            if(stringInList(secondList,firstList.get(i))){
                newList.add(firstList.get(i));
            }
        }
        return newList;
    }

    public static List<List<String>> removeElemFromList(List<List<String>> list, int index){
        List<List<String>> newList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if(i != index){
                newList.add(list.get(i));
            }
        }
        return newList;
    }


    public static int count(String filename){
        int counter = 0;
        List<String> answers = getAnswers(filename);
        for(int i = 0; i < answers.size(); i++){
            counter = counter + listOfGroupanswers(answers.get(i)).size();
        }
        return counter;
    }

    public static List<String> listOfGroupanswers(String string){ //Part1
        List<String> groupAnswers = new LinkedList<>();
        for(int i = 0; i < string.length(); i++){
            String letter = String.valueOf(string.charAt(i));
            if(!stringInList(groupAnswers, letter)){
                groupAnswers.add(letter);
            }
        }
        groupAnswers.remove("\n"); //because it is in list, if there are different persons who answered
        return groupAnswers;
    }

    public static boolean stringInList(List<String> list, String elem){
        for(int i = 0; i < list.size(); i++){
            if (elem.equals(list.get(i))){
                return true;
            }
        }
        return false;
    }

    public static List<List<String>> getGroupsOfAnswers(String filename){ //Part2
        List<List<String>> newList = new LinkedList<>();
        List<String> answers = getAnswers(filename);
        for (int i = 0; i < answers.size(); i++) {
            String group = answers.get(i);

            String[] arr = group.split("\n");
            List<String> groupList = Arrays.asList(arr);
            newList.add(groupList);
        }
        return newList;
    }

    public static List<String> getAnswers(String filename){
        String[] arr = Input.getInputAsStringArray2(filename);
        List<String> answers = new LinkedList<>();
        answers.addAll(Arrays.asList(arr));
        return answers;
    }
}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Aufgabe6 {
    /*
    1. function, zwei Listen übergeben, Rückgabe: Liste mit Schnittmenge (was ist in beiden Listen enthalten)
    -- newList deklarieren

    --For-schleife (int i = 0; i < firstList.size(); i++)
    -- Element der firstList (i), in der secondList (stringInList(secondList, firstList.get(i)))
    --if(stringInList){ (die, die in beiden enthalten sind)
    newList.add(firstList.get(i))
    --etc.
    --return newList

    2. Länge der Liste --> Anzahl
    3. okay
    getIntersection(List<List<String>> list
    ..neue Liste deklarien
    -- solange Rekursiv bis list.size() = 1 (dann return mit erstem Element von list)
    --zwei Listen vergleichen (ersten zwei Elemente der list)
    --elemente remove (list.remove(list.get(0), list.get(1))
    -- neue Liste adden (vorne) (list.add(0, newList)))
    -- aufrufen getIntersection mit list

       --remove
       --neue Liste
       -- for-schleife
       --if !i = index
       --dann: füge hinzu
     */
    /*public static int count2(String filename){
        int counter = 0;
        List<String> answers = getAnswers(filename);
        for(int i = 0; i < answers.size(); i++){
            counter = counter + getIntersections(answers.get(i)).size();
        }
        return counter;
    }*/

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
            System.out.println(answerList.size());
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

    public static List<String> listOfGroupanswers(String string){
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

    public static List<List<String>> getGroupsOfAnswers(String filename){
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
        for(int i = 0; i < arr.length; i++){
            String mStr = arr[i];
            answers.add(mStr);
        }
        return answers;
    }
}

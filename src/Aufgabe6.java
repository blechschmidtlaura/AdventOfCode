import java.util.LinkedList;
import java.util.List;

public class Aufgabe6 {
    // päckchen in Listen fassen
    //doppelte Buchstaben entfernen
    //Länge ausgeben
    //alle addieren
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

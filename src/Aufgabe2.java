import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aufgabe2 {
    //count buchstaben

    //reguläre ausdrücke
    //informationen auslesen

    /*public static boolean isValid(List<String> str){
        String part1 = str.get(0);
        String part2 = str.get(1);
        String part3 = str.get(2);
        String passwort = str.get(3);
        Pattern p = Pattern.compile(""+part3+".{"+part1+","+part2+"}");
        Matcher matcher = p.matcher(passwort);
        return matcher.find();
    }*/
    public static int solve(String filename){
        List<String> file = getInput(filename);
        return CountsOfValids(file);
    }

    public static int CountsOfValids(List<String> passwordList){
        int counter = 0;
        for(int i = 0; i < passwordList.size(); i++){
            List<String> partList = getParts(passwordList.get(i));
            if(isValid(partList)){
                counter++;
            }
        }
        return counter;
    }

    public static boolean isValid(List<String> str){
        String firstNumber = str.get(0);
        String secondNumber = str.get(1);
        String searchLetter = str.get(2);
        String passwort = str.get(3);

        List<Character> chrList = StringToList(passwort);
        int counter = countChars(chrList, searchLetter.charAt(0));
        return compareMinMaxNumber(Integer.valueOf(firstNumber), Integer.valueOf(secondNumber), counter);

    }

    public static boolean compareMinMaxNumber(int minNumber, int maxNumber, int counter){
        return (counter >= minNumber && counter <= maxNumber);
    }

    public static int countChars(List<Character> chrList, char letter){
        int counter = 0;
        for(int i = 0; i < chrList.size(); i ++){
            if(chrList.get(i) == letter){
                counter++;
            }
        }
        return counter;
    }

    public static List<Character> StringToList(String word){
        char[] arr = word.toCharArray();
        List<Character> characterList = new LinkedList<>();
        for(int i = 0; i < arr.length; i++){
            characterList.add(arr[i]);
        }
        return characterList;
    }

    public static List<String> getParts(String str){
        String minInt = "";
        String maxInt= "";
        String searchLetter= "";
        String inputString = "";

        Pattern p = Pattern.compile("([0-9]+)\\-([0-9]+)\\ ([a-z]{1})\\: ([a-z]+)");
        Matcher matcher = p.matcher(str);
        if(matcher.find()){
            minInt = matcher.group(1);
            maxInt = matcher.group(2);
            searchLetter = matcher.group(3);
            inputString = matcher.group(4);
        }else{
            System.out.println("ACHTUNG!!! KEIN REGEX GEFUNDEN !!!");
        }

        return Arrays.asList(minInt, maxInt, searchLetter, inputString);
    }

    public static List<String> getInput(String nameOfFile){
        Path fileName = Path.of(nameOfFile);
        String actual = null;
        try {
            actual = Files.readString(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arrOfStr = actual.split("\n");
        List<String> listString = new LinkedList<>();

        for(int i = 0; i < arrOfStr.length; i++){
            String mStr = arrOfStr[i];
            listString.add(mStr);
        }
        return listString;
    }
}

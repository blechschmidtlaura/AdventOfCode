import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aufgabe2 {
    //count buchstaben

    //reguläre ausdrücke
    //informationen auslesen
    /*public boolean isValid(List<String> stringList){
        Pattern p = Pattern.compile("a.{2,4}");
        Matcher matcher = p.matcher(str);
    }*/

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

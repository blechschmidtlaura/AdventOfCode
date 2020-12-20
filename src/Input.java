import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Input {
    public static String readFile(String filename) throws IOException {
        Path filePath = Path.of(filename);
        String actual = null;
        actual = Files.readString(filePath);
        return actual;
    }

    public static String[] getInputAsStringArray(String fileName) {
        String actual = null;
        try {
            actual = readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arrOfStr = actual.split("\n");
        return arrOfStr;
    }

    public static String[] getInputAsStringArray2(String fileName) {
        Path filename = Path.of(fileName);
        String actual = null;
        try {
            actual = Files.readString(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arr = actual.split("\n\n");
        return arr;
    }

    public static String[] getInputAsStringArray3(String fileName) { //damit test funktioniert
        Path filename = Path.of(fileName);
        String actual = null;
        try {
            actual = Files.readString(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arr = actual.split("\n\r");
        return arr;
    }

    public static List<String> getInputAsList(String[] input){
        List<String> listString = new ArrayList<>();
        for(int i = 0; i < input.length; i++){
            String mStr = input[i];
            listString.add(mStr);
        }
        return listString;
    }

}


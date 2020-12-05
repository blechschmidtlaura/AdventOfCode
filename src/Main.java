import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println(Aufgabe1.solve("Input\\input1.txt"));
        System.out.println(Aufgabe1.solve2("Input\\input2.txt"));

        String str = "aaa";
        Pattern p = Pattern.compile("a.{2,4}");
        Matcher matcher = p.matcher(str); //- string der verglichen wird
        System.out.println(matcher.find());

        List<String> passwordList = Aufgabe2.getInput("Input\\Aufg2_input1.txt");
        System.out.println(Aufgabe2.getInput("Input\\Aufg2_input1.txt"));
        List<String> myList = Aufgabe2.getParts("17-19 p: pwpzpfbrcpppjppbmppp");
        System.out.println(myList);
        System.out.println(Aufgabe2.isValid(myList));
        System.out.println(Aufgabe2.StringToList("hey"));
        System.out.println(Aufgabe2.CountsOfValids(passwordList));
        System.out.println(Aufgabe2.solve("Input\\Aufg2_input1.txt"));
    }
}

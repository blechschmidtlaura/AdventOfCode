import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Aufgabe 1");
        System.out.println(Aufgabe1.solve("Input\\input1.txt"));
        System.out.println(Aufgabe1.solve2("Input\\input2.txt"));

        /*String str = "aaa";
        Pattern p = Pattern.compile("a.{2,4}");
        Matcher matcher = p.matcher(str); //- string der verglichen wird
        System.out.println(matcher.find());*/

        System.out.println("Aufgabe 2 - Part 1");
        List<String> passwordList = Aufgabe2.getInput("Input\\Aufg2_input1.txt");
        System.out.println(Aufgabe2.getInput("Input\\Aufg2_input1.txt"));
        List<String> myList = Aufgabe2.getParts("17-19 p: pwpzpfbrcpppjppbmppp");
        System.out.println(myList);
        System.out.println(Aufgabe2.isValid(myList));
        System.out.println(Aufgabe2.StringToList("hey"));
        System.out.println(Aufgabe2.CountsOfValids(passwordList));
        System.out.println(Aufgabe2.solve("Input\\Aufg2_input1.txt"));

        System.out.println("Aufgabe 2 - Part 2");
        System.out.println(Aufgabe2.checkLetter(Aufgabe2.StringToList("abcde"),1,3,"a"));
        System.out.println(Aufgabe2.isValid2(Aufgabe2.getParts("1-3 a: abcde")));
        System.out.println(Aufgabe2.CountsOfValids2(passwordList));
        System.out.println(Aufgabe2.solve2("Input\\Aufg2_input1.txt"));

        System.out.println("\n "+ "Aufgabe 3 - Part 1");
        System.out.println(Aufgabe3.getInputAsList("Input\\Aufg3_input1.txt"));
        System.out.println(Aufgabe3.createInnerLists(Aufgabe3.getInputAsList("Input\\Aufg3_input1.txt")));
        System.out.println(Aufgabe3.isTree("#"));
        System.out.println(Aufgabe3.goThroughList(Aufgabe3.createInnerLists(Aufgabe3.getInputAsList("Input\\Aufg3_input1.txt"))));
    }
}

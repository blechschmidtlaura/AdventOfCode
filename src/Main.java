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
        System.out.println(Aufgabe2.solve("Input\\Aufg2_input1.txt"));

        System.out.println("Aufgabe 2 - Part 2");
        System.out.println(Aufgabe2.solve2("Input\\Aufg2_input1.txt"));

        System.out.println("Aufgabe 3 - Part 1");
        System.out.println(Aufgabe3.solve("Input\\Aufg3_input1.txt"));

        System.out.println("Aufgabe 3 - Part 2");
        //System.out.println(Aufgabe3.multiplyListElements(list));
        System.out.println(Aufgabe3.solve2("Input\\Aufg3_input1.txt"));
    }
}

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
        System.out.println(Aufgabe3.goThroughListVariable(Aufgabe3.createInnerLists(Aufgabe3.getInputAsList("Input\\Aufg3_input1.txt")), 3,1));
        System.out.println(Aufgabe3.slope(Aufgabe3.createInnerLists(Aufgabe3.getInputAsList("Input\\Aufg3_input1.txt"))));
        List<Integer> list = new LinkedList<>();
        list.add(84);
        list.add(198);
        list.add(72);
        list.add(81);
        list.add(53);

        System.out.println(Aufgabe3.multiplyListElements(list));
        System.out.println(Aufgabe3.solve2("Input\\Aufg3_input1.txt"));
        //richtiges Ergebnis: 5140884672
        System.out.println(Aufgabe3.multiply(list));
    }
}

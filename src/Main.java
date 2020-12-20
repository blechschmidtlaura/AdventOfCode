import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        /*System.out.println("Aufgabe 1");
        System.out.println(Aufgabe1.solve("Input\\input1.txt"));
        System.out.println(Aufgabe1.solve2("Input\\input2.txt"));

        String str = "aaa";
        Pattern p = Pattern.compile("a.{2,4}");
        Matcher matcher = p.matcher(str); //- string der verglichen wird
        System.out.println(matcher.find());

        System.out.println("Aufgabe 2 - Part 1");
        System.out.println(Aufgabe2.solve("Input\\Aufg2_input1.txt"));

        System.out.println("Aufgabe 2 - Part 2");
        System.out.println(Aufgabe2.solve2("Input\\Aufg2_input1.txt"));

        System.out.println("Aufgabe 3 - Part 1");
        System.out.println(Aufgabe3.solve("Input\\Aufg3_input1.txt"));

        System.out.println("Aufgabe 3 - Part 2");
        //System.out.println(Aufgabe3.multiplyListElements(list));
        System.out.println(Aufgabe3.solve2("Input\\Aufg3_input1.txt"));

        System.out.println("Aufgabe 4 - Part 1");
        //String expr = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\n" +
         //       "hcl:#623a2f";
        //System.out.println(Aufgabe4.generatePassportList(expr));
        //System.out.println(Aufgabe4.isValid(Aufgabe4.generatePassportList(expr)));
        System.out.println(Aufgabe4.countValids(Aufgabe4.getInput("Input\\Aufg4_input1.txt")));

        System.out.println("Aufgabe 4 - Part 2");
        //System.out.println(Aufgabe4.getInput("Input\\Aufg4_input1.txt"));
        //System.out.println("Auswertung");
        //System.out.println(Aufgabe4.checkKeyValueList(Aufgabe4.keyValueList(expr)));

        //System.out.println(Aufgabe4.solve2("Input\\Aufg4_input1.txt"));

        System.out.println("Aufgabe 5 - Part 1");
        System.out.println(Aufgabe5.solve("Input\\Aufg5_input.txt"));
        System.out.println("Aufgabe 5 - Part 2");
        System.out.println(Aufgabe5.findMySeat("Input\\Aufg5_input.txt"));*/

        //System.out.println("Aufgabe 6 - Part 1");
        //System.out.println(Aufgabe6.getAnswers("Input\\Aufg6_input.txt"));
        //System.out.println(Aufgabe6.count("Input\\Aufg6_input.txt")); //does not work with test...

        System.out.println("Aufgabe 6 - Part 2");
        System.out.println(Aufgabe6.count2("Input\\Aufg6_input.txt"));

        /*System.out.println(Thinking.isPythagoras(17,12,20));
        int[] date = new int[]{15,12,19};
        Thinking.printPythagorasTriples(Thinking.calculateNextPythagorasDate(date));*/
        //System.out.println(Input.getInputAsList2(Input.getInputAsStringArray3("Input\\Aufg6_test.txt")));
    }
}

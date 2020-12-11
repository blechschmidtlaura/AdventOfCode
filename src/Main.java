import java.lang.reflect.Array;
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
        String bsp = "BFFFBBFRRR";
        char[] arr = {'B','F','F','F','B','B','F'};
        char[] arr2 = {'R', 'R', 'R'};
        //System.out.println(Aufgabe5.lastStringOfArray(arr));
        System.out.println(Aufgabe5.getValueInMiddle(63,0));
        System.out.println(Aufgabe5.getID(arr,arr2));
        String[] input = Input.getInputAsStringArray("Input\\Aufg5_input.txt");
        String[][] myArray = Aufgabe5.getBoardingPasses(input);
        for(int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i][0]);
            System.out.println(myArray[i][1]);
        }
        //System.out.println(Aufgabe5.solve("Input\\Aufg5_input.txt"));
        System.out.println(Aufgabe5.boardingNumberList("Input\\Aufg5_input.txt"));

        System.out.println(Aufgabe5.findMySeat("Input\\Aufg5_input.txt"));
    }
}

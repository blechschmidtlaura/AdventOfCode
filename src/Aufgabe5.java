import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aufgabe5 {

    public static int findMySeat(String filename){
        int distance = 0;
        List<Integer> seatList = boardingNumberList(filename);
        Collections.sort(seatList);
        for(int i = 1; i+1 < seatList.size()-1; i++){
            distance = seatList.get(i+1) - seatList.get(i);
            if(distance >= 2){
                return seatList.get(i) +1;
            }
        }
        return 0;
    }

    public static List<Integer> boardingNumberList(String filename){
        String[] stringArray = Input.getInputAsStringArray(filename);
        String [] [] boardingArray = getBoardingPasses(stringArray);
        List<Integer> boardingNumbers = new LinkedList<>();
        for(int i = 0; i < boardingArray.length; i++){
            boardingNumbers.add(getID(boardingArray[i][0].toCharArray(),boardingArray[i][1].toCharArray()));
        }
        return boardingNumbers;
    }

    public static int solve(String filename){
        String[] stringArray = Input.getInputAsStringArray(filename);
        String [] [] boardingArray = getBoardingPasses(stringArray);
        List<Integer> boardingNumbers = new LinkedList<>();
        for(int i = 0; i < boardingArray.length; i++){
            boardingNumbers.add(getID(boardingArray[i][0].toCharArray(),boardingArray[i][1].toCharArray()));
        }
        return biggestInList(boardingNumbers);
    }

    public static int biggestInList(List<Integer> list){
        int biggestElement = -1;
        for(Integer i : list){
            if(i > biggestElement){
                biggestElement = i;
            }
        }
        return biggestElement;
    }

    public static int getID(char[] boardingPass1, char[] boardingPass2){
        int row = giveSeatNumber(0,127,boardingPass1);
        int column = giveSeatNumber(0,7,boardingPass2);
        int ID = multiplyToID(row,column);
        return ID;
    }

    public static int multiplyToID(int row, int column){
        return row * 8 + column;
    }

    public static int giveSeatNumber(int lower, int upper, char[] boardingPass){
        int lowerBorder = lower;
        int upperBorder = upper;
        for(int i = 0; boardingPass.length > i; i++){
            if(boardingPass[i] == 'F' || boardingPass[i] == 'L'){
                upperBorder = getValueInMiddle(lowerBorder,upperBorder);
            } else if(boardingPass[i] == 'B' || boardingPass[i] == 'R'){
                lowerBorder = getValueInMiddle(lowerBorder,upperBorder) +1 ; //because method just round down
            }
        }
        if(lastCharOfArray(boardingPass) == 'F' || lastCharOfArray(boardingPass) == 'L'){
            return lowerBorder;
        } else{
            return upperBorder;
        }
    }

    public static int getValueInMiddle(int a, int b){ //rundet immer ab
        int range;
        if(a < b){
            range = b - a;
            return a + Math.floorDiv(range,2);
        } else{
            range = a - b;
            return b + Math.floorDiv(range,2);
        }
    }

    public static char lastCharOfArray(char[] arr){
        return arr[arr.length-1];
    }

    public static String[][] getBoardingPasses(String[] stringArray){
        Pattern pattern = Pattern.compile("([BF]{7})([RL]{3})");
        String[][] boardingPasses = new String[stringArray.length][2];
        for(int i = 0; i < stringArray.length; i++){
            Matcher matcher = pattern.matcher(stringArray[i]);
            if(matcher.find()){
                boardingPasses[i][0] = matcher.group(1);
                boardingPasses[i][1] = matcher.group(2);
            }
        }
        return boardingPasses;
    }
}

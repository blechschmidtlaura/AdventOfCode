import java.util.LinkedList;
import java.util.List;

public class Thinking {

    public static void printPythagorasTriples(int[][] nextDates){
        for(int i = 0; i < nextDates.length; i++){
            List<Integer> date = new LinkedList<>();
            for(int k = 0; k < nextDates[i].length; k++){
                date.add(nextDates[i][k]);
            }
            System.out.println(date);
        }
    }

    //it shows the next pythagoras Date in this millenium (actual date (16.12.20) to last day in millenium (31.12.99))
    public static int[][] calculateNextPythagorasDate(int[] actualDate){
        int[][] nextDate = new int[5][3];
        int innerList = 0;
        if(actualDate.length == 3){
            //int day = actualDate[0];
            //int month = actualDate[1];
            int year = actualDate[2];
            for(int i = year+1; i < 99; i++) {
                //System.out.println(i);
                for(int k = 1; k <= 12; k++){
                    //System.out.println(k);
                    for(int j = 1; j <= 31; j++){
                        //System.out.println(j);
                        if(isPythagoras(j,k,i)){
                            nextDate[innerList][0] = j;
                            nextDate[innerList][1] = k;
                            nextDate[innerList][2] = i;
                            innerList++;
                        }
                    }
                }
            }
        }
        return nextDate;
    }

    public static boolean isPythagoras(int first, int second, int third){
        return (Math.pow(first,2) + Math.pow(second,2) == Math.pow(third, 2));
    }


}

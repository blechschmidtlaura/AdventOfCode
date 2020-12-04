import java.util.LinkedList;
import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

    public class Aufgabe1 {
        public static int add(int a, int b) {
            return a + b;
        }

        public static int add(int a, int b, int c){
            return a + b + c;
        }

        public static boolean sumIs(int a, int b, int sum){
            return add(a,b) == sum;
        }

        public static boolean sumIs(int a, int b, int c, int sum){
            return add(a,b,c) == sum;
        }

        public static int multiply(int a, int b){
            return a * b;
        }

        public static int multiply(int a, int b, int c){
            return a * b * c;
        }

        public static boolean isSum2020(int a, int b){
            return sumIs(a,b,2020);
        }

        public static boolean isSum2020(int a, int b, int c){
            return sumIs(a,b,c,2020);
        }

        public static boolean hasSum (List<Integer> list){
            int element1;
            int element2;

            for(int i = 0; i < list.size()-1; i++) {
                for(int k = i+1; k < list.size(); k++){
                    element1 = list.get(i);
                    element2 = list.get(k);
                    if(isSum2020(element1, element2)){
                        return true;
                    }
                }
            }
            return false;
        }

        public static int multiplyElements(List<Integer> list){
            int element1;
            int element2;

            for(int i = 0; i < list.size()-1; i++) {
                for(int k = i+1; k < list.size(); k++){
                    element1 = list.get(i);
                    element2 = list.get(k);
                    if(isSum2020(element1, element2)){
                        return multiply(element1, element2);
                    }
                }
            }
            return -1;
        }

        public static int multiplyElements2(List<Integer> list){
            int element1;
            int element2;
            int element3;

            for(int i = 0; i < list.size()-1; i++) {
                element1 = list.get(i);
                for(int k = i+1; k < list.size(); k++){
                    element2 = list.get(k);
                    if(add(element1,element2) >= 2020) {
                        continue;
                    }
                    for(int j = k+1; j < list.size(); j++) {
                        element3 = list.get(j);
                        if (isSum2020(element1, element2, element3)) {
                            return multiply(element1, element2, element3);
                        }
                    }
                }
            }
            return -1;
        }
        /*
        List length 4
        [
        [0, 1, 2]
        [0, 1, 3]
        0, 2, 3
        1, 2, 3
        ]
         */

        public static List<Integer> getInput(String nameOfFile){
            Path fileName = Path.of(nameOfFile);
            String actual = null;
            try {
                actual = Files.readString(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] arrOfStr = actual.split("\n");
            List<Integer> listInteger = new LinkedList<>();

            for(int i = 0; i < arrOfStr.length; i++){
                String mStr = arrOfStr[i];
                listInteger.add(Integer.valueOf(mStr));
            }
            return listInteger;
        }

        public static int solve(String filename){
            return multiplyElements(getInput(filename));
        }

        public static int solve2(String filename){
            return multiplyElements2(getInput(filename));
        }
    }

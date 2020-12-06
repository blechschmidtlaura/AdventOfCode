import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aufgabe4 {

    public static int countValids(List<String> passports){
        int counter = 0;
        for(int i = 0; i < passports.size(); i++){
            if(isValid(generatePassportList(passports.get(i)))){
                counter++;
            }
        }
        return counter;
    }

    public static boolean isValid(List<String> passportList){ //one inner List
        return passportList.size() == 7;
    }

    public static List<String> generatePassportList(String passport1){
        List<String> allKeyList = new LinkedList<>();
        List<String> keys = getKeys();
        for(int i = 0; keys.size() > i; i++){
            allKeyList.addAll(keyToList(keys.get(i),passport1));
        }
        return allKeyList;
    }

    public static List<String> getKeys(){
        List<String> keys = new LinkedList<>();
        keys.add("ecl");
        keys.add("eyr");
        keys.add("hcl");
        keys.add("byr");
        keys.add("iyr");
        keys.add("pid");
        keys.add("hgt");
        return keys;
    }

    public static List<String> keyToList(String word, String expression){
        List<String> passportValues = new LinkedList<>();
        String key;
        String value;
        Pattern p = Pattern.compile("(["+word+"]{3}):([\\w#]*)");
        Matcher matcher = p.matcher(expression);
        if(matcher.find()) {
            key = matcher.group(1);
            value = matcher.group(2);
            //passportValues.add(key);
            passportValues.add(key);
        }
        return passportValues;
    }

    //Part 2
    public static int solve2(String file){
        int counter = 0;
        List<String> input = getInput(file);
        for(int i = 0; i < input.size(); i++) {
            System.out.println(input.get(i));
            List<String> innerList = generatePassportList(input.get(i)); //because is invalid, if one key is missing (and you have to check because you compare with lists of all keys
            if(isValid(innerList)) {
                if (checkKeyValueList(keyValueList(input.get(i)))) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static boolean checkKeyValueList(List<List<String>> passport1){
        int correct_counter = 0;
        String actual_value;
        for(int i = 0; i < passport1.size(); i++){
            actual_value = passport1.get(i).get(1);
            if(passport1.get(i).get(0).equals("ecl")){
                if(isEclCorrect(actual_value)){
                    correct_counter++;
                }
            }
            if(passport1.get(i).get(0).equals("eyr")){
                if(isEyrCorrect(actual_value)){
                    correct_counter++;
                }
            }
            if(passport1.get(i).get(0).equals("hcl")){
                if(isHclCorrect(actual_value)){
                    correct_counter++;
                }
            }
            if(passport1.get(i).get(0).equals("iyr")){
                if(isIyrCorrect(actual_value)){
                    correct_counter++;
                }
            }
            if(passport1.get(i).get(0).equals("pid")){ //wrong
                if(isPidCorrect(actual_value)){
                    correct_counter++;
                }
            }
            if(passport1.get(i).get(0).equals("hgt")){ //wrong
                if(isHgtCorrect(actual_value)){
                    correct_counter++;
                }
            }
            if(passport1.get(i).get(0).equals("byr")){
                if(isByrCorrect(actual_value)){
                    correct_counter++;
                }
            }
        }
        return correct_counter == 7;
    }

    public static List<List<String>> keyValueList(String passport1){
        List<List<String>> allKeyList = new LinkedList<>();
        List<String> keys = getKeys();
        for(int i = 0; keys.size() > i; i++){
            allKeyList.add(getKeyValuePair(keys.get(i),passport1));
        }
        return allKeyList;
    }

    public static boolean isEclCorrect(String value){
        List<String> values = new LinkedList<>();
        values.add("amb");
        values.add("blu");
        values.add("brn");
        values.add("gry");
        values.add("hzl");
        values.add("grn");
        values.add("oth");
        return values.contains(value);
    }

    public static boolean isEyrCorrect(String value){
        return Integer.parseInt(value) >= 2020 && Integer.parseInt(value) <= 2030;
    }

    public static boolean isByrCorrect(String value){
        return Integer.parseInt(value) >= 1920 && Integer.parseInt(value) <= 2002;
    }

    public static boolean isIyrCorrect(String value){
        return Integer.parseInt(value) >= 2010 && Integer.parseInt(value) <= 2020;
    }

    public static boolean isHgtCorrect(String value){
        String REGEX = "([0-9]{3})cm|([0-9]{2})in";
        Pattern p = Pattern.compile(REGEX);
        Matcher matcher = p.matcher(value);
        if(matcher.find()){
            if(matcher.group(1) != null && Integer.parseInt(matcher.group(1)) >= 150 && Integer.parseInt(matcher.group(1)) <= 193){
                return true;
            } else if(matcher.group(2) != null && Integer.parseInt(matcher.group(2)) >= 59 && Integer.parseInt(matcher.group(2)) <= 76){
                return true;
            }
        }
        return false;
    }

    public static boolean isHclCorrect(String value){
        String REGEX = "(\\#([0-9]|[a-f]){6})";
        Pattern p = Pattern.compile(REGEX);
        Matcher matcher = p.matcher(value);
        if(value.length()==7) { //so that #123acdf does not work
            return matcher.find();
        } else{
            return false;
        }
    }

    public static boolean isPidCorrect(String value){
        String REGEX = "[0-9]{9}";
        Pattern p = Pattern.compile(REGEX);
        Matcher matcher = p.matcher(value);
        if(value.length()==9) { // so that 123456789876 does not work
            return matcher.find();
        } else{
            return false;
        }
    }

    public static List<String> getKeyValuePair(String word, String passport){
        List<String> pair = new LinkedList<>();
        String key;
        String value;
        Pattern p = Pattern.compile("(["+word+"]{3}):([\\w#]*)");
        Matcher matcher = p.matcher(passport);
        if(matcher.find()) {
            key = matcher.group(1);
            value = matcher.group(2);
            pair.add(key);
            pair.add(value);
        }
        return pair;
    }

    //Input
    public static List<String> getInput(String filename){
        Path fileName = Path.of(filename);
        String input= null;
        try {
            input = Files.readString(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] passports= input.split("\n\n");
        List<String> passports1 = new LinkedList<>();
        for(int i = 0; i < passports.length; i++){
            String mStr = passports[i];
            passports1.add(mStr);
        }
        return passports1;
    }
}

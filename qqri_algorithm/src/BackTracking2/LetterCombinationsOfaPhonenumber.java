package BackTracking2;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfaPhonenumber {

    public static void main(String[] args) {

        String digitletter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
//
//        for(String str : solve1(digitletter[2],digitletter[3]) ) {
//            System.out.println(str);
//        }

        for(String str : solve("234" )) {
            System.out.println(str);
        }
    }
    //1
    public static List<String> solve(String digits) {
        List<String> result = new ArrayList<>();
        String digitletter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        if(digits.length() == 0) return result;

        result.add("");
        for(int i = 0 ; i < digits.length() ; i++ ) {
            result = combine(result , digitletter[digits.charAt(i) - '0']);
        }

        return result;
    }

    static List<String> combine(List<String> firstList, String digit) {
        List<String> result = new ArrayList<>();

        for(int i = 0 ; i < digit.length() ; i++ ) {
            for(String firstStr : firstList) {
                result.add(firstStr + digit.charAt(i)); // str + char 형식은 str 이다.
            }
        }

        return result;
    }

    //2
    public static List<String> solve1(String a, String b) {
        List<String> res = new ArrayList<>();
        for(char c1 : a.toCharArray() ) {
            for(char c2 : b.toCharArray()) {
                String f1 =  String.valueOf(c1);
                String f2 =  String.valueOf(c2);
                String newStr = f1.concat(f2);
                res.add(newStr);
            }
        }

        return res;
    }

}

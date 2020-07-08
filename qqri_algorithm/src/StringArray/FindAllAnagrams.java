package StringArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllAnagrams {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String s = "cbaebabacd";
        String p = "abc";


        for(int i : solve(s,p)){
            System.out.print(i + " ");
        }
    }
    public static List<Integer> solve(String txt ,String pat){
        // 1 , null 체크도 해줘야됨.
        List<Integer> result = new ArrayList<>();
        if(txt.length() ==0 || txt == null || pat.length() ==0 || pat == null || txt.length() < pat.length() ) return result;

        //2 해당하는 아스키값에 1 둔다.
        int[] patArr = new int[256];
        for(int i = 0 ; i < pat.length() ; i++) {
            patArr[pat.charAt(i)]++;
        }

        for(int i = 0 ; i < txt.length() - pat.length() + 1 ; i++ ) {
            int[] txtArr = new int[256];

            for(int j = 0 ; j < pat.length() ; j++) {
                txtArr[ txt.charAt(i+j) ] ++;
            }

            if(check( patArr, txtArr)) {
                result.add(i);
            }
        }
        return result;
    }
    private static boolean check(int[] patArr, int[] txtArr) {
        for(int i = 0 ; i < patArr.length; i++) {
            if(patArr[i] != txtArr[i]) return false;
        }
        return true;
    }


    public static List<Integer> solve1(String s,String p){
        // 1
        List<Integer> result = new ArrayList<>();

        Set<Character> set = new HashSet<>();
        for(char c : p.toCharArray()) {
            set.add(c);
        }
        int cnt = 0;
        Set<Character> current = new HashSet<>();
        // 2
        for(int i = 0 ; i < s.length()-p.length()+1 ; i++) {

            for(int j = i ; j < i + p.length(); j++) {
                if( !set.contains( s.charAt(j) )) break;
                else current.add( s.charAt(j) );
            }
            if( current.size() == 3){
                result.add(i);
            }
            current.clear();
        }

        return result;
    }

}

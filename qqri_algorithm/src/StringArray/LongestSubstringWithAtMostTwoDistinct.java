package StringArray;

import java.io.IOException;
import java.util.*;

public class LongestSubstringWithAtMostTwoDistinct {

    public static void main(String[] args) throws NumberFormatException, IOException {
        String input = "cacbabb";
        System.out.println(solve(input));
        System.out.println(solve1(input));
    }
    // 1. 문자 종류 확인하기 위한 값 필요 , 2. 문자의 길이 재기 위한 값 필요.
    public static int solve(String s){
        //1
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end =0, cnt =0 , len = 0;

        //2
        while(end < s.length()) {

            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c,0)+1);
            if(map.get(c) == 1) cnt ++; //cnt는 문자의 종류를 위한 것
            end ++;

            //3
            while(cnt > 2 ){
                char startChar = s.charAt(start);
                map.put(startChar , map.get(startChar)-1 ); //앞에 있는거 뺀다.
                if( map.get(startChar) == 0 ) { //0개 될때까지 다 뺀다.
                    cnt--;
                }
                start++;
            }
            len = Math.max(len, end - start);
        }

        return len;
    }
    /*
    * 담기 위해 우선 다음에 다른 종류가 오면 먼저 있던 걸 뺀?
    * */

    public static int solve1(String str) {
        List<String> list = new LinkedList<>();
        Set<Character> set = new HashSet<>();

        for(int i = 0 ; i < str.length()-2 ; i++ ) { //시작 인덱스
            for(int j = str.length() ; j > i ;  j--) { //마지막 끝까지 가야 되기 때문임!
                list.add(str.substring(i,j));
            }
        }
        int max = 0;
        for(int k=0 ; k < list.size() ; k++ ) {
            String currnet = list.get(k);
            for(char ch : currnet.toCharArray()){
                set.add(ch);
            }
            if(set.size() <= 2) {
                if(currnet.length() > max)  max = currnet.length();
            }
            set.clear();
        }

        return max;
    }
}

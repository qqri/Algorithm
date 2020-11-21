import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        char c = 'a'+1;
        System.out.println(solution("100011110"));
    }

    static String solution(String str){
        String ans = "";
        int cnt = 0;
        if(str.charAt(0) == '1') ans+="1";
        for(int i = 1 ; i < str.length() ; i++ ) {
            if(str.charAt(i-1) != str.charAt(i)) {
                ans += (char) ('A' + cnt) ;
                cnt=0;
            } else {
                cnt++;
            }
        }
        ans += (char) ('A' + cnt) ;
        return ans;
    }
}
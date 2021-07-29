import java.io.*;
import java.util.*;
//하이픈 다 없애기
// hm으로 만들어서 겹치는 경우엔 마지막에 1 더해서 쓰기
// addr lower 로 쓰여 있어야 한다.
//'John Doe; Peter Benjamin Parker;
// Mary Jane Watson-Parker; John Elvis Doe;
// John Evan Doe; Jane Doe; Peter Brian Parker', 'Example'
public class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
        String C = "Example";
        String ans = solution(S,C);
        System.out.println(ans);
    }

    public static String solution(String S, String C) {
        // write your code in Java SE 8
        String[] arr = S.split("; ");
        int len = arr.length;
        HashMap<String , Integer> hm = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        String cur = "";
        String com = C.toLowerCase();
        String fn = "";
        String ln = "";

        for(int i = 0 ; i < len ; i++ ) {
            cur = arr[i];
            String[] name = cur.split(" ");
            fn = name[0]+".";

            if(name.length == 3) {
                ln = name[2].replace("-","");
            } else {
                ln = name[1].replace("-","");
            }
            if(ln.length()>8) ln = ln.substring(0,8);
            cur= fn+ln;

            cur = cur.toLowerCase();
            hm.put( cur , hm.getOrDefault(cur , 0)+1 );
            if(hm.get(cur) > 1) {
                cur = cur + hm.get(cur);
            }

            cur = cur+"@"+com + ".com";

            arr[i] = cur;
        }

        for(int i = 0 ; i < len-1 ; i++ ) {
            sb.append(arr[i] + "; ");
        }
        sb.append(arr[len-1]);
//        for(int i = 0; i < arr.length ; i++ ) {
//            System.out.println(arr[i]);
//        }
//        System.out.println(C);
        return sb.toString();
    }
}
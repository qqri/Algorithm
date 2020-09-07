package Test;
import java.util.*;

public class Prob5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1
        int k = sc.nextInt(); //단어사전 수
        int n = sc.nextInt(); //게임 횟수


        String[] words = new String[k];
        int[] wordCnt = new int[k];
        String[] ans = new String[n];
        int idx=0;

        for(int i = 0 ; i < k ; i++ ) {
            words[i] = sc.next();
        }

        //2
        for(int i = 0 ; i < n ; i++ ) {
            String cur = sc.next();
            for(int j = 0 ; j < k; j++ ) {
                if( cur.charAt(0) == words[j].charAt(0) ) {
                    if( ans[i] == null ) {
                        ans[i] = words[j];
                        idx = j;
                    }else {
                        if( wordCnt[idx] > wordCnt[j] ) {
                            ans[i] = words[j];
                            idx = j;
                        }

                        else if(wordCnt[idx] == wordCnt[j]) {
                            idx = stringSort(words , idx , j);
                            ans[i] = words[idx];
                        }
                    }
                }
            }

            wordCnt[idx] ++;
        }

        for(String str: ans) {
            System.out.println(str);
        }
    }
    public static int stringSort(String[] words , int str1Idx, int str2Idx) {
        // 각 단어들 알파벳 순으로 센다.

        String str1 = words[str1Idx];
        String str2 = words[str2Idx];

        //1
        int cnt = Math.min(str1.length() , str2.length());

        for(int i = 1 ; i < cnt ; i++ ) {
            if(str1.charAt(i) == str2.charAt(i)) continue;
            if ( str1.charAt(i) > str2.charAt(i) ) {
                return str2Idx;
            }
            if( str1.charAt(i) < str2.charAt(i) ) {
                return str1Idx;
            }
        }
        return str1Idx;
    }

}

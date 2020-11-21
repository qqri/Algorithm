import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] s = { 0, 6,3,1,1,2 };
        int[] e = { 3,7,10,5,9,8 };
        int sLen = s.length;
        System.out.println(solution(s,sLen,e,sLen));

    }

    static int solution(int[] s , int sLen, int[] e ,int eLen){
        int ans = 0 , n = sLen;
        int tmp,e1=-1,e2 = -1;

        for(int i = 0; i < n ; i++) {
            for(int j = 0 ; j < n-1 ; j++ ) {
                if(e[j] >= e[j+1] && s[j] > s[j+1]) {
                    tmp = s[j];
                    s[j] = s[j+1];
                    s[j+1] = tmp;

                    tmp = e[j];
                    e[j] = e[j+1];
                    e[j+1] = tmp;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(e1 <= s[i]) {
                e1 = e[i];
                ans++;
            } else if(e2 <= s[i]) {
                e2 = e1;
                e1 = e[i];
                ans++;
            }
        }

        return ans;
    }
}
import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(solution(3298));
    }

    public static int solution(int n) {
        // 그 전 수가 나랑 같으면 안됨.

        String curN = "";
        char ch;
        boolean flag = true;

        while( flag ) {

            flag = false;
            n++;
            curN = String.valueOf(n);

            ch = curN.charAt(0);
            for(int i = 1 ; i < curN.length() ; i++ ) {
                if( ch == curN.charAt(i) ) {
                    flag = true;
                    break;
                }
                ch = curN.charAt(i);
            }

        }

        return n;
    }

}
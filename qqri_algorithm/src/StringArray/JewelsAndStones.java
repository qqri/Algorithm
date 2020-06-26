package StringArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) throws NumberFormatException, IOException {
        /*
        * char 형 간의 비교,
        * String <-> char 변환
        * */

        String J = "Aa";
        String S =  "aAAbbbb";
        int output = 0 ;



        for(int i = 0 ; i < J.length() ; i++) {
           // String current = String.valueOf( J.charAt(i) );
            char index =  J.charAt(i);

            for(int j = 0 ; j < S.length(); j++ ){
                if(index == S.charAt(j)) {
                    output++;
                }
            }
        }

        System.out.println(output);

    }

    //풀이 2
    // 중복되지 않고 저장한다는 점에서 해시셋 사용

    public static int solve(String jew, String stone) {
        Set<Character> set = new HashSet<>();
        for (char jewel : jew.toCharArray()) {
            set.add(jewel); // a, A
        }

        int count = 0;
        for (char stoneChar : stone.toCharArray()) {
            System.out.println("stoneChar: " + stoneChar);
            if (set.contains(stoneChar)) {
                count++;
            }
        }
        return count;
    }


}

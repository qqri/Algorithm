package BackTracking2;

import java.util.ArrayList;
import java.util.List;

public class GeneratedParentheses {

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        dfs(result, "", 3,3, "");
    }

    public static int cnt=0;
    public static List<String> dfs(List<String> result, String str, int left, int right, String str2) {

        // 1
        if( left < 0 || left > right ) return result;

        cnt ++ ;
        System.out.println(str + " count : " + cnt + " left : " + left + " right : " + right+ " str2 :" + str2) ;
        //2
        if( left == 0 && right == 0 ) {
            result.add(str);

            return result;
        }

        dfs(result, str + "(" , left-1 , right, str2 + "+" );
        dfs(result, str + ")" , left , right-1, str2 + "-" );
        return result;
    }

}

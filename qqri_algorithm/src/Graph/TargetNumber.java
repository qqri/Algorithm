package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;
import java.lang.Math;

public class TargetNumber {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] numbers = {1,2,3};
        int target = 6;

        System.out.println( solution( numbers, target ) );
    }
    public static int solution(int[] numbers, int target) {

        //1
        ArrayList<Integer> result = new ArrayList<>();
        //2
        dfs(numbers, numbers.length-1 , target + numbers[0] , result);
        dfs(numbers, numbers.length-1 , target - numbers[0] , result);
        return result.size();
    }

    public static void dfs(int[] numbers, int cnt , int sum, ArrayList<Integer> result) {

        if(cnt == 1) { // target  다 빼기 되면 0 될거니까 그때 리턴
            if( (sum + numbers[0] == 0) || (sum - numbers[0] == 0 ) ) {
                result.add(0);
            }
            return;
        }

        cnt--;
        dfs(numbers , cnt , sum + numbers[cnt] , result );
        dfs(numbers, cnt, sum - numbers[cnt] , result);

    }
}








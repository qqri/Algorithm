package Test18;
import java.util.*;

public class Q8 {
    static int[][] chess = {
            {25 ,24, 23, 22, 21},
            {10, 11 ,12 ,13, 20},
            {9, 8 ,7 , 15, 19},
            {2, 3, 6, 15 , 18},
            {1, 4 ,5 , 16, 17}
    };

    public static void main(String[] args) {
        List<int[]> numsArr = new ArrayList<>();
        Scanner sc  = new Scanner(System.in);

        solve(8 , numsArr );
        solve( 20 , numsArr);
        solve( 25 , numsArr);

        for(int[] ans : numsArr) {
            System.out.println(ans[0] + " , " + ans[1]);
        }

    }
    static void solve(int target, List<int[]> arr) {
        int[] ans = new int[2];
        int col = chess.length;
        int row = chess[0].length;

        for(int i = 0 ; i < col ; i++ ) {
            for(int j = 0 ; j < row ; j++ ) {
                if(chess[i][j] == target) {
                    ans[0] = j+1;
                    ans[1] = col - i;
                    arr.add(ans);
                    return;
                }
            }
        }
        return;
    }

}

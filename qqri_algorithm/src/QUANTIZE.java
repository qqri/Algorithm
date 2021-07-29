import java.util.*;

import static java.util.Arrays.sort;

public class QUANTIZE {

    private int[] quanArr;
    private int n, s;
    private int[][] cache = new int[100][11];
    private static final int INF = 987654321;

    public int minError(int start, int end){
        int sum = 0;
        int sqSum = 0;

        for(int i=start; i<end; i++){
            sum += quanArr[i];
            sqSum += quanArr[i] * quanArr[i];
        }
        int avg = (int)(0.5 + (double)sum / (end - start));

        return sqSum + avg * avg * (end - start) - 2 * avg * sum;
    }

    public int quantize(int start, int parts){
        //base case
        if(start == n) return 0;

        if(parts == 0) return INF;

        //memoization
        if(cache[start][parts] != -1) return cache[start][parts];

        int ret = INF;

        for(int partSize = 1; start + partSize <= n; partSize++){
            ret = Math.min(ret, minError(start, start + partSize) + quantize(start + partSize, parts - 1));
        }
        cache[start][parts] = ret;
        return ret;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        QUANTIZE qt = new QUANTIZE();

        int loop = scan.nextInt();

        while(loop-- > 0){
            qt.n = scan.nextInt();
            qt.s = scan.nextInt();
            qt.quanArr = new int[qt.n];
            for (int i = 0; i < qt.n; i++) {
                qt.quanArr[i] = scan.nextInt();
            }

            //cache init
            for(int[] arr : qt.cache){
                Arrays.fill(arr, -1);
            }

            sort(qt.quanArr);

            System.out.println(qt.quantize(0, qt.s));
        }
    }
}
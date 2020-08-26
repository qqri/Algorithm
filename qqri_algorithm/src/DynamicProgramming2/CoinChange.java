package DynamicProgramming2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println( solve1(coins, 11) );
        System.out.println( dp(coins , 11) );
    }

    public static int dp(int[] coins, int amount) {
        int max = amount+1;
        int dp[] = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for(int i = 1 ; i <= amount ; i++) {
            for( int j = 0 ; j < coins.length ; j++ ) {
                if( i >= coins[j]) {
                    dp[i] = Math.min( dp[i] , dp[i - coins[j]] + 1 ); // 1 더하는 건 그 동전 한개 더 추가한다는 의미.
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static int solve1(int[] coins, int amount) {
        //1
        if(coins.length==0) return 0;
        int cnt = 0;
        int sum;
        Arrays.sort(coins) ; //오름차순 정렬

        for(int i = coins.length-1 ; i >= 0 ; i-- ) {
            sum=0;
            for( int j = 0 ;amount > sum ; j++) {
                sum = coins[i] * j;
                if( amount < sum && j > 0) {
                    j--;
                    amount -= coins[i] * j ;
                    cnt += j;
                    System.out.println("j : " + j + " cnt : " + cnt);
                    break;
                }
                if( amount == sum) {
                    cnt += j;
                    break;
                }
            }
        }

        return cnt;
    }

}

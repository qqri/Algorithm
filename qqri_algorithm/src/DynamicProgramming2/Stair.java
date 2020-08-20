package DynamicProgramming2;

public class Stair {

    public static void main(String[] args) {
        int n = 4;

        int[] dp = new int[100];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n ; i++ ) {
            dp[i] = dp[i-1] + dp[i-2];
        }


        System.out.println(dp[n]);
    }

    //2 함수로 따로 분리함

    public static int solve( int n ) {
        int[] dp = new int[n+1];

        if (n == 0) return 0 ;
        if (n == 1) return 1 ;
        if (n == 2) return 2 ;

        for(int i = 2 ; i <= n ; i++ ) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

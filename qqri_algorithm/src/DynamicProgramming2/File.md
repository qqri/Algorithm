# 문제
[파일합치기](https://www.acmicpc.net/problem/11066)
<br>출처 : 백준

sum[i] 의 정의는 1~i 까지의 map의 합<br>
점화식 dp[j][i] = j~i 장의 최소<br>
계속 실행 해야 하는 점화식을 생각한하면 다음과 같다.<br>
dp[j][i] = dp[j][s] + dp[s][i] + sum[i~j]


# 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int map[];
    public static int dp[][];
    public static int sum[];
    public static final int MAX = 987654321;

    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();


        while (tc-- > 0) {
            int n = sc.nextInt();
            map = new int[n + 1];
            sum = new int[n + 1];
            dp = new int[ n+2 ][ n+2 ];
            sum[0] = 0;

            for (int i = 1; i <= n; i++) {
                map[i] = sc.nextInt();
                sum[i] = sum[i - 1] + map[i];
            }
            System.out.println(solve(n , sum));
        }

    }
    public static int solve( int n , int sum[]){
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j > 0; j--) { // j < i 순서 주의
                dp[j][i] = MAX;
                for (int s = j; s <= i; s++) {
                    dp[j][i] = Math.min(dp[j][i], (dp[j][s] + dp[s + 1][i]));
                    //s = i = n 일때 dp[n+1][n]에 접근하게 되므로 dp[n+2][n+2]로 정의
                }
                dp[j][i] += sum[i] - sum[j - 1]; //map[j] ~ map[i] 까지의 합
            }
        }

        return dp[1][n];
    }

}

```
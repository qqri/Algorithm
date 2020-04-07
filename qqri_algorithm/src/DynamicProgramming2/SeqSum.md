# 문제
[연속합](https://www.acmicpc.net/problem/1912)
<br>출처 : 백준


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
    public static int dp[];
    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n];
        dp = new int[n];

        for(int i = 0 ; i < n ; i++) {
            map[i] = sc.nextInt();
        }

        dp[0] = map[0];
        for(int i = 1 ; i < n ; i++) {
            dp[i] = Math.max( dp[i-1] + map[i] , map[i] );
        }

        Arrays.sort(dp);

        System.out.println(dp[n-1]);

    }


}


```
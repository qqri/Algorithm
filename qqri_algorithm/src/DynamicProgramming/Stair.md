# 문제
[계단 오르기 문제](https://www.acmicpc.net/problem/2579)
<br>출처 : 백준

우선 점화식 세우고 생각

# 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int n;

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);

        //계단수
        n = sc.nextInt();
        int[] dp = new int[n];
        int[] map = new int[n];

        for(int i = 0 ; i < n ; i++ ) {
            map[i] = sc.nextInt();
        }
        dp[0] = map[0] ; //1번째 계단
        dp[1] = Math.max(map[0] + map[1] , map[1]) ; //2번째 계단
        dp[2] = Math.max(map[0]+map[2] , map[1]+map[2]) ; //3번째 계단

        for(int i =3 ; i < n ; ++i ) {
            dp[i] = Math.max( ( dp[i-2] + map[i] ) , ( dp[i-3] + map[i-1] + map[i] ) );
        }

        System.out.println(dp[n-1]);
    }
}


```
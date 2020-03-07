# 문제
[파도반 문제](https://www.acmicpc.net/problem/9461)
<br>출처 : 백준<br>
int 형이 아니라 long 형으로 해야 한다<br>
안그러면 오버플로우 남.


# 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int n;
    static long dp[];
    public static void main(String[] args) throws NumberFormatException, IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int n;

        while (tc-- > 0) {
            n = sc.nextInt();
            dp = new long[n+1];
            for(int i = 1 ; i < n+1 ; i++ ){
                dp[i] = -1;
            }
            System.out.println(Padovan(n));
        }
    }

    public static long Padovan(int n){
        if(n == 1) return 1;
        if(n == 2) return 1;
        if(n == 3) return 1;
        if(n == 4) return 2;
        if(n == 5) return 2;

        if(dp[n] != -1) return dp[n];

        return dp[n] = Padovan(n-1) + Padovan(n-5) ;
    }

}
```
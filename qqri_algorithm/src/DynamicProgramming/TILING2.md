# 문제
[타일개수채우기 문제](https://www.algospot.com/judge/problem/read/TILING2)
<br>출처 : 알고스팟

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
    public static final long MOD = 1000000007;
    public static long tille[] = new long[101]; //자릿수 갯수 & 1~10 사이인거

    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        tille[0] = tille[1] = 1;

        for(int i = 2 ; i < 101 ; i++) {
            tille[i] = ( tille[i-1] + tille[i-2] ) % MOD;
        }

        while ( tc-- > 0 ){
            int n = sc.nextInt();
            System.out.println(tille[n]);
        }

    }

}

```
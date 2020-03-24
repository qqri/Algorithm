# 문제
[쉬운계단수 문제](https://www.acmicpc.net/problem/10844)
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
    public static final long DIV = 1000000000;
    public static long[][] cache = new long[101][10]; //자릿수 갯수 & 1~10 사이인거

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // cache[i][j] 에서 i = 자릿수 , j = 첫번째 숫자 의미
        // count 자체만 중요하므로 cache[i][j] 에는 몇개만 들어있는지 생각한다.
        cache[0][1]=1;
        for(int i = 1 ; i < 10 ; i++ ) cache[1][i] = 1;

        if(n >= 2) {
            for (int i = 2; i <= n; i++) {
                cache[i][1] = (cache[i - 2][1] + cache[i - 1][2]) % DIV;

                for (int j = 2; j < 9; j++) {
                    cache[i][j] = ( cache[i - 1][j - 1] + cache[i - 1][j + 1] ) % DIV;
                }

                cache[i][9] = cache[i - 1][8] % DIV;
            }
        }

        long sum = 0;
        for(int i = 0 ; i < 10 ; i++ ) {
            sum += cache[n][i] ;
        }

        System.out.println(sum % DIV);

    }

}

```
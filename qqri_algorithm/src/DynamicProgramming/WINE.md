# 문제
[포도주 시식 문제](https://www.acmicpc.net/problem/2156)
<br>출처 : 백준
<br>
입력 가장 큰 것만 고려하지 말고 가장 작은 것도 고려하기!<br>
처음에 계단수가 1,2 인 경우를 고려하지 않아서 틀림

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

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cache[] = cache = new int[n+1];
        int map[] = map = new int[n+1]; // 문제 포도주 양 담을 map

        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }


        map[0] = cache[0] = 0;

        if( n >= 1 ) cache[1] = map[1] ;
        if( n >= 2 ) cache[2] = map[1]+map[2] ;

        if( n >= 3 ) {
            cache[3] = Math.max(cache[2], Math.max(map[1] + map[3], map[2] + map[3]));
        }

        if(n >= 4) {
            for (int i = 4; i <= n; i++) {
                cache[i] = Math.max(cache[i - 1], Math.max(cache[i - 2] + map[i], cache[i - 3] + map[i - 1] + map[i]));
                //cache[i] = Math.max(cache[i - 2] + map[i], cache[i - 3] + map[i - 1] + map[i] ); 이렇게 하면 틀림
                //이전 값이 더 크면 더 증가 안시킨다
                //1,2 단계를 반드시 밟아야 하는 게 아니라 3이상 뛰어서 밟아도 된다! !
            }
        }

        System.out.println( cache[n]);
    }

}
```
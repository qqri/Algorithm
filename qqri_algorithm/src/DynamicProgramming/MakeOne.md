# 문제
[1로만들기 문제](https://www.acmicpc.net/problem/1463)
<br>출처 : 백준
<br>
Bottom Up 이랑 Up Bottom 두가지로 풀수있다.

# 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int cache[];
    public static int cnt = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cache = new int[n+1];
        for(int i=0; i < n+1 ;i++){
            cache[i] = -1;
        }
        cache[0] = cache[1] = 0;

        System.out.println(solve(n));
    }

    //Up Bottom
    public static int solve(int n) {
        //기저사례 : n 이 1 인 경우
        if(n == 1) return 0;

        //메모이제이션
        if(cache[n] > 0) return cache[n];

        //n-1
        cache[n] = solve(n-1) + 1;

        //n%2
        if(n %2 == 0) {
            int tmp = solve(n/2) +1;
            if(cache[n] > tmp)
                cache[n] = tmp;
        }

        //n%3
        if(n %3 == 0) {
            int tmp = solve(n/3) +1;
            if(cache[n] > tmp)
                cache[n] = tmp;
        }

        return cache[n];
    }

    //Bottom Up
    public static int solve2(int n) {
        cache[0] = cache[1] = 0;
        for(int i = 2 ; i <= n ; i++ ) {
            cache[n] = solve2(n-1) + 1;
            if(i%2 == 0)
                cache[n] = Math.min(cache[n] , cache[n/2] + 1);
            if(i%3 == 0)
                cache[n] = Math.min(cache[n] , cache[n/3] + 1);
        }

        return cache[n];
    }
}

```
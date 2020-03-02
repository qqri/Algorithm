# 문제
[전깃즐 문제](https://www.acmicpc.net/problem/2565)
<br>출처 : 백준

map2 의 2차원 배열 정렬을 따로 할 필요 없이
처음에 값 받을때
```java
map2[sc.nextInt] = map2[sc.nextInt]
```
로 했으면 2차원 배열 하는 시간을 더 줄일수 있었을것 같다.
(물론 그러려면 map2는 int[501] 로 만들고)

# 코드
```java
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.math.*;
/*
*  LIS 3
*  n*2 행렬로
*  map[n][1] 에 따라서 새로운 board를 만들고 dp 만든다.
* */
public class Main {
    static int[] map2;

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][2];

        for(int i=0;i<n;i++){
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
        }
        map2 = new int[n];

        //2차원 배열 map[0] 정렬
        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                final Integer time1 = o1[0];
                final Integer time2 = o2[0];
                return time1.compareTo(time2);
            }

        });
        for(int j=0;j < n ; j++){
            map2[j] = map[j][1];
        }

        System.out.println( n-LIS(map2) );

    }

    public static int LIS(int[] map2){
        int[] dp = new int[map2.length];

        for(int i = 0 ; i < map2.length ; i++) {
            dp[i] = 1;
            for(int j = 0 ; j <= i ; j++ ) {
                if( map2[j] < map2[i] && dp[i] < dp[j] +1 ){
                    dp[i] ++;
                }
            }

        }

        Arrays.sort(dp);

        return dp[map2.length-1];
    }

}

```
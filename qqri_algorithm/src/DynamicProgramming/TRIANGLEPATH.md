# 문제
[TRIANGLEPATH 문제](https://algospot.com/judge/problem/read/TRIANGLEPATH)
<br>출처 : 알고스팟

C로 풀때 메모이제이션 저장 방법을 참조로 했는데
나는직접함 <br>
그리고 경로에 따라서 sum 값이 달라지기 때문에
dp[][](캐시) 를 굳이 3차배열로 만들 필요가 없다.

# 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static final int MAX = 100;
    static int[][] dp = new int[MAX][MAX];
    static int[][] map = new int[MAX][MAX];
    static int n,h;

    public static void main(String[] args) throws NumberFormatException, IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();


        while (n-->0) {
            h = sc.nextInt();
            //캐시 초기화
            for(int i=0 ; i < MAX ;i++) {
                for (int j = 0; j < MAX; j++) {
                    dp[i][j] = -1;
                }
            }
            for(int i=0 ; i < h ; i++) {
                for(int j = 0 ; j <= i ; j ++ ) {
                    map[i][j] = sc.nextInt();
                }
            }

            System.out.println(path(0,0));
        }

    }

    public static int path( int y , int x ) {
        //기저사례
        if(y == h-1 ) return map[y][x];

        int ret = dp[y][x];
        if( ret != -1 ) return ret;

        //메모이제이션
        ret = Math.max(path(y+1, x) , path(y+1, x+1)) + map[y][x];

        return dp[y][x] =ret;
    }

}

```
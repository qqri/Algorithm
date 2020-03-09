# 문제
[JLIS 문제](https://www.algospot.com/judge/problem/read/JLIS)
<br>출처 : 알고스팟

# 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int arrN[];
    public static int arrM[];
    public static int cache[][];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arrN = new int[N];
            arrM = new int[M];
            cache = new int[N + 1][M + 1];

            //cache dp 초기화
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= M; j++) {
                    cache[i][j] = -1;
                }
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arrN[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arrM[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println( JLIS(-1,-1)-2 );
        }

    }

    public static int JLIS ( int indexN , int indexM) {
        // 두개는 무조건 존재
        int ret = 2 ;
        // 메모이션
        if( cache[indexN + 1][indexM +1] != -1 ) return cache[indexN + 1][indexM +1];

        //a,b 가 -1 이면 아주 작은 수 저장 아니면 가장 작은 수 저장
        long a = ( indexN == -1 ? Long.MIN_VALUE : arrN[indexN] );
        long b = ( indexM == -1 ? Long.MIN_VALUE : arrM[indexM] );
        long maxElement = Math.max( a , b );

        //다음 원소 찾는다.
        for( int nextN = indexN + 1 ; nextN < N ; nextN ++ ) {
            if( maxElement < arrN[nextN] ) {
                ret = Math.max( ret , JLIS( nextN , indexM ) + 1 );
            }
        }
        for( int nextM = indexM + 1 ; nextM < M ; nextM ++ ) {
            if( maxElement < arrM[ nextM ] ) {
                ret = Math.max( ret , JLIS( indexN , nextM ) + 1 );
            }
        }

        cache[indexN + 1 ][indexM + 1] = ret;
        return ret;
    }




}



```
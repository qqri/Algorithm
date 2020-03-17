# 문제
[양자화 문제](https://www.algospot.com/judge/problem/read/QUANTIZE)
<br>출처 : 알고스팟
<br>
minError 에서 나오는 부분은 통계에서의 분산과 관련되어 있다.
<br>S = 시그마라고 할때, 문제에서 말하는 오차는
<br> a~b까지 S(A[i] - m)^2 = ( b-a+1 )*m^2 - 2* S(A[i])*m + S(A[i]^2)
<br> 인것 이용해서 답을 내야 한다.

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
    public static final int INF = 987654321;
    public static int A[];
    public static int[][] cache = new int[100][11];
    public static int n,s;

    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while( tc-- > 0) {
            n = sc.nextInt();
            s = sc.nextInt();
            A = new int[n];

            for(int i = 0 ; i < n ; i++ ) {
                A[i] = sc.nextInt();
            }

            //cache 초기화!
            for(int[] arr : cache) {
                Arrays.fill(arr, -1);
            }

            Arrays.sort(A);

            System.out.println( quantize( 0 , s ));
        }

    }

    public static int quantize( int start , int parts ){

        // 기저사례 모든 수가 양자화 되었을 때
        if( start == n ) return 0;

        // 기저사례 숫자는 남았는데 더 묶을 수 없을때
        if( parts == 0 ) return INF;

        //메모이제이션
        if( cache[start][parts] != -1 ) return cache[start][parts];

        int ret = INF;

        for( int partSize = 1 ; start + partSize <= n ; partSize ++ ) {
            ret = Math.min( ret , minError(start, start + partSize ) + quantize(start + partSize, parts-1) );
        }

        cache[start][parts] = ret;
        return ret;

    }

    public static int minError( int start , int end ) {
        int sum = 0;
        int sqSum = 0;

        for( int i = start ; i < end ; i ++ ){
            sum += A[i];
            sqSum += A[i] * A[i] ;
        }
        int avg = (int)( 0.5 +  (double)sum/( end - start) );

        return sqSum + avg * avg * (end - start) - 2 * avg * sum ;
    }

}

```
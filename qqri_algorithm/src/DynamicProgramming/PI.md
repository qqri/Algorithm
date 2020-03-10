# 문제
[PI 문제](https://www.algospot.com/judge/problem/read/PI)
<br>출처 : 알고스팟

# 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static int cache[];
    public static final int INF = 987654321; //매우매우 큰 수
    public static String N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while( tc -- > 0) {
            N = br.readLine();

            cache = new int[N.length()];
            //캐쉬 초기화
            for(int i = 0 ; i < N.length() ; i++ ){
                cache[i] = -1;
            }

            System.out.println(memorize( N,0));
        }
    }

    public static int classify(String N, int a, int b) {
        String M = N.substring(a , b);

        //1. 모두 같은 숫자인지 확인
        String single ="";

        for(int i = 0 ; i < M.length() ; i++ ) {
            single = single + M.charAt(0);
        }
        if(single == M) return 1;

        //2.  1,-1 단조 증가/ 감소 확인 & 등차수열인지
        Boolean progressive = true;
        for(int i = 0 ; i < M.length()-1 ; i++ ) {
            if( ( M.charAt(i+1)-'0') - (M.charAt(i) - '0') != ( M.charAt(1)-'0') - (M.charAt(0) - '0') ) {
                progressive = false;
            }
        }

        if( progressive && ( Math.abs( M.charAt(1)-'0') - (M.charAt(0) - '0')==1 )) return 2;

        //3. 두개의 수가 번갈아 나타나는지 확인
        Boolean alternating = true;
        for(int i = 0; i < M.length(); i++ ) {
            if( M.charAt(i) != M.charAt(i%2)) {
                alternating = false;
            }
        }

        if(alternating) return 4;
        if(progressive) return 5;

        return 10;
    }

    public static int memorize( String N , int begin) {
        //기저사례 수열의 끝에 도착하는 경우
        if(begin == N.length() ) return 0;

        //메모이제이션
        int ret = cache[begin];

        if( ret != -1 ) return ret;

        ret = INF;

        for( int L = 3 ; L <= 5 ; L++ ) {
            if(begin + L <= N.length() ) {
                ret = Math.min( ret , memorize(N,begin + L) + classify(N,begin , begin + L ) );
            }
        }

        cache[begin] = ret;

        return ret;
    }

}


```
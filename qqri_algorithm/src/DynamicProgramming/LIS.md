# 문제
[LIS 문제](https://www.acmicpc.net/problem/11053)
<br>출처 : 백준

# 코드
```java
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import java.math.*;
/*
*  LIS!
* */
public class Main {
    static ArrayList A = new ArrayList();
    static int[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //ArrayList A = new ArrayList();
        int n = Integer.parseInt(br.readLine());

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        for(int i=0;i<n;i++){
            A.add(Integer.parseInt(st.nextToken()));
        }

        //System.out.println(lis(A));
        System.out.println(lis2(A));

        br.close();
    }

    //완전탐색
    public static int lis(ArrayList A){
        if( A.isEmpty() ) return 0;

        int ret =0;

        for(int i=0 ; i < A.size() ; ++i ){
            ArrayList B = new ArrayList();
            for(int j = i+1 ; j < A.size() ; ++j ) {
                if( (Integer)A.get(i) < (Integer)A.get(j) ){
                    B.add(A.get(j));
                }
            }
            ret = Math.max( ret , 1 + lis(B) );
        }
        return ret;
    }

    //dp
    public static int lis2(ArrayList A){
        dp = new int[A.size()];
        dp[0] = 1;
        for(int i=1 ; i < A.size() ; ++i ) {
            dp[i] = 1;
            //j 가 i보다 작음
            for( int j = 0 ; j < i ; j++ ){
                if ( ( (Integer)A.get(i) > (Integer)A.get(j) ) && dp[i] <= dp[j] ){
                    dp[i] = dp[j] + 1;
                }
                else if ( (Integer)A.get(i) == (Integer)A.get(j) ){
                    dp[i] = dp[j];
                }
            }
        }

        Arrays.sort(dp);
        int max = dp[A.size()-1];
        return max;
    }


}

```
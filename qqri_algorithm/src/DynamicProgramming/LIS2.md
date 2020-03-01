# 문제
[01타일 문제](https://www.acmicpc.net/problem/11054)
<br>출처 : 백준

# 코드
```java
import com.sun.deploy.panel.AndOrRadioPropertyGroup;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.math.*;
/*
*  LIS 2
*  늘었다 줄었다 해야됨
*  앞에 증가했다가 중간부터는 감소하는거 세는 ??
*
* */
public class Main {
    static ArrayList A = new ArrayList();
    static int[] dp;
    static int[] reverse_dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //ArrayList A = new ArrayList();
        int n = Integer.parseInt(br.readLine());

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        for(int i=0;i<n;i++){
            A.add(Integer.parseInt(st.nextToken()));
        }



        LIS(A);
        ReverseLIS(A);
        System.out.println(Sum(dp , reverse_dp));

        br.close();
    }

    public static void LIS( ArrayList A){
        dp = new int[A.size()];

        for(int i=0 ; i < A.size() ; i++ ) {
            dp[i] = 1;
            //단순 증가 LIS -> i < j 이다.
            for(int j=0 ; j <= i ; j++ ){
                if( ((Integer)A.get(j) < (Integer)A.get(i)) && dp[i] < dp[j] +1 ) {
                    dp[i]++;
                }
            }
        }

    }

    public static void ReverseLIS (ArrayList A) {
        reverse_dp = new int[A.size()];

        for(int i=A.size()-1 ; i>=0 ; i--) {
            reverse_dp[i]=1;
            for(int j=A.size()-1 ; j >= i ; j-- ){
                if( ((Integer)A.get(j) < (Integer)A.get(i)) && reverse_dp[i] < reverse_dp[j] +1 ) {
                    reverse_dp[i]++;
                }
            }
        }

    }

    public static int Sum (int[] dp , int[] reverse_dp){
        int result=0;
        for(int i=0 ; i < dp.length ; i++ ) {
            if( result < dp[i] + reverse_dp[i] ) result = dp[i] + reverse_dp[i] ;
        }

        return result -1;
    }

}

```
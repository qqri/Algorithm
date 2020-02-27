# 문제
[01타일 문제](https://www.acmicpc.net/problem/1904)
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
* 모르는 미지의 문자열의 경우! ㅠ
* */
public class Main {
    static final int MOD = 15746;
    public static int[] cache = new int[101];
    public static int cnt =0;
    public static String tile="";
    public static String end="";

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        /*
        *  "2" = "00" 과 같은 것
        */
        int n = sc.nextInt();

        for(int i =0; i<n ;i++){
            end = end + "1";
        }

        if(n%2==1){
            for(int i =0; i<n/2 ;i++){
                tile = tile + "2";
            }
            tile = tile + "1";
        }
        else{
            for(int i =0; i<n/2 ;i++){
                tile = tile + "2";
            }
        }

        solve(tile);

        System.out.println( cnt%15746 );
    }

    public static int solve(String tile){

        int num1=0;
        int num2=0;
        int j;

        //기저사례 : 최대한 1로만 이루어진 경우..
        if(tile.equals(end)) {
            cnt ++;
            return cnt;}

        /*1의 개수와 2의 개수 세기*/
        for(int i=0 ; i < tile.length(); i++){
            if( tile.charAt(i) == '1') num1 ++;
            else num2 ++;
        }

        //둘다 0 이 아닌 경우에만 곱하고 나눔.
        if( (num1 !=0) && (num2 !=0) ) {
            cnt = cnt + (fac(tile.length()) / (fac(num1) * fac(num2)) );
        }
        //마지막 2를 1두개로 바꾼다.
        for(j=0;j<tile.length();j++){
            if(tile.charAt(j) == '1') break;
        }
        if(j !=1){ tile = tile.substring(0,j-1) + '1'+'1'+tile.substring(j+1,tile.length());}
        return solve(tile);
    }

    public static int fac(int n) {
        int loop=1;
        for (int i = 1; i <= n; i++) {
            loop *= i;
        }
        return loop;
    }

    //실제로는 이방법이 답! ㅠㅠ
    public static int real(int n){
        int[] map = new int[n+1];


        map[1] = 1;
        map[2] = 2;

        for(int i = 3 ; i <= n ; i ++ ) {
            map[i] = ( map[ i-1 ] + map[ i-2 ] ) % MOD;
        }

        System.out.println( map[n] );
        return map[n];
    }
}

```
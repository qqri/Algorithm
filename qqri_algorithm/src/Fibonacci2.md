# 문제
[피보나치2](https://www.acmicpc.net/problem/2747)
<br>출처 : 백준

### 오버플로 생각하기!!

# 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {
    static int n;
    static long[] result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        n = Integer.parseInt(br.readLine());

        //동적계산을 위해 -1로 다 셋팅함
        result = new long[n+1];
        for(int i=0;i<=n;i++){
            result[i] = -1;
        }


        System.out.println(Fibo(n));

    }

    public static long Fibo(int n){
        if(n == 0 ) {result[0]= 0; return 0;}
        if(n == 1 ) {result[1]= 1; return 1;}

        if(result[n] != -1) return result[n];

        return result[n] = Fibo(n-1)+Fibo(n-2);

    }

}

```
# 문제
[RGB거리](https://www.acmicpc.net/problem/1149)
<br>출처 : 백준

# 코드
```java
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.math.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][3];
        int[][] calMap = new int[n][3]; //계산할 부분

        for (int i = 0; i < n; i++) {
            for(int j=0;j<3;j++){
                map[i][j] = sc.nextInt();
            }
        }

        calMap[0][0] = map[0][0];
        calMap[0][1] = map[0][1];
        calMap[0][2] = map[0][2];

        for(int i=1;i<n;i++){
            // 마지막이 R로 끝나는 것 중에서 위에꺼가 제일 작은 값 더한것. 맨 마지막꺼 중심으로 본다.
            calMap[i][0] = Math.min( calMap[i-1][1] , calMap[i-1][2]) + map[i][0] ;
            calMap[i][1] = Math.min( calMap[i-1][0] , calMap[i-1][2]) + map[i][1] ;
            calMap[i][2] = Math.min( calMap[i-1][0] , calMap[i-1][1]) + map[i][2] ;
        }

        Arrays.sort(calMap[n-1]);
        System.out.println(calMap[n-1][0]);
    }
}

```
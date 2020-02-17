# 문제
[정삼각형 문제](https://www.acmicpc.net/problem/1932)
<br>출처 : 백준

# 코드
```java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int map[][];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int maxRoad=0;

    public static void main(String[] args) throws NumberFormatException, IOException {

        //삼각형의 층 수 n
        n = Integer.parseInt(br.readLine());
        int map[][] = new int[n][n];
        //삼각형 판 만들기
        //주의! : br은 엔터만 인식한다.
        for(int i=0;i<n;i++){
            String line = br.readLine();
            st = new StringTokenizer(line);
            for(int j=0;j<=i;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    map[i][j] += map[i-1][j];
                }
                else if(i == j){
                    map[i][j] += map[i-1][j-1];
                }
                else map[i][j] += Math.max( map[i-1][j-1] , map[i-1][j] );


                // 한방에 : map[i][j] += Math.max( (j==0) ? 0 : map[i-1][j-1], map[i-1][j]);

            }
        }
        Arrays.sort(map[n-1]); // n-1 행 즉, 크기 5짜리 삼각형이였으면 마직막 행을 정력한다. -- 내림차순으로 정렬됨
        System.out.println(map[n-1][n-1]); //내림차순이니까 마지막꺼 정렬하면 되겠징!? 

    }


}

```
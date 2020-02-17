# 문제
[정삼각형 문제](https://www.acmicpc.net/problem/1932)
<br>출처 : 백준

# 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;
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

        /*
        * 삼각형의 맨 끝인경우 그냥 더함?_?
        * (0,0)
        * (1,0) (1,1)
        * (2,0) (2,1) (2,2)
        *
        */
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    maxRoad += map[0][0];
                }
                if(i == j){
                    maxRoad = maxRoad +map[i][j];
                }
                else maxRoad = Math.max( maxRoad +map[i][j] , maxRoad + map[i][j+1] );

            }
        }

        System.out.println(maxRoad);

    }


}

```
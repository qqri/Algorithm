# 문제
[행렬곱셈](https://www.acmicpc.net/problem/2740)
[스트라센알고리즘](https://loveisaround.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%8A%A4%ED%8A%B8%EB%9D%BC%EC%84%BC-strassen)
<br>출처 : 백준

# 코드
```java
import java.io.IOException;
import java.util.Scanner;
//3중 포문써서 O(N^3).. 인데 스트라센 알고리즘? 쓰면 O(n*log7)로 준다는데
//심하게 긴것같고.. 절대 내가 구현할수있는게 아니라서 우선 안함. . .
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N,M,K;
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] board1 = new int[N][M];
        for(int i =0;i<N;i++){
            for(int j = 0;j<M;j++){
                board1[i][j] = sc.nextInt();
            }
        }

        M = sc.nextInt();
        K = sc.nextInt();
        int[][] board2 = new int[M][K];
        for(int i =0;i<M;i++){
            for(int j = 0;j<K;j++){
                board2[i][j] = sc.nextInt();
            }
        }

        int[][] result = new int[N][K];
        for(int i =0;i<N;i++){
            for(int j=0;j<K;j++){
                for(int k=0;k<M;k++){
                    result[i][j] += board1[i][k]*board2[k][j];
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }


}
```
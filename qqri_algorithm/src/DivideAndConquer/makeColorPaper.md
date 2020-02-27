# 문제
[색종이만들기](https://www.acmicpc.net/problem/2630)
<br>출처 : 백준

# 코드
```java
import java.util.Scanner;

public class Main {
    static int[][] board;
    static int white=0; //흰색 0
    static int blue=0; //파란색 1

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        board = new int[n][n];

        //입력 보드 만듦.
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
            }
        }

        divide(n,0,0);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int num, int startX, int startY){

        int color = board[startX][startY];

        for(int i = startX; i <startX+num ;i++){
            for(int j= startY; j<startY+num ; j++){

                if(color!=board[i][j]){ //다르면 쪼갠다.

                    divide(num/2 , startX , startY);
                    divide(num/2 , startX , startY+num/2);
                    divide(num/2 , startX+num/2 , startY);
                    divide(num/2 , startX+num/2 , startY+num/2);
                    return;

                }
            }

        }
        if(color == 0) white++;
        else blue++;

        return;
    }

}
```
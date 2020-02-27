# 문제
[색종이개수](https://www.acmicpc.net/problem/1780)
<br>출처 : 백준

# 코드
```java
import java.util.Scanner;
public class Main {
    static int[][] board;
    static int one=0; //-1
    static int two=0; // 0
    static int three =0; // 1

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
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
    }

    public static void divide(int num, int startX, int startY){

        int color = board[startX][startY];

        for(int i = startX; i <startX+num ;i++){
            for(int j= startY; j<startY+num ; j++){

                if(color!=board[i][j]){ //다르면 쪼갠다.

                    divide(num/3 , startX , startY);
                    divide(num/3 , startX+num/3 , startY);
                    divide(num/3 , startX+2*(num/3) , startY);

                    divide(num/3 , startX , startY+num/3);
                    divide(num/3 , startX+num/3 , startY+num/3);
                    divide(num/3 , startX+2*(num/3) , startY+num/3);

                    divide(num/3 , startX , startY+2*(num/3));
                    divide(num/3 , startX+num/3 , startY+2*(num/3));
                    divide(num/3 , startX+2*(num/3) , startY+2*(num/3));

                    return;

                }
            }

        }
        if(color == -1) one++;
        else if(color == 0) two++;
        else three++;

        return;
    }

}

```
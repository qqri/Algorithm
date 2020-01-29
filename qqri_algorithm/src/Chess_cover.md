# 문제
[체스판 다시칠하기](https://www.acmicpc.net/problem/1018)
<br>출처 : 백준

# 코드
```java
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //백준 https://www.acmicpc.net/problem/1018
    public static int[][] board;
    public static int[][] chessBoard = new int[8][8];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        board = new int[H][W];


        for(int i=0;i<H;i++){
            String row = sc.next();
            for(int j=0;j<W;j++){
                board[i][j] = (row.charAt(j) == 'B')? 1:0; //B면 1, 아니면 0 저장
            }
        }

        System.out.println( chess(board) );

    }


    public static int chess(int[][] board) {
        int result=5000;
        int[] minst = new int[3];

        for(int i=0 ; i<board.length-7 ; i++){
            for(int j=0 ; j<board[0].length-7 ; j++){
                chessBoard = set(i,j,board);
                minst[0] = cover(0,chessBoard);
                minst[1] = cover(1,chessBoard);
                minst[2] = result;
                Arrays.sort(minst);
                result = minst[0];

            }
        }

        return result;
    }

    public static int[][] set(int y, int x, int[][] board){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                chessBoard[i][j] = board[i+y][j+x];
            }
        }
        return chessBoard;
    }

    public static int cover(int temp,int[][] chessBoard){
        int val = 0;
        for(int dy=0;dy<8;dy++){
            for(int dx=0;dx<8;dx++){
                if( (dy%2 == dx%2) && chessBoard[dy][dx]!=temp) val++;
                else if( (dy%2 != dx%2) && chessBoard[dy][dx]==temp ) val++;
            }
        }
        return val;
    }


}
```
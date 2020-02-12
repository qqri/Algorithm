# 문제
[외발뛰기](https://algospot.com/judge/problem/read/JUMPGAME)
<br>출처 : 알고스팟

# 코드
```java
import java.util.Arrays;
import java.util.Scanner;

public class Jumpgame {
    int[][] board;
    int[][] cache;
    int n;

    Jumpgame(int[][] board) {
        n = board.length;
        this.board = board;
        this.cache = new int[n][n];
        for (int[] arr : this.cache) Arrays.fill(arr, -1);
    }

    //동적 계획법
    public boolean jump2(int y, int x) {
        if (y >= n || x >= n) return false; // 기저사례:게임판 밖을 벗어난 경우
        if (x == n - 1 || y == n - 1) return true;

        if (cache[y][x] == 1) return false;
        else cache[y][x] = 1;

        //int ref = cache[y][x];
        //if (ref !=-1) return ref;

        int jumpSize = board[y][x];
        return (jump2(y + jumpSize, x)) || (jump2(y, x + jumpSize));
    }

    public static void main(String[] args) {
        int n;
        int[][] board = new int[0][0];


        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            n = sc.nextInt();
            board = new int[n][n];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++)
                    board[y][x] = sc.nextInt();
            }
        }

        Jumpgame jumpgame = new Jumpgame(board);
        boolean res = jumpgame.jump2(0, 0);
        System.out.println(res ? "YES" : "NO");

    }
}

```
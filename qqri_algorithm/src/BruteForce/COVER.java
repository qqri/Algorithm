import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class COVER {
    public static int[][] board;
    public static int[][][] coverType = {
            {{0, 0}, {1, 0}, {0, 1}},
            {{0, 0}, {0, 1}, {1, 1}},
            {{0, 0}, {1, 0}, {1, 1}},
            {{0, 0}, {1, 0}, {1, -1}}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        String result = "";
        int H, W;
        for (int k = 0; k < C; k++) {
            H = sc.nextInt();
            W = sc.nextInt();

            board = new int[H][W];

            for (int i = 0; i < H; i++) {
                // String row = br.readLine().trim(); //다음 \n 을 제거하기 위함.
                String row = sc.next();
                for (int j = 0; j < W; j++) {
                    board[i][j] = (row.charAt(j) == '#') ? 1 : 0;
                }
            }
            result += (k + 1 == C) ? cover(board) : cover(board) + "\n";
        }

        System.out.println(result);

    }

    public static boolean set(int[][] board, int y, int x, int type, int delta) {
        boolean ok = true;

        for (int i = 0; i < 3; i++) { //가능한 배치에서 coverType의 배치하는 보드가 총 3개니까
            int ny = y + coverType[type][i][0];
            int nx = x + coverType[type][i][1];
            //board.length 는 가로 길이
            //board[0].length 는 세로 길이 의미 한다.

            if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) {
                ok = false;
            } else if ((board[ny][nx] += delta) > 1) {
                //검은 칸이 쌓여 있을 경우(이렇게 하지 않으면 지울때 한꺼번에 지워지므로 쌓는다.)
                ok = false;
            }
        }
        return ok;
    }

    public static int cover(int[][] board) {
        int x = -1, y = -1; //가장 왼쪽 위에 있는 빈칸 찾기위함.
        //보드의 왼쪽 위에서 부터 하나씩 찾기 시작
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {//왼쪽 가장 위에 있는 빈칸 찾음.
                    y = i;
                    x = j;
                    break;
                }
            }
            //빈칸을 찾은 이후에 다음 세로줄로 넘어가면 안되므로 -1이 아닌 경우엔
            //반복문을 나오도록 한다.
            if (y != -1)
                break;
        }


        //기저사례 : 모든 빈칸이 채워지면 무조건 x 또는 y 중에 하나가 -1로 될것이므로
        if (y == -1) return 1;

        int resultMain = 0;

        for (int type = 0; type < 4; type++) {
            if (set(board, y, x, type, 1)) {
                resultMain += cover(board);
            }
            set(board, y, x, type, -1); //블록을 다시 치운다.
        }
        return resultMain;
    }
}

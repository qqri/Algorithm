import java.util.Scanner;
import java.lang.*;

public class BOGGLE {
    /*
     * 각각에 대해 8가지 경우 모두 따진다.
     *
     * 자바의 substring 의 기능을 잘 이해하지 못함.
     * 재귀할수록 자바 서브스트링속으로 간다는것 이해하기.
     *
     * */

    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
    static int[][] board;

    static boolean hasWord(int x, int y, String word) {
        //기저사례 1 : 판을 벗어나는 경우
        if (x >= 5 || y >= 5 || x < 0 || y < 0) return false;
        //기저사례 2 : word리턴값이 없는 경우
        if (board[x][y] != word.charAt(0)) return false;
        //기저사례 3 : word가 1개 남은 경우
        if (word.length() == 1) return true;

        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (hasWord(nextX, nextY, word.substring(1)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board;
        String word;

        int tc = sc.nextInt(); // 테스트 케이스

        while (tc > 0) {
            board = new int[5][5];
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++)
                    board[x][y] = sc.nextInt();
            }
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                // wordList[i] = sc.nextLine();
                word = sc.nextLine();
                boolean res = hasWord(0, 0, word);
                System.out.println(res ? "YES" : "NO");
            }
            tc--;
        }


    }


}

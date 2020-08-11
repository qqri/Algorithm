package Graph;

import java.lang.reflect.Array;
import java.util.*;

public class WordSearch {

    public static void main(String[] args) {

        char[][] board = {  {'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}   };

        String str = "ABCB";


        System.out.println(sol1(board, str) );
    }

    public static boolean sol1(char[][] board, String str) {
        ArrayList<ArrayList<Integer>> firstChar  = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;

        for(int i=0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++ ) {
                if(board[i][j] == str.charAt(0)) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    firstChar.add(list);
                }
            }
        }

        if(firstChar == null) return false;
        for(int i = 0 ; i < firstChar.size() ; i++ ){
            ArrayList<Integer> list = firstChar.get(i);
            if(sol2(board , list.get(0), list.get(1), str)) return true;
        }

        return false;
    }

    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};

    public static boolean sol2(char[][] board, int x, int y, String str) {

        int m = board.length;
        int n = board[0].length;

        //기저사례 1. 판을 벗어나는 경우
        if( x >= m || x < 0 || y >= n || y <0 || board == null) return false;

        //기저사례 2 : str의 리턴값이 없는 경우
        if(board[x][y] != str.charAt(0)) return false;

        //기저사례 3 : str 1개만 남는 경우
        if( str.length() == 1) return true;

        board[x][y] = '0'; //한번 갔다 온 곳은 표시해둠.

        for(int i = 0 ; i < 8 ; i++ ) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(sol2(board, nextX, nextY, str.substring(1)))
                return true;
        }

        return false;
    }
}

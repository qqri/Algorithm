package Graph;

import java.lang.reflect.Array;
import java.util.*;

public class WordSearch {

    public static void main(String[] args) {

        char[][] board = {  {'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}   };

        String str = "SEE";


        System.out.println(solution(board, str) );
    }

    public static boolean solution(char[][] board , String str) {
        int m = board.length;
        int n = board[0].length;

        if(m == 0 || n == 0 || board==null || str.length() == 0) return false;

        int[][] visited = new int[m][n];

        for(int i = 0 ; i < m ; i++ ) {
            for(int j = 0 ; j < n  ; j++ ) {
                if(dfs(board, visited, i, j, 0, str)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int[][] dirs = {{1,0} , {-1,0} , {0,1}, {0,-1}};

    public static boolean dfs( char[][] board, int[][] visited, int i, int j, int index, String str ){
        int m = board.length;
        int n = board[0].length;
        // 기저 사례
        if(index == str.length()) return true;

        if(i < 0 || i >= m || j < 0 || j >= n||board == null || visited == null || str.length() == 0) return false;
        if(visited[i][j] == 1) return false; //한번 왔다 간 곳
        if( board[i][j] != str.charAt(index) ) return false;


        visited[i][j] = 1; //방문했으니 변경해줌.

        for(int[] dir : dirs) {
            int nextX = i + dir[0];
            int nextY = j + dir[1];
            if( dfs(board, visited, nextX, nextY, index+1, str) ) return true;
        }

        visited[i][j] = 0;
        return false;
    }




    // =============================== //



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

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

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

        for(int i = 0 ; i < 4 ; i++ ) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(sol2(board, nextX, nextY, str.substring(1)))
                return true;
        }

        return false;
    }
}

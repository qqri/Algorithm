import java.util.*;

class Solution {

    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    int[][] board;
    int count, M, N;
    public int[] solution(int m, int n, int[][] picture) {

        M = m;
        N = n;
        board = new int[M][N];
        for(int i =0;i < M; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = picture[i][j];
            }
        }
        int sum = 0, ans = 0;
        for(int i =0;i < M; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] > 0){
                    count = 0;
                    sum++;
                    dfs(i, j);
                    ans = Math.max(ans, count);
                }
            }
        }
        return new int[]{sum, ans};
    }

    public void dfs(int x, int y){
        int nx, ny, root = board[x][y];
        board[x][y] = 0;
        count++;
        for(int i =0;i < 4; i++){
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx >= 0  && ny >= 0 && nx < M && ny < N && board[nx][ny] == root){
                dfs(nx, ny);
            }
        }
    }
}

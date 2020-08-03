package Graph;
import java.util.*;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid =  { {'1','1','1','0','1'},
                       {'1','1','0','0','0'},
                       {'1','1','0','0','1'},
                       {'0','0','0','0','1'} };

        // 대각선에 있는건 신경 안쓰는 듯.
        System.out.println(solve1(grid));

    }

    public static int solve1(char[][] grid) {
        //위 아래 양 옆 검사한다는 점 알아 두기
        //1 error check , return 값 정하기
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int cnt = 0 ;

        //2
        for(int i=0 ; i <  grid.length ; i++ ) {
            for(int j = 0 ; j < grid[0].length ; j++ ) {
                if(grid[i][j] == '1') {
                    cnt++;
                    bfs(grid, i , j);
                }
            }
        }
        return cnt;
    }

    public static void dfs(char[][] grid , int i , int j) {
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') return;

        grid[i][j] = 'X'; //한번 지난 건 바꿔줌.

        dfs(grid , i-1, j );
        dfs(grid , i+1, j );
        dfs(grid , i, j-1 );
        dfs(grid , i, j+1 );

    }

    public static int[][] dirs= {{-1,0} , {1,0}, {0,1}, {0,-1}  };
    public static void bfs(char[][] grid, int x , int y) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {x,y});

        while(!que.isEmpty()) {
            int size = que.size();
            int[] point = que.poll();
            for(int i = 0 ; i < size ; i++ ) {
                for (int[] dir : dirs) {
                    int x1 = point[0] + dir[0];
                    int y1 = point[1] + dir[1];
                    if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length && grid[x1][y1] == '1') {
                        grid[x1][y1] = '0';
                        que.offer(new int[] {x1, y1});
                    }
                }
            }
        }

    }


}

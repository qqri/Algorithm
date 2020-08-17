package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

public class Maze {
    public static int[][] dirs = {{1,0}, {-1,0} , {0,1} , {0, -1}};
    //  왼     오       위      아래
    public static void main(String[] args) {
        int[][] grid ={
                     { 0, 0, 1, 0, 0},
                     { 0,0, 0, 0, 0},
                     { 0, 0 ,0 ,1 ,0},
                     { 1, 1, 0, 1, 1},
                     { 0, 0, 0, 0, 0}
                                     };
        int[] start = {0,4};
        int[] end = {4,4};

        System.out.println(bfs(grid, start, end));


    }
    public static boolean bfs(int[][] grid, int[] start, int[] end) {

        //1
        int m = grid.length;
        int n = grid[0].length;
        if(start[0] == end[0] && start[1] == end[1]) return true;
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        //2
        que.offer(new int[] {start[0], start[1]});
        visited[start[0]][start[1]] = true;

        while (!que.isEmpty()) {
            int[] p = que.poll();

            for(int[] dir : dirs) {
                int x = p[0];
                int y = p[1];
                while( x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 ) {
                        x += dir[0];
                        y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];

                if(visited[x][y]) continue;

                visited[x][y] = true;

                if( x== end[0] || y == end[1] ) return true;

                que.offer( new int[] {x, y} );
            }

        }

        return false;
    }

    public static boolean dfs(int[][] grid, int[] start, int[] end , int[] before) {

        //1
        if(start[1] == end[1] && start[0] == end[0]) return true;

       // if(start[0] < 0 || start[0] >= grid.length || start[1] < 0 || start[1] >= grid[0].length ) return false;
       // if(grid[start[0]][start[1]] == 2) return false;

        //2
        if(grid[start[0]][start[1]] == 0) {
         //   grid[start[0]][start[1]] = 2; // 한번 지난 곳 표시하기
            start[0] += before[0];
            start[1] += before[1];
            return dfs(grid, start , end , before);
        }
        else if(grid[start[0]][start[1]] == 1 || start[0] < 0 || start[0] >= grid.length || start[1] < 0 || start[1] >= grid[0].length) {// 1 일때
            if( grid[start[0]][start[1]] == 1 ) {
                grid[start[0]][start[1]] = 2;
            }
            start[0] -= before[0];
            start[1] -= before[1];
            grid[start[0]][start[1]] = 0;
            for(int[] dir : dirs ) {
                    start[0] += dir[0];
                    start[1] += dir[1];

                    dfs(grid , start, end, dir);

            }
        }

        return false;
    }




}

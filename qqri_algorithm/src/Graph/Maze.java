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
                     { 0, 0, 0, 0, 0}};
        int[] start = {0,4};
        int[] end = {4,4};

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        System.out.println(dfs(grid, visited, start, end));
        System.out.println("====");
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

    public static boolean dfs(int[][] grid, boolean[][] visited,int[] start, int[] end) {
        //1
        int m = grid.length;
        int n = grid[0].length;

        int x = start[0];
        int y = start[1];

        if( x < 0 || x >= m || y < 0 || y >= n || visited[x][y] ) return false;
        visited[x][y] = true;
        if(start[1] == end[1] && start[0] == end[0]) return true;

        for(int[] dir : dirs) {
            while( x >=0 && x < m && y >= 0 && y < n ) {
                x += dir[0];
                y += dir[1];
            }
            x -= dir[0];
            y -= dir[1];

//            dfs(grid, visited, new int[] {x,y} , end) ;
            if(dfs(grid, visited , new int[] {x,y} , end)) {
                return true;
            }
        }



        return false;
    }




}

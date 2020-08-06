package Graph;

import java.util.*;

public class MaxOfIsland {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '0', '0', '1'}};

        System.out.println(solve(grid));
    }

    public static int solve(char[][] grid) {
        //1
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = -1;
        int max = 0;
        int area;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0 ; j < grid[0].length ; j++ ) {
                if(grid[i][j] == '1') {
                    //1
                    area = dfs(grid , i ,j, 0);
                    max = Math.max( max , area );
                    //2
                    cnt++;
                    list.add(0);
                    dfs(grid, i , j, cnt, list);
                }

            }
        }
        //1
        return max;

        //2
//        int max = 0;
//        for(int i = 0 ; i < list.size() ; i++) {
//            max = Math.max(max, list.get(i));
//        }
//        return max;
    }
    //1
    public static int[][] dirs = { { 1, 0 } , { -1 , 0 } , { 0 , 1 } , { 0 , -1 } };
    public static int dfs(char[][] grid, int i , int j, int area) {
        //1
        int m = grid.length;
        int n = grid[0].length;
        if( grid == null || i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' ) {
            return area;
        }

        //2 1인 경우 진입하게 됨.
        area++;
        grid[i][j] = '0';
        for(int[] dir : dirs) {
            area = dfs(grid , i + dir[0] , j + dir[1] , area);
        }
        return area;
    }


    //2
    public static void dfs(char[][] grid, int i , int j , int cnt, ArrayList<Integer> list ) {
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') return;
        else {
            list.set( cnt , list.get(cnt)+1 );
        }

        grid[i][j] = '0';

        dfs(grid , i-1, j , cnt, list );
        dfs(grid , i+1, j , cnt, list  );
        dfs(grid , i, j-1 , cnt, list  );
        dfs(grid , i, j+1 , cnt, list  );

    }


}

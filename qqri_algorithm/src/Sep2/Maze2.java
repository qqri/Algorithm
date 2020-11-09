package Sep2;

public class Maze2 {
    public static void main(String[] args) {
        int[][] grid ={
                { 0, 0, 1, 0, 0},
                { 0,0, 0, 0, 0},
                { 0, 0 ,0 ,1 ,0},
                { 1, 1, 0, 1, 1},
                { 0, 0, 0, 0, 0}};

        int[] start = {0,4};
        int[] end = {4,4};

        System.out.println("답!!!! ");
        System.out.println( dfs(grid, start , end , new boolean[grid.length][grid[0].length]) );
    }
    /*
    * 벽에 닿아야 끝난다.
    * 위아래오왼 으로 간다.
    * 1 은 벽 으미, 0은 빈곳 의미
    * */
    public static int[][] dirs = {{-1,0} , {1,0} , {0,1}, {0, -1}};


    public static boolean dfs(int[][] grid, int[] start , int[] end , boolean[][] visited) {

        int n = grid.length , m = grid[0].length;
        int row = start[0] , col = start[1] ;

        if( row < 0 || row >= n || col < 0 || col >= m || visited[row][col]) return false;

        visited[row][col] = true;

        if( row == end[0] && col == end[1]) return true;

        for( int[] dir : dirs ) {
            int x = start[0];
            int y = start[1];
            while( x>= 0 && x <n && y >= 0 && y < m && grid[x][y] == 0 ) { // 1 되기 전까지 쭉쭉 간다.
                x += dir[0];
                y += dir[1];
            }

            x -= dir[0];
            y -= dir[1];

            if ( dfs(grid , new int[] {x,y} , end , visited )) {
                return true;
            }

        }

        return false;
    }

}

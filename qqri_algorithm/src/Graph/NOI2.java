package Graph;

public class NOI2 {
    public static void main(String[] args) {
        int[][] grid =  { {1,1,1,0,1},
                          {1,1,0,0,0},
                          {1,1,0,0,1},
                          {0,0,0,0,1} };
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        int max = 0;
        int area;
        for(int i =0 ; i < m; i++) {
            for(int j = 0 ; j < n ; j++ ) {
                if(grid[i][j] == 1) {
                    //최대 섬 크기
                    max = Math.max( max, solve2(grid,i,j,0) );

                    //  섬 개수
                    solve1(grid,i,j);
                    cnt ++;
                }
            }
        }

        System.out.println( "섬 크기 최대 : " + max);
        System.out.println("섬 개수 : " + cnt);

    }
    public static int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

    public static void solve1( int[][] grid , int x , int y ) {
        int m = grid.length;
        int n = grid[0].length;

        if( x < 0 || x >= m  || y < 0 || y >= n || grid == null || grid[x][y] != 1) return;

        // 1 이면 땅
        if(grid[x][y] == 1) grid[x][y] =2; // 지나갔다는 의미

        for(int[] dir : dirs ) {
            solve1(grid , x + dir[0] , y + dir[1] );
        }


    }


 //   public static int num = 0;
    public static int solve2( int[][] grid , int x , int y ,int num) {
        int m = grid.length;
        int n = grid[0].length;

        if( x < 0 || x >= m  || y < 0 || y >= n || grid[x][y] != 1) return num;

        // 1 이면 땅
        num++;
        grid[x][y] = 0; // 지나갔다는 의미

        for(int[] dir : dirs ) {
            num = solve2(grid , x + dir[0] , y + dir[1] , num ); // num을 다시 리턴해줘야 계속 갱신된다.
        }
        return num;
    }


}

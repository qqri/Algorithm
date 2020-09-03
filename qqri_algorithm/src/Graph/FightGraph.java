package Graph;

public class FightGraph {
    public static void main(String[] args) {
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println( solution(5,results) );
    }
    public static int solution(int n , int[][] results) {
        // 1 : 이김, -1 : 짐. 0 : 정보 없음
        int[][] grid = new int[n][n];

        for(int i = 0 ; i < n ; i++ ){
            grid[(results[i][0]-1)][(results[i][1]-1)] = 1;
            grid[(results[i][1]-1)][(results[i][0]-1)] = -1;
        }

        for(int i = 0 ; i < grid.length ; i++ ) {
            for(int j =0; j < grid.length ; j++ ) {
                if(grid[i][j] == -1 ) {
                    dfs(grid,i,j );
                }
            }
        }

        int cnt = 0;
        int answer = 0;

        for(int i = 0 ; i < grid.length ; i++ ) {

            for(int j = 0 ; j < grid.length ; j++ ) {
                if(grid[i][j] != 0) cnt++;
            }

            if(cnt == grid.length-1) {
                System.out.println(i);
                answer++;
            }

            cnt=0;
        }

        return answer;
    }

    public static void dfs(int[][] grid, int index ,int target) {
        for(int i = 0 ; i < grid.length ; i++) {
            if(grid[index][i] == -1 ) grid[target][i] = -1;
        }

    }

}

package Test;

import java.util.Scanner;

public class Prob8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt(); // 가로
        int h = sc.nextInt(); // 세로

        int[][] grid = new int[h][w];

        for(int i = 0 ; i < h ; i++) {
            for(int j = 0 ; j < w ; j++ ) {

                grid[i][j] = sc.nextInt();
            }
        }


        int min = 10000;

        for(int i = 0 ; i < h ; i++) {
            for(int j = 0 ; j < w ; j++ ) {
                if(grid[i][j] == 1) {
                    min = Math.min(min, solve(grid, i, j, 0));
                }
            }
        }

        System.out.println(min);

    }

    public static int[][] dirs = {{-1,0} , {1,0} , {0,1} , {0,-1}};
    public static int solve(int[][] grid , int y , int x , int cnt) {
        //1 기저조건
        if(cnt > 100) {cnt = -1 ; return cnt;} // 100번을 돌려도 안오는 순간이 오면 그냥 -1 리턴

        int w = grid[0].length;
        int h = grid.length;
        if( x < 0 || x >= w ||  y < 0 || y >= h || grid[y][x] == -1) return cnt;
        //if(grid[y][x] == -1) return cnt;

        //2
        //cnt++; // 1 이어도 들어올 수는 있다.
        int temp=0;
        // 주변 모두 1 로 변경해줌
        for(int[] dir : dirs) {
            int dx = x + dir[1];
            int dy = y + dir[0];
            if(dx >= 0 && dx < w &&  dy >= 0 && dy < h && grid[dy][dx]==0 ) {
                temp++;
                grid[dy][dx] = 1;
            }
        }

        if(temp > 0) cnt++;
        //주변 1로 변경한 이후에 다시 탐색함.
        for(int[] dir : dirs) {
            cnt = solve(grid, y+dir[0] , x+dir[1] , cnt);
        }

        return cnt;
    }

    // 토마토가 다 익는 최소 일 수
    // 둘째 줄 부터 토마토 정보가 주아진다. 1 익음 0 ㅇ안 익, -1 없음

}

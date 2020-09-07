package Test;

import java.util.Arrays;
import java.util.Scanner;

public class Prob9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] grid = new int[n][n];

        for(int i = 0 ; i < n ; i++ ) {
            for(int j = 0 ; j <= i ; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int[] max = new int[n];

        for(int i = 0 ; i < n ; i++ ) {
            max[i] = findMax(grid, n-1 , i,0 );
        }
        Arrays.sort(max);

        System.out.println(max[n-1]);
    }

    public static int findMax(int[][] grid, int y, int x , int sum) {
        sum = sum + grid[y][x];

        if(y==0) return sum;
        if(x == 0 ) return findMax(grid,y-1 , x , sum);

        if(grid[y-1][x-1] > grid[y-1][x]) return findMax(grid ,y-1 , x-1 , sum);
        else return findMax(grid,y-1 , x , sum);

    }

    /*
    * 자기 자신의 바로 위 이거나 왼쪽 위 중에 더 큰 것 으로 옮겨간다.
    *
    * */
}

package Graph;

import java.util.*;
import java.util.Scanner;


class GoodGround {
    static int Answer;

    public static void main(String args[]) throws Exception	{

        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            int[][] grid = new int[m][n];
            for(int i = 0 ; i < m ; i++ ) {
                for(int j = 0 ; j < n ;j ++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int Answer = solve(grid);
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }

    public static int solve (int[][] grid ) {
        int sum = 0, max = 0;
        for(int i = 0 ; i < grid.length-4 ; i++ ) {
            for(int j = 0 ; j < grid[0].length-4 ; j++ ) {

                for(int k = i ; k < i+5 ; k++ ) {
                    for(int u = j ; u < j+5 ; u++ ) {
                        sum += grid[k][u];
                    }
                }
                max = Math.max(sum, max);
                sum = 0;
            }

        }
        return max;
    }

}
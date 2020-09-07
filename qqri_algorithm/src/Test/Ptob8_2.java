package Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class XY {
    int x;
    int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Ptob8_2 {
    static int[][] dirs = {{-1,0} , {1,0} , {0,1} , {0,-1}};
    static Queue<XY> que_cur = new LinkedList<>();
    static Queue<XY> que_after = new LinkedList<>();
    static Queue que_temp;
    static int n , m;
    static int non_tomato = 0;
    static int[][] grid = new int[100][100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int temp = 0;

       // int[][] grid = new int[m][n];

        int day=0;

        for(int i = 0; i < m ; i++) {
            for(int j = 0 ; j < n ; j++ ) {
                temp = sc.nextInt();
                grid[i][j] = temp;
                if(temp == 1) {
                    que_cur.offer( new XY( j , i ));
                }
                if(temp == 0) {
                    non_tomato ++;
                }
            }
        }


        while(true) {
            if(non_tomato == 0) break;

            while (!que_cur.isEmpty()) {
                XY cur_xy = que_cur.poll();
                make_trans_tomato(grid , cur_xy.x , cur_xy.y);
            }
            if(que_after.isEmpty()) break;

            day++;

            que_temp = que_cur;
            que_cur = que_after;
            que_after= que_temp;
            que_after.clear();
        }

        if(non_tomato==0) System.out.println(day);
        else System.out.println(-1);
    }

    public static boolean check(int x, int y) {

        if( x < 0 || x >=n || y < 0 || y >= m ) return false;

        return true;
    }

    public static void make_trans_tomato(int[][] grid , int x, int y) {
        int dx , dy;

        for(int[] dir : dirs ) {
            dx = dir[0] + x ;
            dy = dir[1] + y ;
            if(check(dx , dy)  && grid[dy][dx] == 0 ) {
                grid[dy][dx] = 1;
                que_after.offer(new XY(dx, dy));
                non_tomato--;
            }
        }
    }



}

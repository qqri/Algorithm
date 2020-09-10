package Sep2;

import java.util.LinkedList;
import java.util.Queue;

class XY {
    int x;
    int y;
    public XY(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Tomato {
    public static int[][] dirs = {{-1 ,0}, {1,0}, {0,1}, {0, -1}};
    public static Queue<XY> queCur = new LinkedList<>();
    public static Queue<XY> queAfter = new LinkedList<>();
    public static Queue temp = new LinkedList();
    public static int nonMakedTomato =0;

    public static void main(String[] args) {
        // 최소 일수 구한다.
        //1
        int[][] input1 = { {0 , 0 , 0 , 0 , 0 , 0 },
                           {0 , 0 , 0 , 0 , 0 , 0 },
                           {0 , 0 , 0 , 0  ,0 , 0 },
                           {0 , 0 , 0 , 0  ,0 , 1}};

        int[][] input2 = { {0 , -1 , 0 , 0 , 0 , 0 },
                           {-1 , 0 , 0 , 0 , 0 , 0 },
                           {0 , 0 , 0 , 0  ,0 , 0 },
                           {0 , 0 , 0 , 0  ,0 , 1}};

        int[][] input3 = { {-1 , 1 , 0 , 0 , 0 },
                           {0 , -1 , -1 , -1 , 0},
                           {0 , -1 , -1 , -1  ,0},
                           {0 , -1 , -1 , -1  ,0},
                           {0 , 0 , 0 , 0  ,0  }};

        System.out.println( solution(input3) );

    }

    public static int solution( int[][] grid ) {

        int m = grid.length , n = grid[0].length;

        for(int i =0 ; i < m ; i++ ) {
            for (int j = 0 ; j < n ; j++ ) {
                if( grid[i][j] == 1 ) {
                    queCur.offer(new XY(i ,j));
                }
                else if( grid[i][j] == 0) {
                    nonMakedTomato++;
                }
            }
        }
        //1
        int day = 0;

        //2
        while(true) {

            if(nonMakedTomato == 0) {
                break;
            }

            while( !queCur.isEmpty()) {
                XY curXY = queCur.poll();
                make_tomato(grid , curXY.y , curXY.x );
            }
            if( queAfter.isEmpty() ) {
                break;
            }

            day++;

            temp = queCur;
            queCur = queAfter;
            queAfter = temp;
            queAfter.clear();
        }

        if(nonMakedTomato == 0) return day;
        else return -1;
    }


    public static void make_tomato(int[][] grid ,int y , int x) {
        int dx , dy;

        for(int[] dir : dirs) {
            dx = dir[0] + x;
            dy = dir[1] + y;
            if(check(grid , dy , dx ) && grid[dy][dx] == 0 ) {
                grid[dy][dx] = 1;
                queAfter.add(new XY(dy , dx));
                nonMakedTomato--;
            }
        }
    }

    public static boolean check( int[][] grid , int y , int x) {
        int m = grid.length;
        int n = grid[0].length;
        if( y >= m || y < 0 || x >= n || x < 0 ) return false;
        return true;
    }

}

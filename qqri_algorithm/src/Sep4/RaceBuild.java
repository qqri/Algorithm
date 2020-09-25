package Sep4;

// 벗어나지 않아야 한다.
import java.util.*;

class Road {
    int x;
    int y;
    int cost;
    int dir;
    public Road(int x , int y , int cost, int dir) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }
}
class RaceBuild {
    static int map[][];
    static int ans = Integer.MAX_VALUE;
    static int dirs[][] = {{-1, 0} , {1 ,0 } , {0 , 1}, {0, -1}};
    public int solution(int[][] board) {
        map = board;
        bfs(0,0,0,-1);
        return ans;
    }

    public static void bfs(int x , int y , int cost , int dir) {

        Queue<Road> q = new LinkedList<>();
        map[x][y] = 1;
        q.offer(new Road(x,y,cost,dir));
        int n = map.length;

        while( !q.isEmpty() ) {
            Road tempRoad = q.poll();

            if(tempRoad.x == n-1 && tempRoad.y == n-1) {
                ans = Math.min( ans, tempRoad.cost);
                continue;
            }
            for(int i = 0; i < 4 ; i ++ ) {
                int curX = tempRoad.x + dirs[i][0];
                int curY = tempRoad.y + dirs[i][1];
                // 벗어나지 않아야 한다.
                while(curX>= 0 && curY>= 0 &&curX< map.length &&curY< map.length && map[curX][curY] != 1) {
                    int curCost = 0;
                    if(tempRoad.dir == i || tempRoad.dir == -1) curCost = tempRoad.cost + 100;
                    else curCost = tempRoad.cost + 600;

                    if( map[curX][curY] == 0 ) {
                        map[curX][curY] = curCost;
                        q.offer(new Road(curX , curY , curCost , i));
                    }else if(map[curX][curY] >= curCost ) { //이미 지났던 길이긴 한 경우
                        map[curX][curY] = curCost;
                        q.offer(new Road(curX , curY , curCost , i));
                    }

                }

            }
        }

    }
}
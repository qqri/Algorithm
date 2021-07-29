import java.util.*;
class Shark{
    int x,y,d;
    public Shark(int x, int y , int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
public class Main{
    static int n;
    static int[][] map;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        int startX=0, startY=0;
        for(int i = 0 ; i < n ; i++ ) {
            for(int j = 0 ; j < n ; j++ ) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 9) {
                    startX = i;
                    startY = j;
                }
            }
        }
        map[startX][startY] = 0;
        System.out.println(solve(startX , startY));
    }
    static int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    static int solve( int x, int y ) {
        int ret = 0;
        int cnt=2,size = 2;
        Shark minPt = new Shark(x,y,0);

        while(minPt.d != INF) {
            boolean[][] visit = new boolean[n][n];
            Queue<Shark> q = new LinkedList<>();
            q.offer(new Shark(minPt.x , minPt.y , 0) );
            visit[minPt.x][minPt.y] = true;
            minPt.d = INF;

            while( !q.isEmpty() ) {
                Shark curPt = q.poll();
                if(minPt.d < curPt.d) break;
                if(size < map[curPt.x][curPt.y]) continue; //지나갈수없음

                if(size > map[curPt.x][curPt.y] && map[curPt.x][curPt.y] != 0) {
                    if(minPt.d > curPt.d) {
                        minPt = curPt;
                    } else if(minPt.d == curPt.d) {
                        if(minPt.x > curPt.x) {
                            minPt = curPt;
                        } else if(minPt.x == curPt.x && minPt.y > curPt.y) {
                            minPt = curPt;
                        }
                    }
                    continue;
                }

                for(int[] dir : dirs) {
                    int dx = curPt.x + dir[0];
                    int dy = curPt.y + dir[1];

                    if( dx<0 || dx>n-1 || dy<0 || dy>n-1 ) continue;
                    if(visit[dx][dy]) continue;

                    q.offer(new Shark(dx, dy , curPt.d + 1 ));
                    visit[dx][dy] = true;
                }
            }

            if(minPt.d != INF) {
                ret += minPt.d;
                cnt--;
                if(cnt == 0) {
                    size++;
                    cnt = size;
                }
                map[minPt.x][minPt.y] = 0;
            }

        }

        return ret;
    }
}
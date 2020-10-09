import java.util.*;


public class Main {
    static int[][] map;
    static int INF = 98764543;
    static int[][] dirs = {{-1,0} , {1,0} , {0,1}, { 0,-1}};

    static class Point {
        int x, y, d;
        public Point(int x, int y , int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int solve(int x, int y) {
        int ret = 0;
        int cnt = 2, size =2 ;
        int n = map.length;
        Point minPt = new Point(x,y,0);

        while( minPt.d != INF ){
            boolean[][] visited = new boolean[20][20];
            Queue<Point> q = new LinkedList<>();
            visited[minPt.x][minPt.y] = true;
            q.offer(new Point(minPt.x , minPt.y , 0));
            minPt.d = INF;

            while( !q.isEmpty() ) {
                Point curPt = q.poll();  //1 최소값 갱신
                if( minPt.d < curPt.d ) break; //가장 작은 거리보다 멀어졌으므로 탐색할 필요없음.
                if( map[curPt.x][curPt.y] > size ) continue;
                if( map[curPt.x][curPt.y] != 0 && map[curPt.x][curPt.y] < size) {
                    if( curPt.d < minPt.d ) {
                        minPt = curPt;
                    } else if( curPt.d == minPt.d ){
                        if( curPt.x < minPt.x) {
                            minPt = curPt;
                        } else if( curPt.x == minPt.x && curPt.y < minPt.y) {
                            minPt = curPt;
                        }
                    }
                    continue;
                }

                //2 탐색함
                for(int[] dir : dirs) {
                    int dx = curPt.x + dir[0];
                    int dy = curPt.y + dir[1];
                    if(dx < 0 || dx > n-1 || dy < 0 || dy > n-1 ) continue;
                    if(visited[dx][dy]) continue;
                    visited[dx][dy] = true;
                    q.offer(new Point( dx , dy , curPt.d + 1 ));
                }
            }
            if( minPt.d != INF ) {
                ret += minPt.d;
                cnt--;
                if( cnt == 0 ) {
                    size++;
                    cnt = size;
                }
                map[minPt.x][minPt.y] = 0;
            }
        }

        return ret;
    }

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int startX = 0,startY = 0;
        map = new int[n][n];
        for(int i = 0 ; i < n ; i++ ) {
            for(int j = 0 ; j < n ; j++ ) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 9) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }

        // 시작
        System.out.println( solve(startX , startY ) );
    }


}
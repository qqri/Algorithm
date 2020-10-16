import java.util.*;
class Route{
    int x, y, d;//d는 거리
    public Route(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
class Customer{
    int x,y, endX,endY;
    public Customer(int x ,int y , int endX, int endY){
        this.x = x;
        this.y = y;
        this.endX = endX;
        this.endY = endY;
    }
}
public class Main{
    static int n,m,fuel;
    static int[][] map;
    static int INF = 987654321;
    static List<Customer> customers = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        fuel = sc.nextInt(); //연료

        map = new int[n][n];
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int startX , startY;
        startX = sc.nextInt() -1;
        startY = sc.nextInt() -1;

        //손님 정보
        for(int i = 0 ; i < m ; i++ ) {
            int x= sc.nextInt()-1;
            int y= sc.nextInt()-1;
            int endX= sc.nextInt()-1;
            int endY= sc.nextInt()-1;
            Customer customer = new Customer(x, y ,endX, endY);
            customers.add(customer);
        }
        // 시작점
        int ans = solve(startX , startY);
        System.out.println(ans);

    }
    static int solve(int tX , int tY){
        int idx, minStartD , minEndD;
        while( customers.size() != 0 ) {
            idx = 0; //처음 택시 위치
            minStartD = INF;

            // 1 택시 출발 위치에서 도착 위치 찾기
            for(Customer curr : customers) {
                if(tX == curr.x && tY == curr.y){
                    minStartD=0;
                    idx = customers.indexOf(curr);
                    break;
                }
                int curD = distance(tX ,tY , curr.x , curr.y );
                if( minStartD > curD ) {
                    minStartD  = curD;
                    idx = customers.indexOf(curr);
                }
            }
            if( minStartD >= fuel ) return -1;
            fuel -= minStartD;

            // 2 택시 손님태우고 도착위치로 가기
            Customer target = customers.get(idx);

            minEndD = distance(target.x , target.y , target.endX , target.endY );
            if( minEndD > fuel ) return -1;
            fuel += minEndD;
            tX = target.endX ;
            tY = target.endY ;

            customers.remove(idx);
        }

        return fuel;
    }

    static int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};

    static int distance(int startX, int startY ,int endX , int endY ) {
        // 출발 지점부터, 도착지점까지
        Route minPt = new Route( startX, startY , 0 );
        Queue<Route> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];
        q.offer(new Route(minPt.x , minPt.y , 0));
        visit[minPt.x][minPt.y] = true;
        minPt.d = INF;

        while(!q.isEmpty()) {
            Route curPt = q.poll();
            if(curPt.d > fuel) break;
            if(curPt.d > minPt.d) break;
            if(map[curPt.x][curPt.y] == 1 ) continue;
            if(curPt.x == endX && curPt.y == endY ) { // 도착 한 경우
                if(minPt.d > curPt.d) {
                    minPt = curPt;
                } else if(minPt.d == curPt.d) {
                    if( curPt.x < minPt.x ) {
                        minPt = curPt;
                    } else if ( curPt.x==minPt.x && curPt.y < minPt.y ) {
                        minPt = curPt;
                    }
                }
                continue;
            }

            for(int[] dir : dirs) {
                int dx = curPt.x + dir[0];
                int dy = curPt.y + dir[1];

                if(dx<0||dx>n-1||dy<0||dy>n-1) continue;
                if(visit[dx][dy]) continue;
                visit[dx][dy] = true;

                q.offer(new Route(dx , dy , curPt.d+1));
            }
        }
        return minPt.d;
    }
}
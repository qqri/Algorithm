import java.util.*;
class CCTV{
    int x , y , type;
    public CCTV(int x, int y , int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}
public class Main {
    static int n , m;
    static int[][] map;
    static List<CCTV> cctvlist = new ArrayList<>();
    static int min = 100;
    static int[] camType = {4,2,4,4,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        for(int i = 0 ; i < n ; i++ ) {
            for(int j = 0 ; j < m ; j++ ) {
                map[i][j] = sc.nextInt();
                if(map[i][j] != 0 && map[i][j] != 6) {
                    CCTV cctv = new CCTV(i , j , map[i][j]-1 );
                    cctvlist.add(cctv);
                }
            }
        }

        solve(0);
        System.out.println(min);
    }

    static void solve(int index) {
        if(index == cctvlist.size()) {
            int count = 0;
            for(int i = 0 ; i < n ; i++ ) {
                for(int j = 0 ; j < m ; j++ ) {
                    if(map[i][j] == 0) count++;
                }
            }
            min = Math.min(min , count);
            return;
        }

        CCTV cur = cctvlist.get(index);
        int type = cur.type;
        int[][] backup = new int[n][m];
        for(int i = 0 ; i < camType[type] ; i++ ) {
            copy(map, backup);
            switch(type) {
                case 0:
                    update(i,cur);
                    break;
                case 1:
                    update(i,cur);
                    update(i+2,cur);
                    break;
                case 2:
                    update(i,cur);
                    update(i+1,cur);
                    break;
                case 3:
                    update(i,cur);
                    update(i+1,cur);
                    update(i+2,cur);
                    break;
                case 4:
                    update(i,cur);
                    update(i+1,cur);
                    update(i+2,cur);
                    update(i+3,cur);
                    break;
            }
            solve(index+1);
            copy(backup, map);
        }
    }
    static void copy(int[][] src , int[][] dst) {
        for(int i = 0 ; i < n ; i++ ) {
            for(int j = 0 ; j < m ; j++ ) {
                dst[i][j] = src[i][j];
            }
        }
    }
    static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    static void update(int type , CCTV cctv) {
        type = type%4;
        int[] dir = dirs[type];
        int x =cctv.x , y = cctv.y;
        while(true) {
            x += dir[0];
            y += dir[1];
            if(x<0 || x>n-1 || y <0 || y > m-1 || map[x][y] == 6) break;

            map[x][y] = -1;
        }
        return;
    }

}
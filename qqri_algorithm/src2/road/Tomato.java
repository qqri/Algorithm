import java.util.*;

class xy {
    int x,y,day;
    public xy(int x,int y,int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }

}
public class Main {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] map;
    static int n, m;
    static int nonTmT = 0;
    static Queue<xy> curQ = new LinkedList<>(); //현재 큐에 넣음

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    curQ.offer(new xy(i, j, 0));
                } else if (map[i][j] == 0) {
                    nonTmT++;
                }
            }
        }
        System.out.println(solve());
    }
    static int solve() {
        int day=0;
        while (!curQ.isEmpty()) {
            xy cur = curQ.poll();
            day = cur.day;
            for(int[] dir : dirs) {
                int dx = cur.x + dir[0];
                int dy = cur.y + dir[1];
                if(dx >= 0 && dx < n && dy >=0 && dy < m && map[dx][dy] == 0) {
                    map[dx][dy] = 1;
                    curQ.offer(new xy(dx , dy , day+1));
                    nonTmT--;
                }
            }
        }
        if(nonTmT == 0) return day;
        else return -1;
    }

}

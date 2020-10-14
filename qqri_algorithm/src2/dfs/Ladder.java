import java.util.*;
public class Sol2{
    static int N,M,H;
    static int[][] Ladder = new int[30][10]; //주의
    static final int Right = 1;
    static final int Left = 2;
    static final int INF = Integer.MAX_VALUE;

//pos 를 이용한 방식 -> 순서대로 간다.
    static boolean check() {
        for (int i = 0 ; i < N ; ++i ) {
            int row = 0 , col = i;
            while( row != H ) {
                if(Ladder[row][col] == Left ) --col;
                else if( Ladder[row][col] == Right ) ++ col;

                ++row;
            }
            if(col != i) return false;
        }
        return true;
    }

    static int solve( int pos, int cnt ){
         // 인덱스 , 가로줄의 개수
        if(cnt == 3 || pos >= N*H) {
            if( check()) return cnt;
            return INF;
        }

        int ret = INF; // 최소값을 찾아야 하므로 무한대로 일단 놓는다.
        int row  = pos / N , col = pos % N;
        // 가로선 넣는 경우
        if(col != N-1 && Ladder[row][col] == 0 && Ladder[row][col+1] == 0) {
            Ladder[row][col] = Right;
            Ladder[row][col+1] = Left; //오른쪽 좌표도 바뀌니까 +1 이 아니라 +2 가 된다.
            ret = Math.min(ret, solve(pos+2, cnt+1));
            Ladder[row][col] = Ladder[row][col+1] =0;
        }
        // 가로선 안 넣는 경우
        ret = Math.min( ret ,solve( pos +1 , cnt) );
        return ret;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();
        for(int i=0 ; i < M ; i++ ) {
            int a,b;
            a = sc.nextInt();
            b = sc.nextInt();
            Ladder[a-1][b-1] = Right;
            Ladder[a-1][b] = Left;
        }

        int ans = solve(0 , 0);

        if( ans == INF) System.out.println(-1);
        else System.out.println(ans);

    }
}


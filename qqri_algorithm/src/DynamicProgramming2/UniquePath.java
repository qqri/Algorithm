package DynamicProgramming2;

public class UniquePath {

    public static void main(String[] args) {

        int m , n;
        m = 3;
        n = 7;
        UniquePath u = new UniquePath();

        System.out.println(u.solve(m,n));
    }
    // 그냥 각각 더해서 풀리
    int solve(int m, int n) {
        int[][] map = new int[n][m];

        for(int i = 0 ; i < n ; i++ ) {
            map[i][0] = 1;
        }
        for(int i = 0 ; i < m ; i++ ) {
            map[0][i] = 1;
        }

        for(int i = 1 ; i < n ; i++ ) {
            for(int j = 1; j < m ; j++ ) {
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }

        return map[n-1][m-1];
    }

    // 수열 이용
    int solve1(int m , int n ) {

        int  up =1 ,d1 =1 , d2=1;

        for(int i = m+n-2; i > 0; i --) {
            up *= i;
        }
        for(int i = m-1 ; i > 0 ; i-- ) {
            d1 *= i;
        }
        for(int i = n-1 ; i > 0 ; i-- ) {
            d2 *= i;
        }
        return up / (d1*d2) ;
    }
}

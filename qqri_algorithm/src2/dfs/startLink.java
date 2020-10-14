import java.util.*;
public class Main {
    static int n;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for(int i = 0 ; i < n ; i++ ) {
            for(int j = 0 ; j < n ; j++ ) {
                map[i][j] = sc.nextInt();
            }
        }
        boolean[] visit = new boolean[n];
        computation( n , n/2 , 0 , visit );
        System.out.println(solve());
    }
    static int solve() {
        int[] currArr;
        int[] team1 = new int[n/2];
        int[] team2 = new int[n/2];

        for(int i = 0 ; i < list.size() ; i++ ) {
            currArr = list.get(i);
            int team1Size=0, team2Size=0;
            for(int j = 0 ; j < n ; j++ ) {
                if(currArr[j] == 1) {
                    team1[team1Size] = j;
                    team1Size++;
                } else {
                    team2[team2Size] = j;
                    team2Size++;
                }
            }

            int sum1 = 0 , sum2 = 0;

            for(int k = 0 ; k < n/2 ; k++ ) {
                for(int l = k ; l < n/2 ; l++) {
                    sum1 += map[team1[k]][team1[l]] + map[team1[l]][team1[k]];
                    sum2 += map[team2[k]][team2[l]] + map[team2[l]][team2[k]];
                }
            }
            min = Math.min(min, Math.abs(sum1-sum2));
        }


        return min;
    }

    static void computation(int n , int r , int start , boolean[] visit) {
        if( r == 0 ) {
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++ ) {
                if(visit[i]) {
                    arr[i] = 1;
                }
            }
            list.add(arr);
            return;
        }

        for(int i = start ; i < n ; i++ ) {
            visit[i] = true;
            computation(n , r-1 , i+1 , visit);
            visit[i] = false;
        }
    }
}
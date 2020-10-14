import java.util.*;
public class Main {
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chiArr = new ArrayList<>();
    static int[][] map;
    static int n;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n개 줄
        int m = sc.nextInt(); // m개 줄

        map = new int[n][n];

        for(int i=0 ; i < n ; i++ ) {
            for(int j = 0 ; j < n ; j++ ) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2) {
                    int[] chi = new int[2];
                    chi[0] = i;
                    chi[1] = j;
                    chicken.add(chi);
                }
                if(map[i][j] == 1) {
                    int[] hou = new int[2];
                    hou[0] = i;
                    hou[1] = j;
                    house.add(hou);
                }
            }
        }

        boolean[] visit = new boolean[chicken.size()];
        computation( chicken.size() ,m,0,visit);

        for(int i = 0 ; i < chiArr.size() ; i++ ) {
            min = Math.min( min, distance(chiArr.get(i)) );
        }

        System.out.println(min);

    }

    static int distance(int[] compArr) {
        int houSize = house.size();
        int chiSize = chicken.size();
        int[] currHou;
        int[] currChi;

        int hx=0, hy =0 , cx = 0, cy =0 , currD, currSum = 0 ;
        for(int i = 0 ; i < houSize ; i++ ) {
            currHou = house.get(i);
            hx = currHou[0];
            hy = currHou[1];
            currD = 987654321;
            for(int j = 0 ; j < chicken.size() ; j++ ) {
                if(compArr[j] == 1) {
                    currChi = chicken.get(j);
                    cx = currChi[0];
                    cy = currChi[1];
                    currD = Math.min( currD , Math.abs(hx-cx)+Math.abs(hy-cy));
                }
            }
            currSum += currD;
        }

        return currSum;
    }

    static void computation(int n , int r, int start , boolean[] visit) {
        if( r== 0) {
            int[] arr  = new int[n];
            for(int i = 0 ; i < n ; i++ ) {
                if(visit[i]) {
                    arr[i] = 1;
                }
            }
            chiArr.add(arr);
        }
        for(int i = start ; i < n ; i++ ) {
            visit[i] = true;
            computation( n , r-1 , i+1 , visit);
            visit[i] = false;
        }
    }

}
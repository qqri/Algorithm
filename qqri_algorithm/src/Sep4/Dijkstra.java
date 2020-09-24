package Sep4;
import java.util.*;


public class Dijkstra {
    public static int n;
    public static int[][] grid;

    public static void main(String[] args) {
        int maps[][] = {{1,2,3},{1,5,4} , {1,4,4},
                {2,3,2}, {3,4,1}, {4,5,2} , {5,6,4},
                {4,7,6}, {7,6,3}, {3,8,3}, {6,8,2}};

        n = 8;
        grid = new int[n+1][n+1];

        for(int i = 0 ; i < maps.length ; i++ ) {
            int row = maps[i][0];
            int col = maps[i][1];
            int val = maps[i][2];
            grid[row][col] = val;
            grid[col][row] = val;
        }


        int[] ans = dijkstra(1);

        for(int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] dijkstra(int v) {
        int[] dist = new int[n+1];
        boolean[] check = new boolean[n+1];
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[v] = 0;
        check[v] = true;

        //바로 연결된거 이런식으로 변경함.
        for(int i =1 ; i < n+1 ; i++) {
            if( !check[i] && grid[v][i] != 0 ) {
                dist[i] = grid[v][i];
            }
        }

        for(int k = 0 ; k < n-1 ; k++ ) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;

            for(int i = 1 ; i < n+1 ; i++ ) {
                if( !check[i] && dist[i] != Integer.MAX_VALUE ) {
                    if( dist[i] < min ) {
                        min = dist[i];
                        minIdx = i;
                    }
                }
            }
            check[minIdx]= true;

            for(int i = 1 ; i < n+1 ; i++ ) {
                if( !check[i] && grid[minIdx][i] != 0 ) {
                    if( dist[i] > dist[minIdx] + grid[minIdx][i] ) {
                        dist[i] = dist[minIdx] + grid[minIdx][i];
                    }
                }
            }
        }

        return dist;
    }


}

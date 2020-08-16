package Graph;
//쓸데없이 복잡하게 푼거같다 ㅠㅠ
import java.util.*;
class Network {
    public static void main(String[] args) {

        //System.out.println(solution(	3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        System.out.println(solution(4, new int[][] {{1, 0, 0, 1}, {0, 1, 1, 1}, {0, 1, 1, 0}, {1, 1, 0, 1}}));
    }
    public static int solution(int n, int[][] computers) {
        //1
        int num = 0;
        boolean visited[] = new boolean[n];
        //num++;

        for(int i = 0 ; i < n ; i++) { //행
            if(visited[i] == true ) continue;
            num++;
            visited[i] = true;
            for(int j = i+1 ; j < n ; j++ ) { //열
                if( computers[i][j] == 1 ) {
                    visited[j] = true;
                    dfs(computers, visited, j);
                }
            }
        }

        return num;
    }

    public static void dfs(int[][] computers, boolean[] visited ,int cur) {
        for(int u = 0 ; u < computers.length ; u++ ) {
            if(u == cur) continue;

            if(visited[u] == true) continue;

            if(computers[cur][u] == 1 ) {
                visited[u] = true;
                dfs(computers, visited, u);
            }
        }
    }

}
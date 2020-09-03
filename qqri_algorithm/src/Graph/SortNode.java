package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SortNode {
    public static void main(String[] args) {
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        solution(5 , results);
    }
    public static void solution(int n , int[][] results ) {
        //1
        List<List<Integer>> winGraph = new ArrayList<>();
        List<List<Integer>> loseGraph = new ArrayList<>();

        int[] winVal = new int[n+1];
        int[] loseVal = new int[n+1];
        boolean[] loseVisited = new boolean[n+1];
        boolean[] winVisited = new boolean[n+1];

        for(int i = 0 ; i < n+1 ; i++ ) {
            winGraph.add(new ArrayList<Integer>());
            loseGraph.add(new ArrayList<Integer>());
        }
        // 0 이 이긴거 , 1 이 진거
        for(int i = 0 ; i < results.length ; i++ ) {
            winGraph.get( results[i][1] ).add(  results[i][0] ); // 진 애들이 이긴 가리킴
            loseGraph.get( results[i][0] ).add( results[i][1] ); // 이긴애들이 진 가리킴

            winVal[ results[i][0] ]++; // 이긴횟수 입력
            loseVal[ results[i][1] ]++; // 진횟수 입력
        }

        winVal = bfs( winVal , winGraph , winVisited );
        loseVal= bfs( loseVal , loseGraph , loseVisited );

        int cnt= 0;
        for(int i = 1 ; i <= n ; i++ ) {
            if(winVal[i] + loseVal[i] >= n-1) cnt++;
            System.out.println(winVal[i] + loseVal[i]);
        }
        System.out.println("answer : " + cnt);
    }



    public static int[] bfs(int[] val, List<List<Integer>> graph , boolean[] visited ) {
        Queue<Integer> que = new LinkedList<>();

        for(int i = 0 ; i < val.length ; i++ ) {
            if(val[i] == 0) {  que.offer(i); }
            while(!que.isEmpty()) {
                int cur = que.poll();
                visited[cur] = true;
                for(int k : graph.get(cur)) {
                    if(!visited[k] ) val[k] += val[cur];
                    if(!que.contains(k) && !visited[k] ) que.offer(k);
                }
            }
        }

        return val;
    }
}

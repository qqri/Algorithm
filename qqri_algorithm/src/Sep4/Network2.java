package Sep4;

import java.util.*;

public class Network2 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();


        for(int i = 0 ; i < n ; i++ ) {
            for(int j = 0 ; j < n ; j++ ) {
                if(computers[i][j] == 1) {
                    if( !map.containsKey(i) ) {
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        map.put(i , list);
                    } else {
                        map.get(i).add(j);
                    }
                }
            }
        }

        answer = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++) {
            if( visited[i] ) continue;
            q.offer(i);

            while(!q.isEmpty() ) {
                int cur = q.poll();
                visited[cur] = true;
                if( map.containsKey(cur) ) {
                    List<Integer> curList = map.get(cur);
                    for(int j : curList) {
                        if( visited[j] ) continue;
                        else q.offer(j);
                    }
                }
            }
            ++answer ;
        }


        return answer;

    }
}

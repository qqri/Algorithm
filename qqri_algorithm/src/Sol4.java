import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

class Sol4 {
    static List<Node>[] list;
    private static final int INF = 100_000_000;
    private static int num;
    static int[] dist;

    public static void main(String[] args) {

        int[][] fares = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
        System.out.println( solution(7 , 3, 4, 1  ,fares) );

    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        // { c , d, f } : c와 d 사이 요금 f 다.
        // 둘다 같이 출발 s , 각각 도착지점 a , b ;
        // 정점수: n개의  간선 수 : fares
        num = n;
        list = new ArrayList[n + 1]; // 정점 수
        dist = new int[n + 1];

        Arrays.fill(dist, INF);
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        // 리스트에 그래프 정보를 초기화
        for(int i = 0 ; i < fares.length ; i++){
            int end = fares[i][1];
            int weight = fares[i][2];
            // start에서 end로 가는 weight 가중치
            list[fares[i][0]].add(new Node(end, weight));
        }
        for(int i = 0 ; i < fares.length ; i++){
            int end = fares[i][0];
            int weight = fares[i][2];
            // start에서 end로 가는 weight 가중치
            list[fares[i][1]].add(new Node(end, weight));
        }

        //2
        dijkstra(s);
        System.out.println(dist[4]);

        return   Math.min(dist[a] + dist[b] , solve(s,a,b) );

    }

    private static void dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[num + 1];
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int cur = curNode.end;

            if(check[cur] == true) continue;
            check[cur] = true;

            for(Node node : list[cur]){

                if( dist[node.end] > dist[cur] + node.weight){
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new Node(node.end, dist[node.end]));
                }
            }

        }
    }

    private static int solve(int start , int required1, int required2){
        int result1 = 0;
        int result2 = 0;

        // 경로1
        // 1 -> 필수1 최단거리
        result1 += dijkstra2(start, required1 );
        // 필수1 -> 필수2 최단거리
        result1 += dijkstra2(required1, required2 );

        //경로2
        // 1 -> 필수2 최단거리
        result2 += dijkstra2(start, required2);
        // 필수2 -> 필수1 최단거리
        result2 += dijkstra2(required2, required1);

        // 경로1 && 경로2 -> 가는길이 없는 경우
        return Math.min(result1, result2);
    }

    private static int dijkstra2(int start, int end){
        boolean[] check = new boolean[num + 1];
        int[] distSum = new int[num+1];

        Arrays.fill(distSum, INF);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        distSum[start] = 0;

        while (!queue.isEmpty()){
            Node curPoint = queue.poll();
            int curNode = curPoint.end;
            int curWeight = curPoint.weight;

            if(check[curNode] == true) continue;
            check[curNode] = true;

            for(int i = 0; i < list[curNode].size(); i++){
                int nextNode = list[curNode].get(i).end;
                int nextWeight = list[curNode].get(i).weight;
                // 미방문 && 기존의 계산된 거리보다 새로운 거리가 작을 경우
                if(check[nextNode] == false && distSum[nextNode] > curWeight + nextWeight){
                    distSum[nextNode] = curWeight + nextWeight;
                    queue.add(new Node(nextNode, distSum[nextNode]));
                }
            }
        }
        return distSum[end];
    }


}
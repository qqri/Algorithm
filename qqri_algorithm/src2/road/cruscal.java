import java.util.*;

class edge implements Comparable<edge>{
    int start,end,val;
    public edge(int start, int end , int val) {
        this.start = start;
        this.end = end;
        this.val = val;
    }

    @Override
    public int compareTo(edge e) {
        return this.val - e.val; //val 에 대해 오름차순 정렬 
    }
}

public class Main{
    static int n,m;
    static int[] parent;
    static PriorityQueue<edge> pq = new PriorityQueue<edge>();
    static int res = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt(); //정점 개수
        int e = sc.nextInt(); //간선 개수

        parent = new int[v+1];
        for(int i=0; i < v+1 ; i++) {
            parent[i] = i;
        }
        int start, end, val;
        for(int i = 0 ; i < e ; i ++ ) {
            start = sc.nextInt();
            end = sc.nextInt();
            val = sc.nextInt();
            pq.add(new edge(start, end , val));
        }

        for(int i = 0 ; i < e ; i++ ) {
            edge temp = pq.poll();
            int a = find(temp.start);
            int b = find(temp.end);

            if(a==b) continue; // 부모가 같으면 사이클 생기는 거니까 넘어감

            union(a , b);

            res += temp.val;
        }

        System.out.println(res);

    }

    //부모찾기 - parent[a] 가 목표다.
    static int find( int a ) {
        if(a == parent[a]) return a;
        parent[a] = find( parent[a] );
        return parent[a];
    }

    // 부모 연결
    static void union(int a , int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot  != bRoot ) {
            parent[aRoot] = b;
        } else {
            return;
        }
    }
}
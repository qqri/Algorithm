package StringArray;

import java.io.IOException;
import java.util.*;

class plane{
    int x;
    int y;
    int len;
    public plane(){
        this.x = 0;
        this.y = 0;
        this.len = 0;
    }
    public plane(int x, int y, int len) {
        this.x =x;
        this.y = y;
        this.len = y;
    }
}

public class KClosestPointstoOrigin {
    public static void main(String[] args) throws NumberFormatException, IOException {
        KClosestPointstoOrigin kl = new KClosestPointstoOrigin();
        plane p1 = new plane(1,3,0);
        plane p2 = new plane(2,-2,0);

        List<plane> planes = new ArrayList<>();
        planes.add(p1);
        planes.add(p2);

        int k = 1;

        plane ans = kl.solve1(planes , 2);
        //System.out.println( ans.x + " , " + ans.y );
        //문제 이해를 잘못했었음. 우선 가장 짧은 길이를 구하는 것이고, k가 의미하는건 k개 까지 구하란 소리임.

        System.out.println("===========2==========");


        int[][] points = {{ 1,3} , {-2,2}};

        int[][] result = kl.solve(points, 1);

        for(int i = 0 ; i < result.length ; i++) {
            System.out.println( result[i][0] + " , " + result[i][1] );
        }

    }
    // 방법 1
    Comparator< int[] > Comp = new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]);
        }
    };

    public int[][] solve(int [][] points, int k) {
        //que 갯수는 포인터리스트 행 수 만큼, 우선순위 큐 이므로 다음과 같은 방식으로 정렬
        //1. Comp 사용
        //Queue<int[]> queue = new PriorityQueue<>(points.length , Comp);
        //2. 람다식
        Queue<int[]> queue = new PriorityQueue<>( (a,b) -> ( (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]) ) );
        int index = 0 ;
        int[][] result = new int[k][2];

        //이러면 알아서 p 넣어 질것.
        for(int[] p : points) {
            queue.offer(p);
        }

        while (index < k) {
            result[index] = queue.poll();
            index++;
        }

        return result;
    }


    // 방법 2
    Comparator<plane> Comp2 = new Comparator<plane>() {
        @Override
        public int compare(plane o1, plane o2) {
            return o1.len-o2.len; //오름차순 정렬
        }
    };

    public plane solve1(List<plane> planes, int k) {

        for(int i = 0 ; i < planes.size() ; i++ ) {
            plane current = planes.get(i);

            int leng = (int) (Math.sqrt(current.x) + Math.sqrt(current.y));
            current.len = leng;

        }

        Collections.sort(planes, Comp2);
        plane plAns = planes.get( k-1 );
        return  plAns;
    }


}

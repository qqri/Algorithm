package Sep2;

import java.util.LinkedList;
import java.util.Queue;

class ThrouTruck {
    int w ;
    int pos;

    public ThrouTruck(int w, int pos) {
        this.w = w;
        this.pos = pos;
    }
}
public class Truck {
    // 모든 트럭이 다리 건너려면 몇초 걸리는지
    // 트럭은 1초에 1 , 다리길이는 b-l 이고 무게는 w까지 견딤
    // 하나가 다 지날 때 까지 1 만큼 지난다.
    // 일차선 이므로 하나 갈 때 하나만 들어 갈 수있다.

    //시간 차이 나는거 기준 따지기가 힘들었음
    // 0으로 진입하니까 w 차이나도 w+1이란거 알기
    public static void main(String[] args) {

        System.out.println( solve( 2,10,new int[] {7,4,5,6} ) );
        System.out.println( solve( 100,100,new int[] {10} ) );
        System.out.println( solve( 100,100 ,new int[] {10,10,10,10,10 , 10,10,10,10,10} ) );
    }                           //다리 길이      // 다리 무게       // 트럭무게들
    public static int solve(int bridgeLength , int weight , int[] truckWeight) {
        Queue<ThrouTruck> waiting = new LinkedList<>();
        Queue<ThrouTruck> bridge = new LinkedList<>();

        int answer = 0 , totalW = 0 ;

        for(int i : truckWeight) {
            waiting.add( new ThrouTruck( i , 1 ));
        }

        while( !waiting.isEmpty() || !bridge.isEmpty() ) { // 둘다 비면 끝난다!
            answer ++;

            if( !bridge.isEmpty() ) {
                timeGone(bridge);
                ThrouTruck pre = bridge.peek(); // 다리에서 가장 앞에 있는 트럭 뽑는다.
                if( pre.pos > bridgeLength ) {
                    bridge.poll();
                    totalW -= pre.w;
                }
            }

            if( !waiting.isEmpty() ) { //대기 중인 트럭이 있다.
                ThrouTruck current = waiting.peek(); // 가장 앞에서 대기중인 트럭 하나 뺀다.
                if (totalW + current.w <= weight) {
                    waiting.poll();
                    bridge.offer(current);
                    totalW += current.w;
                }
            }

        }

        return answer;
    }

    public static void timeGone(Queue<ThrouTruck> que) {
        int size = que.size();

        for(int i = 0 ; i < size ; i++ ) {
            ThrouTruck t = que.poll();
            t.pos++;
            que.offer(t);
        }
    }
}

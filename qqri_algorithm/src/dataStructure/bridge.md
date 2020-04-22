# 문제
[프린트 문제](https://programmers.co.kr/learn/courses/30/lessons/42583)
<br>출처 : 프로그래머스
<br><br>
우선 다리에서 지나야 하는게 먼저인데, 대기열에 넣는 것 부터 해서 틀린 답이 계속 나왔다.

# 코드
```java
import java.util.*;

class Solution {
    class Truck {
        int weight;
        int enterTime;
        Truck(int weight, int enterTime){
            this.weight = weight;
            this.enterTime = enterTime;
        }
    }
    public int solution(int length, int weight, int[] truck_weights) {

        Queue<Truck> waiting = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();

        for(int i = 0 ; i < truck_weights.length ; i++ ) {
            waiting.offer( new Truck(truck_weights[i] , 0));
        }

        int answer = 0;
        int totalW = 0;

        while( !waiting.isEmpty() || !bridge.isEmpty() ) {
            answer++;

            if( !bridge.isEmpty() ) {
                Truck t = bridge.peek();
                if( answer - t.enterTime >= length ) {
                    bridge.poll();
                    totalW -= t.weight;
                }
            }
            if( !waiting.isEmpty() ) {
                if( totalW + waiting.peek().weight <= weight) {
                    Truck t  = waiting.poll();
                    bridge.offer(new Truck( t.weight , answer ));
                    totalW += t.weight;

                }
            }

        }

        return answer;
    }
}
```
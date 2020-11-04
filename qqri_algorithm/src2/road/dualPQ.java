import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] arguments) {
        int[] answer = {0,0};

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        PriorityQueue<Integer> reverse_pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0; i<arguments.length; i++) {
            String temp[] = arguments[i].split(" ");
            switch(temp[0]) {
                case "I" :
                    pq.add(Integer.parseInt(temp[1]));
                    reverse_pq.add(Integer.parseInt(temp[1]));
                    break;
                case "D" :
                    if(pq.size() > 0) {
                        if(Integer.parseInt(temp[1]) == 1) {
                            // 최댓값 삭제
                            int max = reverse_pq.poll();
                            pq.remove(max);
                        } else {
                            // 최솟값 삭제
                            int min = pq.poll();
                            reverse_pq.remove(min);
                        }
                    }
                    break;
            }
        }

        if(pq.size() >= 2) {
            answer[0] = reverse_pq.poll();
            answer[1] = pq.poll();
        }

        System.out.println(answer[0] + ":" + answer[1]);

        return answer;
    }
}
package QueueNStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class DevelopFunc {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //1
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap();

        //2
        for(int i =0 ; i < speeds.length ; i++ ) {
            int deploy =  ((100-progresses[i])/speeds[i]);

            if( ((100-progresses[i])%speeds[i]) != 0 ) {
                deploy++;
            }
            if(i == 0 ){
                st.push(deploy);
                continue;
            }

            if(st.peek() <  deploy) {
                st.push( deploy ); //남은 날짜 되는 기간
            }
            else{
                st.push(st.peek());
            }

        }

        while(!st.isEmpty()) {
            int cur = st.pop();
            map.put(cur, map.getOrDefault(cur,0)+1 );
        }

        Iterator<Integer> iter = map.keySet().iterator();

        int[] answer = new int[map.size()];
        for(int i=0; i < map.size() ; i++ ) {
            answer[i] = map.get(iter.next());
        }
        return answer;

    }
}

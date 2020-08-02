package QueueNStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class DevelopFunc {
    public static void main(String[] args) {

    }
}
class Solution1 {
    public int[] solution(int[] progresses, int[] speeds) {
        //1
        Stack<Integer> st = new Stack<>();
        int[] day = new int[progresses.length];
        //2
        for (int i = 0; i < progresses.length; i++) {
            int deploy = (100 - progresses[i]) / speeds[i];

            if (((100 - progresses[i]) % speeds[i]) != 0) {
                deploy++;
            }
            day[i] = deploy;
        }
        int cnt = 1;
        int max = day[0];
        st.push(1);
        /*
            5 5 5 // 21 25 20
            95 95 95
            5 4 5
        */
        for (int i = 1; i < day.length; i++) {
            if (day[i] <= max) {
                cnt++;
                st.pop();
                st.push(cnt);
            } else {
                cnt = 1;
                st.push(cnt);
                max = day[i];
            }
        }
        int size = st.size();
        int[] answer = new int[st.size()];
        for (int i = size - 1; i >= 0; i--) {
            answer[i] = st.pop();
        }
        return answer;

    }

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            //1
            Stack<Integer> st = new Stack<>();
            Map<Integer, Integer> map = new HashMap();

            //2
            for (int i = 0; i < speeds.length; i++) {
                int deploy = ((100 - progresses[i]) / speeds[i]);

                if (((100 - progresses[i]) % speeds[i]) != 0) {
                    deploy++;
                }
                if (i == 0) {
                    st.push(deploy);
                    continue;
                }

                if (st.peek() < deploy) {
                    st.push(deploy); //남은 날짜 되는 기간
                } else {
                    st.push(st.peek());
                }

            }

            while (!st.isEmpty()) {
                int cur = st.pop();
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }

            Iterator<Integer> iter = map.keySet().iterator();

            int[] answer = new int[map.size()];
            for (int i = 0; i < map.size(); i++) {
                answer[i] = map.get(iter.next());
            }
            return answer;

        }
    }
}

# 문제
[프린트 문제](https://programmers.co.kr/skill_checks/)
<br>출처 : 프로그래머스
<br> Level2

# 코드
```java
//1
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek().equals(c)) stack.pop();
            else stack.push(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}


//2
import java.util.*;
//주의 몇 번째 이니까 인덱스 +1 로 저장해야됨.

class Solution {
    public int[] solution(int[] heights) {
        int len = heights.length;
        int[] answer = new int[len];

        for(int i = len - 1; i > 0 ; i-- ) {
            for(int j = i-1 ; j >= 0 ; j-- ) { //j가 더 옆에 있는
                if( heights[i] < heights[j] ) {
                    answer[i] = j+1;
                    break;
                }
            }
        }

        return answer;
    }
}


```
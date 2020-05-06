# 문제
[k번째 수](https://programmers.co.kr/learn/courses/30/lessons/42748)
<br>출처 : 프로그래머스
<br>기본적인 배열문제
<br>
# 코드

```java
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0 ; i < commands.length ; i++) {
            ArrayList<Integer> ans = new ArrayList<>();
            for(int j =commands[i][0]-1 ; j< commands[i][1] ; j++) {
                ans.add(array[j]);
            }
            Collections.sort(ans);
            answer[i]=ans.get(commands[i][2]-1);
        }

        return answer;
    }
}
```
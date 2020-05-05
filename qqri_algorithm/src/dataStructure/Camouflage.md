# 문제
[위장 문제](https://programmers.co.kr/learn/courses/30/lessons/42578)
<br>출처 : 프로그래머스
<br><br>
해시맵 잘 알고있으면 쉬운문제

# 코드
```java
import java.util.*;
//(3 * 2 -1)
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String,Integer> map = new HashMap<>();

        for(int i=0 ; i<clothes.length ; i++ ) {
            String kind = clothes[i][1];
            if( !map.containsKey(kind)) { //없다면 새로 저장
                map.put(kind,1);
            }
            else {
                int j = map.get(kind) + 1;
                map.put(kind,j);
            }
        }

        Set<String> set = map.keySet();
        for(String str : set) {
            answer = answer * (map.get(str)+1);
        }
      //  System.out.println(map);
        return answer-1;
    }
}
```
# 문제
[논문 인용 문제](https://programmers.co.kr/learn/courses/30/lessons/42747)
<br>출처 : 프로그래머스
<br> 문제이해하는데에 너무 시간이 오래걸렸다

# 코드
```java
import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for(int i=0 ; i < citations.length ; i++ ) {
            int index = citations[i];
            int cnt = 0;

            for(int j=0; j < citations.length ; j++ ) {
                if( (i+1) <= citations[j] ) cnt++;
            }
            if( (i+1) <= cnt)  answer = i+1;
        }

        return answer;
    }
}
```
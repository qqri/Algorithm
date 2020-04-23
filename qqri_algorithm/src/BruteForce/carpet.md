# 문제
[프린트 문제](https://programmers.co.kr/learn/courses/30/lessons/42842?language=java)
<br>출처 : 프로그래머스
<br><br>
다른풀이 2가 더 직관적이고 red와 brown 관계가 바로 보이는 것 같아 더 좋다.

# 코드
```java
import java.util.LinkedList;
//풀이 1
class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int height, width;
        int sum = brown+red;

        for(int i = 1 ; i <= brown/2 ; i++) {
            if( sum%i != 0 ) continue;

            height = i;
            width = sum/i;
            if( (width-2)*(height-2) == red ) {
                answer[0] = width;
                answer[1] = height;
            }
        }

        if(answer[0] < answer[1]) {
            int temp = answer[0];
            answer[0] = answer[1];
            answer[1] = temp;
        }
        return answer;
    }
}

//풀이 2

class Solution {
    public int[] solution(int brown, int red) {
        for(int i=1; i<=red; i++) {
            if(red%i==0 && (red/i+i)*2+4==brown) {
                return new int[] {red/i+2, i+2};
            }
        }
        return null;
    }
}
```
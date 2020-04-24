# 문제
[숫자야구](https://programmers.co.kr/learn/courses/30/lessons/42841#)
<br>출처 : 프로그래머스
<br><br>
처음에 설마 했는데 진짜 완전탐색 해야만 풀 수 있었다.<br>
고민 해보고 안되면 완전탐색할 수도 있다는 것을 알아야 겠다.

# 코드
```java
import java.util.*;

class Solution {
    public int solution(int[][] baseball) {
        ArrayList<Integer> ans = new ArrayList();

        for(int i=1 ; i <=9 ; i++) {
            for(int j =1 ; j <= 9 ; j++ ) {
                if(i == j) continue;
                for(int k=1 ; k <= 9 ; k++ ) {
                    if( i==k || k==j) continue;

                    ans.add( i*100 + j*10 + k );
                }
            }
        }

        int strike, ball;

        for(int i = 0 ; i < baseball.length ; i++ ) { // 몇 행인지 확인
            for(int k = 0 ; k < ans.size() ; k++ ){

                strike = 0;
                ball = 0;

                //strike 비교
                if(baseball[i][0]/100 == ans.get(k)/100) strike++;
                if((baseball[i][0]%100)/10 == (ans.get(k)%100)/10 ) strike++;
                if(baseball[i][0]%10 == ans.get(k)%10) strike++;

                //ball 비교
                 if((baseball[i][0]/100==(ans.get(k)%100)/10) || (baseball[i][0]/100==ans.get(k)%10) ) {
                     ball++;
                 }
                 if((baseball[i][0]%100/10==(ans.get(k)/100) || (baseball[i][0]%100/10==ans.get(k)%10))) {
                     ball++;
                 }
                 if((baseball[i][0]%10==(ans.get(k)/100) || (baseball[i][0]%10 == (ans.get(k)%100)/10))) {
                     ball++;
                 }

                 if( ! ((strike == baseball[i][1])&&(ball == baseball[i][2])) ) {
                     ans.set(k,0);
                 }

            }
        }
        int answer = 0;
        for(int i = 0 ; i < ans.size() ; i++ ){
            if(ans.get(i) != 0 ) answer++;
        }


        return answer;
    }
}
```
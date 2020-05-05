# 문제
[프린트 문제](https://programmers.co.kr/learn/courses/30/lessons/64061)
<br>출처 : 프로그래머스

# 코드 풀이1 - arraylist 사용
```java
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        ArrayList<Integer> ans = new ArrayList<>();
        int answer = 0;

        for(int i = 0 ; i < moves.length ; i++ ) {
            for(int j = 0 ; j < board.length ; j++) {
                if(board[j][ moves[i]-1 ] == 0 ) continue;
                else{
                    ans.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }


 //1 . 인형 터지는 경우 확인하는 방법
        boolean flag = true;

        while (flag) {
            for (int i=0;i <ans.size()-1;i++) {
               if( ans.get(i) == ans.get(i+1) ) {
                      answer=answer+2;
                      ans.remove(i +1);
                      ans.remove(i);
                      break;
                }
            }
            flag = false;

            //지워진 상태에서 한번 더 돌면서 조사한다.
            for(int i=0 ;i<ans.size()-1; i++) {
                if(ans.get(i) == ans.get(i+1) ) {
                    flag=true;
                }
            }
        }

// 2. while true 안하고 하는 방법
        for(int i = 0 ; i < ans.size() ; i++ ) {
            if(i != (ans.size()-1 ) ) {
                if( ans.get(i) == ans.get(i+1) ){
                    ans.remove(i);
                    ans.remove(i);
                    answer = answer + 2;
                    k =- 1;
                }
            }
        }

        return answer;
    }
}
```

# 코드 2 - stack 사용
```java
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                    if (board[j][move - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else
                        stack.push(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
```


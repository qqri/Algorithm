# 문제
[프린트 문제](https://programmers.co.kr/learn/courses/30/lessons/42584)
<br>출처 : 프로그래머스

# 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {
    public static String sol[];
    public static int delivery[][] = new int[6][3];
    public static int n;
    public static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
        Scanner sc = new Scanner(System.in);
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0 ; i < prices.length ; i++ ){
            answer[i] = 0;
        }

        //q에 우선 모두 넣음
        Queue q = new LinkedList();

        for(int price : prices){
            q.add(price);
        }

        while( !q.isEmpty()) {
            int num = q.poll();
            for(int i = 1 ; i < prices.length ; i++ ){
                if( num < prices[i] ) { // q가 더 크다면
                    answer[i] += 1;
                }
            }
        }


        return answer;
    }
}



```
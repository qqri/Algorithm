# 문제
[프린트 문제](https://programmers.co.kr/learn/courses/30/lessons/42587?language=java)
<br>출처 : 프로그래머스

# 코드
```java
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

        //n = sc.nextInt();
        int[] test = {1,1,9,1,1,1};
        int ans = solution(test,2);

        System.out.println(ans);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue que = new PriorityQueue( priorities.length , new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        }); //넣는건 offer("2") , 빼는건 poll

        for(int prior : priorities){
            que.add(prior);
        }


        while( !que.isEmpty()) { //que가 빌때까지 하는 것!
            for(int i = 0 ; i < priorities.length ; i++ ) {
                if( priorities[i] == (int)que.peek()) {
                    if( i == location ) {
                        return answer;
                    }
                    que.poll();
                    answer++;

                }
            }
        }

        return answer;
    }
}
```
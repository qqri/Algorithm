# 문제
[연산자끼워넣기](https://www.acmicpc.net/problem/14888)
<br>출처 : 백준
<br><br>
DFS임을 알고 풀면 쉽다.
<br>처음 시작할때 cnt 를 잘못 세서 애먹었다.

# 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static int num[];
    public static int cal[] = new int[4];
    public static int n;
    public static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        num = new int[n];

        for(int i = 0 ; i < n ; i++ ) {
            num[i] = sc.nextInt();
        }
        //연산자 종류 받음
        for(int i = 0 ; i < 4 ; i++ ) {
            cal[i] = sc.nextInt();
        }
        DFS(1 , num[0]); //처음 시작을 0에서부터 시작하면 바로 sum에 들어 갈 수 있다.
        Collections.sort(list);

        System.out.println(list.get( list.size()-1 ));
        System.out.println(list.get(0));
    }

    public static void DFS(int cnt, int sum) {

        for(int i = 0 ; i < 4; i ++) {
            if(cal[i] != 0) {
                cal[i] --;
                switch (i) {
                    case 0:
                        DFS(cnt+1, sum + num[cnt]);
                        break;
                    case 1:
                        DFS(cnt+1, sum - num[cnt]);
                        break;
                    case 2:
                        DFS(cnt+1,sum * num[cnt]);
                        break;
                    case 3:
                        DFS(cnt+1,sum / num[cnt]);
                }
                cal[i] ++;
            }
        }

        if(cnt == n) {
            list.add(sum);
        }
    }

}

```
# 문제
[덩치 문제](https://www.acmicpc.net/problem/7568)
<br>출처 : 백준

# 코드
```java
import java.util.Scanner;

public class Main {
    public static int[] result;
    public static int[][] body;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        body = new int[N][2];
        result = new int[N];

        for (int i = 0; i < N; i++) {
            body[i][0] = sc.nextInt(); //키
            body[i][1] = sc.nextInt(); //몸무게
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (body[i][0] < body[j][0] && body[i][1] < body[j][1]) result[i]++;
            }
            result[i]++;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }

    }
}

```
# 문제
[쿼드트리 뒤짚기](https://www.acmicpc.net/problem/1018)
<br>출처 : 알고스팟

# 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    static int tc, index;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

        tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            index = -1;
            String tree = br.readLine();
            System.out.println(recursive(tree));
        }
    }

    public static String recursive(String tree) {
        
        index += 1;
        char ch = tree.charAt(index);
        if (ch == 'b' || ch == 'w')
            return ch + "";

        String one = recursive(tree);
        String two = recursive(tree);
        String three = recursive(tree);
        String four = recursive(tree);

        return "x" + three + four + one + two;

    }
```
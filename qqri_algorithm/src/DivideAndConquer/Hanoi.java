package DivideAndConquer;

import java.util.Scanner;
import java.lang.*;

/*
 * 시작, 도움, 끝 기둥
 * 시작기둥 -> 도움 기둥으로
 * 도움기둥 -> 끝 기둥 으로 옮긴다.
 *
 */

public class Hanoi {

    public static int cnt = 0;

    public static int hanoi(int n, int start, int goal, int ass) {
        cnt++;
        if (n == 1) {
            System.out.println(start + "->" + goal);
            return 0;
        }
        hanoi(n - 1, start, ass, goal);
        System.out.println(start + "->" + goal);
        hanoi(n - 1, ass, goal, start);
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, start, goal, ass;

        n = sc.nextInt();
        start = sc.nextInt();
        goal = sc.nextInt();
        ass = sc.nextInt();

        hanoi(n, start, goal, ass);
        System.out.println("총 이동 횟수 : " + cnt);
    }
}

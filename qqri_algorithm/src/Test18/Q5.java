package Test18;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        int temp = 2; // 1 - 올라가는 즁 , 2 - 내려가는 중
        int cur;
        int before = sc.nextInt();

        if(before == 1) temp = 1; else if(before == 8) temp=2;
        else temp= 0; // 1이나 8로 시작안하면 무조건 mixed임.

        for(int i = 0 ; i < 7 ; i++ ) {
            cur = sc.nextInt();
            if(cur < before && temp == 1) {
                temp = 0;
            } else if(cur > before && temp == 2) {
                temp = 0;
            }
            before = cur;
        }

        if(temp == 0) System.out.println("mixed");
        else if(temp == 1) System.out.println("ascending");
        else System.out.println("descending");

    }
}

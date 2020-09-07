package Test;
import java.util.*;
public class Prob4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 가로
        int m = sc.nextInt(); // 세로

        int w = Math.max(n,m);
        int h = Math.min(n,m);

        //최소 변경 횟수

        int ans = Math.min(solve(n,m) , solve(m,n));
        System.out.println(ans);
    }

    public static int solve(int x , int y ) {
        int cnt = 0;
        while (y >= 1 ) {
            if(y > 3) {
                cnt += 3;
            } else {
                cnt +=2;
                break;
            }

            x-=2;
            y-=2;
        }

        return cnt + 1;
    }


}

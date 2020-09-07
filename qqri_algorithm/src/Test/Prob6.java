package Test;
import java.util.*;

public class Prob6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 한쪽 찾으면 나머지 한쪽은 250 에서 빼면된다.
        int x = sc.nextInt();
        int y = sc.nextInt();

        double[] ans = solve(x,y);

    //    System.out.println(ans[0] + " " + ans[1]);
        System.out.print(
                String.format("%.2f %.2f",ans[0],ans[1])
        );

    }

    public static double[] solve(int x, int y) {
        double area = 250*250;

        double[] ans = new double[2];
        if( x == 0 && y == 0) {
            ans[0] = 125.00;
            ans[1] = 125.00;
            return ans;
        }
        else if( x == y) {
            ans[0] = 0;
            ans[1] = 0;
        }

        //1 x 축위에 있는 경우
        else if( x != 0 && y == 0) {
            ans[1] = (area / (250-x))/2;
            ans[0] = 250 - ans[1];
        }
        // 2 y 축 위에 있는 경우
        else if( x == 0 && y !=0 ) {
            ans[0] = (area / (250-y))/2;
            ans[1] = 250 - ans[0];
        }
        // 빗 면 위에 있는 경우
        else if( x!=0 && y != 0) {
            if( x > y) {
                ans[1] = 250 - (area) / (x*2);
                ans[0] = 0;
            }
            else {
                ans[0] = 250 - (area/2) / y;
                ans[1] = 0;
            }

        }

        return ans;
    }


}

import java.util.Scanner;
import java.lang.*;

public class Factorial {
    /* 재귀 쓰면 런타임 에러남

    static int Fac(int n){
        if (n==1) return 1;

        return n*Fac(n-1);
    }
    */

    static int loop(int n){
        int result=1;
        for(int i=1;i<=n;i++){
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println(loop(n));
    }
}

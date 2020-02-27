import java.util.Scanner;
import java.lang.*;

public class Fibonacci {

    static int Fib(int n) {
        //기저사례
        if (n == 0) return 0;
        if (n == 1) return 1;

        return Fib(n - 1) + Fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Fib(n));
    }
}

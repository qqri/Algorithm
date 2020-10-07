package Test18;

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++ ) {
            arr[i] = sc.nextInt();
        }

        int i,j, sum = 0;
        i = sc.nextInt();
        j = sc.nextInt();

        for(int k = i-1 ; k <j ; k++ ) {
            sum += arr[k];
        }

        System.out.println(sum);
    }
}

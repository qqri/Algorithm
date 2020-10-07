package Test18;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int num = (n+1)/2;

        for(int i = 0 ; i < num ; i++ ) {
            for(int j = num-i-1 ; j > 0 ; j--) {
                System.out.print(" ");
            }
            for(int k = 2*i+1 ; k > 0  ; k-- ) {
                System.out.print("*");
            }
            System.out.println();
        }
        //0 - 5 || 3
        //1 - 3 || 1
        //2 - 1
        for(int i = 0 ; i < num-1 ; i++ ) { //num = 3
            for(int k = i+1 ; k > 0  ; k-- ) {
                System.out.print(" ");
            }
            for(int j = (num-i-1)*2 -1 ; j > 0 ; j--) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}

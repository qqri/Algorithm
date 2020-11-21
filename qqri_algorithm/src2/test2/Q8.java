import java.io.*;
import java.util.*;

public class Main {
    static int n , cnt=0;
    static int xy[][];
    static int check[] , d1[] , d2[];
    public static void main(String[] args) {
        n = 11;
        int k = 3;
        int[] X = { 11, 10, 9, 1, 3, 5, 7, 2, 4, 2, 1 };
        int[] Y = { 10, 9, 11, 11, 6, 4, 3, 2, 6, 3, 10};

        xy = new int[n][n];
        check = new int[n];
        d1 = new int[n*2 - 1];
        d2 = new int[n*2 - 1];

        for(int i = 0 ; i < X.length ; i++ ) {
            xy[X[i]-1][Y[i]-1]  = 1;
        }
        solution(0);
        System.out.println(cnt);

    }

    static void solution(int lev){
        if(lev == n) {
            cnt++;
            return;
        }

        for(int i = 0 ; i < n ; i++) {
            if( xy[lev][i] == 1 ) continue;

            if(check[i] == 1) continue;
            if(d1[i+lev] == 1) continue;
            if(d2[lev - i + n -1 ] == 1) continue;

            check[i] = 1;
            d1[i + lev] = 1;
            d2[lev - i + n -1 ] = 1;

            solution(lev + 1);

            check[i] = 0;
            d1[i+lev] = 0;
            d2[lev-i+n-1] = 0;
        }
    }
}
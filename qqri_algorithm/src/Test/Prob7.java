package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob7 {
    public static void main(String[] args) {
        // 신문기사 크기 : R,C
        // 확대 크기 : ZR , ZC

        Scanner sc = new Scanner(System.in);
        //1
        int R = sc.nextInt();
        int C = sc.nextInt();
        int ZR = sc.nextInt(); // 세로로 증가시킴
        int ZC = sc.nextInt();

        String[][] prob = new String[R][C];
        String[][] result = new String[R*ZR][C*ZC];

        for(int i = 0 ; i < R ; i++ ) {
            for(int j = 0 ; j < C ; j++ ) {
                prob[i][j] = sc.next();
            }
        }


        //2
        for(int i = 0 ; i < ZR * R; i++ ) {
            for(int j = 0 ; j < ZC * C ; j++) {
                result[i][j] = prob[i/ZR][j/ZC];
            }
        }

        //답
        for(int i = 0 ; i < ZR * R; i++ ) {
            for(int j = 0 ; j < ZC * C ; j++) {
                System.out.print( result[i][j] + " ");
            }
            System.out.println();
        }

    }

}

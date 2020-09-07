package Test;

import java.util.*;

public class Prob1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y = sc.nextInt();

        if( (y%4==0 && y%100!=0) || (y%400 == 0) )
            System.out.println("T");
        else System.out.println("F");
    }
}

package Test18;

import java.util.Arrays;
import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String s1 = sc.next();
//        String s2 = sc.next();
        String s1 = "Listen"; String s2 = "Silent";
        s1 = s1.toUpperCase();
        s2 = s2.toUpperCase();
        char[] firstChar = s1.toCharArray();
        char[] seconChar = s2.toCharArray();
        Arrays.sort(firstChar);
        Arrays.sort(seconChar);

        boolean flag = true;

        for(int i = 0 ; i < s1.length()  ; i++) {
            if(firstChar[i] != seconChar[i]) flag = false;
        }

        if(flag) System.out.println("Yes");
        else System.out.println("No");
    }
}

package Test;

import sun.awt.AWTAccessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prob10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> keyboard = new ArrayList<>();
        keyboard.add("***ABCDE");
        keyboard.add("FGHIJKLM");
        keyboard.add("NOPQRSTU");
        keyboard.add("VWXYZ***");



        String[] words = new String[n];

        for(int i = 0 ; i < n ; i ++ ){
            words[i] = sc.next();
        }

        String prob = sc.next();

        List<Character> res = new ArrayList<>();
        boolean temp = true;

        for(int i =0 ; i < n ; i++ ) {
            for(int j = 0 ; j < prob.length() ; j++ ) {
                if ( words[i].charAt(j) != prob.charAt(j) ) temp = false;
            }
            if(temp) res.add( words[i].charAt(prob.length()-1) );
            temp = true;
        }


        for(int i = 0 ; i < res.size() ; i++ ) {
            char ch = res.get(i);

            for(String str: keyboard) {
                if(str.contains(ch+"")) {
                    int idx = str.indexOf(ch);
                }
            }



        }


    }

}

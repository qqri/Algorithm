package StringArray;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;


public class LicenseKeyFormatting {
    public static void main(String[] args) throws NumberFormatException, IOException {

        //LicenseKeyFormatting 1
        LicenseKeyFormatting lf = new LicenseKeyFormatting();
       // String str = "8F3Z-2e-9-w";
        String str = "8-5g-3-J";
        int k = 4;


        System.out.println( lf.solve(k, str) );
    }
/*
* 문자열을 빠르게 다루는 법
*
*/
    public StringBuilder solve(int k , String str) {
        String newStr;
        newStr = str.replace("-",""); //대시 일단 다 제거
        //System.out.println(newStr);
        newStr = newStr.toUpperCase(); //모두 대문자로 변경( 숫자 들어가도 상관없는듯 ? )


        StringBuilder sb = new StringBuilder();
        for(char ch : newStr.toCharArray()) {
            sb.append(ch);
        }

        int len = newStr.length();
        for( int i = k ; i < len ; i = i + k ) {
            sb.insert(len-i , '-');
        }

        return sb;
    }

    public static String solve1( int k , String str) {
        int cnt = 0;

        for(int i = str.length()-1 ; i >=0  ; i-- ) {

            char tmp = str.charAt(i);
            cnt++;


            if( tmp == '-' && cnt < k ) {
                str = str.substring(0,i) + str.substring(i+1, str.length());
                cnt = 0;
            }
            //대문자로 바꾸기
            if( tmp >= 'a' && tmp <= 'z' ) {
                str = str.substring(0,i) + (char)(tmp - ('a'-'A')) + str.substring(i+1, str.length());
            }
        }

        return str;
    }

}

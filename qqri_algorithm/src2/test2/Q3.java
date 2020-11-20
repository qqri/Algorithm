import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int ans = 0;
        int p=0; // m 일에 한번 되는 날
        int n = 7 , m =3;

        while(n>0) {
            ans++;
            p++;
            n--;
            if( p == m) {
                p = 0;
                n++; // 한개 더 들어옴
            }
        }

        System.out.println(ans);

    }
}
package Test;
import java.util.*;

public class Prob3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String L1 = sc.next();
        String L2 = sc.next();
        L1 = L1.toUpperCase();
        L2 = L2.toUpperCase();
        char[] LL1 = L1.toCharArray();
        char[] LL2 = L2.toCharArray();

        Arrays.sort(LL1);
        Arrays.sort(LL2);

        boolean status = true;

        for(int i = 0 ; i < L1.length() ; i++ ) {
            if(LL1[i] != LL2[i]) {
                status = false;
                break;
            }

        }

        if(status) System.out.println("T");
        else System.out.println("F");
    }
}

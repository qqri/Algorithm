import java.io.*;
import java.util.*;

public class Main {
    static int k, num;
    static int[] order = new int[1000];
    static int[] ans = new int[1000];
    static int cnt = 0;

    public static void seek(int idx, int depth) {
        if(depth == k) {
            ans[idx] = order[cnt++];
        } else {
            seek(idx*2 , depth+1 );
            ans[idx] = order[cnt++];
            seek(idx*2 + 1 , depth+1 );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        num = (int)(Math.pow(2,k)-1);

        for(int i = 0 ; i < num ; i++ ) {
            order[i] = sc.nextInt();
        }

        seek(1,1);

        //출력
        for(int i=0,idx = 1 ; i < k; i++ ) {
            for(int k = 0 ; k < (int)Math.pow(2,i) ; k++ ) {
                System.out.print(ans[idx++]+" ");
            }
            System.out.println();
        }

    }

    public static void solve2() {
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt();
        String[] p = scan.nextLine().split(" ");
        p = scan.nextLine().split(" ");
        int pl = p.length;

        for(int i=0; i<K; i++) {
            for(int j=(int) (pl/Math.pow(2, i+1))  ;   j < pl  ;  j+= (int)((pl+1)/Math.pow(2, i))) {
                System.out.print(p[j]+" ");
            }
            System.out.println();
        }
    }
}
import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.*;

public class Main {
    static int n , m;
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        int[] degree = new int[n];

        for(int i = 0 ; i < n ; i++)
            list.add(new ArrayList<Integer>());

        for(int i = 0 ; i < m ; i++) {
            int v1 = sc.nextInt()-1;
            int v2 = sc.nextInt()-1;
            list.get(v1).add(v2);
            degree[v2] ++;
        }

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++ ) {
            if(degree[i] == 0) {
                q.offer(i);
            }
        }

        while( !q.isEmpty() ) {
            int cur = q.poll();
            System.out.print(cur+1 + " ");

            for(int j : list.get(cur)) {
                degree[j]--;

                if(degree[j] == 0) {
                    q.offer(j);
                }
            }
        }


    }

}
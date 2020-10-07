package Test18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Q7 {

    static List<Integer> list = new ArrayList<>();
    static int find ;
    public static void main(String[] args) {
        //합이 100 이 되는 일곱 개의 숫자 찾기.
        int[] arr = {7, 8, 10 , 13 , 15 ,19, 20, 23, 25};
        boolean[] visited = new boolean[arr.length];
        int sum = 0;
        for(int i : arr ) {
            list.add(i);
            sum+= i;
        }
        find = sum-100;
        computation(arr , arr.length , 2, visited, 0);

        for(int k : list ) {
            System.out.print(k + " ");
        }

    }

    static void computation(int[] arr, int n, int r, boolean[] visited , int start) {
        if(r == 0 ){
            int cur = 0;
            List<Integer> Index = new ArrayList<>();
            for(int i = 0 ; i < n ; i++ ) {
                if(visited[i]) {
                    cur+=arr[i];
                    Index.add(i);
                }
            }
            if(cur == find) {
                Collections.sort(Index);
                int idx1 = Index.get(0);
                int idx2 = Index.get(1);
                list.remove(idx1);
                list.remove(idx2-1);
            }
        }

        for(int i = start ; i < n ; i++) {
            visited[i] = true;
            computation(arr, n, r-1,  visited ,i+1);
            visited[i] = false;
        }
    }

}

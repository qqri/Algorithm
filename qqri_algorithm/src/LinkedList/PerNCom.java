package LinkedList;

import java.util.LinkedList;
import java.util.List;

public class PerNCom {

    public static void main(String[] args) {

        int[] nums = {100, 200, 300 , 400};

        /*
        System.out.println("순열_스왑이용");
        permutation_swap(nums , 0 , 4 , 2);

        System.out.println("순열_visited 이용");
        boolean[] visited = new boolean[4]; // n 에 해당
        LinkedList<Integer> resultList = new LinkedList<>();
        permutation_visited(nums, resultList , visited,4,2);

        System.out.println();
        System.out.println();
        System.out.println("조합_visited(backTracking)");
        boolean[] visited2 = new boolean[4];
        computation_visited(nums, visited2, 0 , 4 , 2 );
        */
        System.out.println("조합_recursion");
        int[] resultArr = new int[2]; // r
        computation_recursion(nums, resultArr, 4,2, 0,0);
    }

    public static void permutation_swap(int[] nums ,int depth, int n, int r) {
        if(depth == r) {
            for(int i =0 ; i < r; i++) {
                System.out.print( nums[i]+ " ");
            }
            System.out.println();
            return;
        }

        for(int i = depth; i < n ; i++ ) {
            swap(nums, depth , i);
            permutation_swap(nums, depth+1, n , r);
            swap(nums, depth , i); //  스왑한거 다시 되돌리기
        }

    }
    public static void swap(int[] nums , int depth , int index) {
        int temp = nums[index];
        nums[index] = nums[depth];
        nums[depth] = temp;
    }

    public static void permutation_visited(int[] nums, LinkedList<Integer> resultList , boolean[] visited , int n , int r) {
        if(resultList.size() == r) {
            for(int i : resultList) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0 ; i < n ; i++ ) {
            if( !visited[i] ) {
                resultList.add(nums[i]);
                visited[i] = true;
                permutation_visited(nums, resultList, visited, n, r);
                resultList.removeLast();
                visited[i] = false;
            }
        }
    }

    public static void computation_recursion(int[] nums, int[] resultArr, int n, int r, int index , int target) {
        if(r==0) {
            for(int i : resultArr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        if( target == n ) return;
        resultArr[index] = nums[target];

        computation_recursion(nums, resultArr, n, r-1 , index+1, target+1);
        computation_recursion(nums, resultArr, n , r , index , target+1 );
    }

    public static void computation_visited(int[] nums , boolean[] visited, int start , int n , int r ) { // int start 이후만 뽑는 부분의 후보가 된다.
        if(r == 0) { //끝나는 기준
            for(int i=0 ; i < nums.length ; i++ ) {
                if( visited[i] ) {
                    System.out.print( nums[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for(int i = start ; i < n ; i++) {
            visited[i] = true;
            computation_visited(nums, visited, i+1, n, r-1);
            visited[i] = false;
        }

    }

}

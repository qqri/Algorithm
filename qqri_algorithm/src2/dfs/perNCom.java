import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] nums = {100,200,300,400};

        //1-1 조합 - visit사용
        boolean[] visit1 = new boolean[nums.length];
        combination1(nums, 4, 2, 0, visit1);

        //1-2 조합
        int[] ans1 = new int[2];
        combination2(nums, ans1 , 4,2,0,0);

        //2 중복 조합
        int[] ans2 = new int[2];
        recombination(nums, ans2, 4 ,2, 0 ,0 );

        //3-1 순열
        permutation(nums, 4 , 2, 0);

        //3-2 순열 visit 사용
        boolean[] visit2 = new boolean[2];
        LinkedList<Integer> ansList1 = new LinkedList<>();
        permutation2(nums , 4 , 2 , ansList1 , visit2);

        //3-3 증복 순열
        LinkedList<Integer> ansList2 = new LinkedList<>();
        repermutation(nums , 4 , 2, ansList2);
    }

    //1-1 조합
    static void combination1(int[] nums, int n , int r , int start , boolean[] visit) {
        if(r == 0) {
            for(int i = 0 ; i < nums.length ; i++ ) {
                if(visit[i]) {
                    System.out.print(nums[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for(int i = start ; i < nums.length  ; i++ ) {
            visit[i] = true;
            combination1(nums, n, r-1 , i+1 , visit);
            visit[i] = false;
        }
    }
    //1-2 조합
    static void combination2(int[] nums, int[] ans, int n , int r, int idx, int target) {
        if(r==0) {
            for(int i : ans) {
                System.out.print( i + " ");
            }
            System.out.println();
            return;
        }

        if(target == n) return;
        ans[idx] = nums[target];
        combination2(nums,ans, n , r-1, idx+1, target+1); // 선택
        combination2(nums,ans, n , r, idx, target+1); // 선택 안함
    }

    // 1-3 중복조합
    static void recombination(int[] nums , int[] ans , int n , int r ,int idx , int target ) {
        if( r == 0 ){
            for(int i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        if(target == n) return;
        ans[idx] = nums[target];
        recombination(nums, ans , n , r-1, idx+1, target);
        recombination(nums, ans , n , r , idx , target+1);
    }

    //2-1  순열
    static void permutation(int[] nums, int n , int r , int depth ) {
        if(depth == r) {
            for(int i =0 ; i < r ; i++ ) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = depth ; i < n ; i++ ) {
            swap(nums, depth , i);
            permutation(nums ,n , r, depth+1);
            swap(nums, depth , i);
        }
    }
    static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    //2 -2 순열 visit
    static void permutation2(int[] nums , int n , int r , LinkedList<Integer> ansList , boolean[] visit ) {
        if(ansList.size() == r) {
            for(int i : ansList) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0 ; i < n ; i ++) {
            if(!visit[i]) {
                visit[i] = true;
                ansList.add(nums[i]);
                permutation2(nums, n , r, ansList, visit);
                visit[i] = false;
                ansList.removeLast();
            }
        }
    }

    //2 -2 중복순열 
    static void repermutation(int[] nums , int n , int r , LinkedList<Integer> ansList) {
        if(ansList.size() == r) {
            for(int i : ansList) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0 ; i < n ; i ++) {
            ansList.add(nums[i]);
            repermutation(nums, n , r, ansList);
            ansList.removeLast();
        }
    }

}

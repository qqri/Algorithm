package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        int[] nums = {10, 20 ,30};
 //       solve(nums, 0, 3,3);
        boolean[] visited = new boolean[nums.length];

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, lists, cur, 3,3);
    }

    public static void dfs(int[] nums,List<List<Integer>> lists, List<Integer> cur , int n , int r) {
        // 1. break 조건
        if(cur.size() == r) {
            List<Integer> list = new ArrayList<>(cur);
            lists.add(list);
            for(int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // 2. for 문
        for(int i = 0 ; i < n ; i++ ) {
            if(cur.contains(nums[i])) continue;

            cur.add(nums[i]);
            dfs(nums, lists, cur, n , r);
            cur.remove(cur.size()-1);

        }
    }

    //무조건 모드 경우의 수?
    public static List<int[]> list = new ArrayList<int[]>();

    public static void solve(int[] nums, int depth, int n, int r ) {
        if( depth == r) {
            list.add(nums);
            for(int k : nums) {
                System.out.print(k + " ");
            }
            System.out.println();
        }

        for(int i = depth ; i < n ; i++) {
            swap(nums, depth, i);
            solve(nums, depth+1, n ,r);
            swap(nums, depth, i);
        }

       // return list;
    }
    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        return;
    }


}

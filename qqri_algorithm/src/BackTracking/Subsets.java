package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {

        int[] nums = {11,22,33};
        //solve(list, nums);

        subsets(nums);
    }

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(lists, cur, nums, 0);

        System.out.println(lists);
        return lists;
    }
    public static void dfs(List<List<Integer>> lists ,List<Integer> cur, int[] nums, int start ) {
        //1
        List<Integer> list = new ArrayList<>(cur);
        lists.add(list);

        //2
        for(int i = start ; i < nums.length ; i++ ) {
            cur.add(nums[i]);
            System.out.print("cur  : " + nums[i] +" " );
            System.out.println();
            dfs(lists, cur, nums , i+1);
            cur.remove(cur.size()-1);
        }
    }

    public static List<List<Integer>> solve(List<List<Integer>> list, int[] nums) {
        for(int i = 1 ; i <= nums.length  ; i++ ) {
                int[] ans = new int[i];
                List<Integer> cur = new ArrayList<>();
                solve2(nums, ans, list, cur, 0,0,nums.length, i );

        }

        return list;
    }

    public static void solve2(int[] nums,int[] ans, List<List<Integer>> list, List<Integer> cur, int target, int index, int n, int r) {

        if(index == r ) {
            for(int i : ans) {
                cur.add(i);
            }
            list.add(cur);
            cur.clear();
            return;
        }
        if(target == n) return;

        ans[index] = nums[target];

        solve2(nums,ans, list,cur,target +1,index+1 , n , r );
        solve2(nums,ans, list,cur,target+1,index , n , r ); // 선택 안하는 경우

    }

}

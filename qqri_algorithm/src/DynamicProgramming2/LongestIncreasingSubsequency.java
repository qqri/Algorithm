package DynamicProgramming2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestIncreasingSubsequency {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 5, 2, 6, 10, 4, 12};
        int[] nums2 = {9, 11, 2, 8, 4, 7, 88, 15};
        System.out.println(solve(nums2));
    }

    public static int solve(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //1
        int result = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // 1로 초기화 해줘야 한다!! 

        //2
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            System.out.println("dp : " + dp[i]);
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}

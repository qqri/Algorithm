package StringArray;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MaximumSubarray {

    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};

        int max = 0;
        int sum = 0;


        //solve2 - 3중 for 문으로 해결

        for(int i = 0 ; i < input.length ; i++ ){
            for(int j = i ; j < input.length ; j++) {

                for(int k = i ; k <=j ; k++ ){
                    sum += input[k];
                }
                max = Math.max(max,sum);
                sum = 0;
            }
        }


        System.out.println( solve(input) );
    }
    public static int solve(int[] nums) {
        int newSum = nums[0];
        int max = nums[0];

        for(int i = 0 ; i < nums.length ; i++) {
            newSum = Math.max( nums[i] , newSum + nums[i] );
            max = Math.max( newSum , max );
        }

        return max;
    }
}

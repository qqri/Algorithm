package StringArray;

import java.io.IOException;
import java.util.*;

public class TrappingRainWater {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println( solve(nums) );
    }
    public static int solve(int[] height) {
        //1
        int result = 0;
        if(height == null || height.length <= 2 ) return 0;

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        //2
        int max = height[0];
        left[0] = height[0];

        for(int i = 1 ; i < height.length ; i++) {
            if( max < height[i] ) {
                max = height[i];
                left[i] = max;
            }else {
                left[i] = max;
            }
        }


        max = height[height.length-1];
        right[height.length-1] = height[height.length-1];

        for(int i = height.length-2 ; i >= 0 ; i--) {
            if( max < height[i] ) {
                max = height[i];
                right[i] = max;
            }else {
                right[i] = max;
            }
        }

        for(int i = 0 ; i < height.length ; i++ ) {
            result += Math.min(left[i] , right[i]) - height[i];
        }
        return result;
    }

    public static int solve1(int[] nums){
        if(nums == null || nums.length ==0 ) return 0;

        //1
        int rain = 0, left = 0 , right = 1; //left와 right 는 인덱스!!

        //2
        /*
        * left를 첫번째로 돌림
        * */
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] == 0 ) continue;
            else {
                left = i;
                break;
            }
        }


        while(left < nums.length-1 ){
            //left랑 right 찾음.
           // left = i; // 높이는 nums[i]
            for(int j = left+1 ; j < nums.length; j++) {
                if (nums[left] <= nums[j]) {
                    right = j; //높이는 nums[j]
                    break;
                }
            }

            if(nums[left] > nums[right]) {
                left ++;
                continue;
            }

            for(int k = left+1 ; k < right; k++) {
                //nums[left] 가 높이임.
                rain += nums[left] - nums[k];
            }

            left = right;
            right = left+1;
        }

        return rain;
    }

}

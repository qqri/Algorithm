package StringArray;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TwoSum{

    public static void main(String[] args) throws NumberFormatException, IOException {
        TwoSum ts = new TwoSum();
        /*                                        //0  1  2  3
        int[] answer = ts.twoSum1(new int[]{2, 7, 11, 15}, 9) ;
        System.out.println(answer[0] + "," + answer[1] );
        */

        int[] nums = {10, 11, 8 ,21 , 2, 7};
        int target = 10;
        int[] result = ts.solve(nums,target);
        for(int i : result) System.out.println(result[0] +" , "+ result[1]);
    }
    //수업
    public int[] solve(int[] nums, int target) {
        //담을 결과값
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++ ) {
            if(map.containsKey(nums[i])) { //nums i 에 해당하는 값이 있는지
                int mapValue = map.get(nums[i]); //이거에 해당하는게 key라서 이거하면 value 나옴
                result[0] = mapValue+1;
                result[1] = i + 1 ;
                break;
            } else {
                map.put(target-nums[i],  i);
            }
        }
        return result;
    }
    //내가한 방식
    public int[] twoSum1(int[] nums, int target) {
        int[] ans = new int[2];

        for(int i = 0 ; i < nums.length-1 ; i++ ) {
            for(int j = i+1 ; j < nums.length ; j++ ) {
               // int check = nums[i] + nums[j];
                if(( nums[i] + nums[j]) == target) {
                    ans[0] = i+1;
                    ans[1] = j+1;
                    break;
                }
                if(ans[0] != 0 && ans[1] != 0) break;
            }

        }

        return ans;
    }
}
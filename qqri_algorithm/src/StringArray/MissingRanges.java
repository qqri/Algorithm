package StringArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingRanges {
    public static void main(String[] args) throws NumberFormatException, IOException {

        int[] nums = {0,1,3,50,75};
        for(String str : solve(nums , 0 , 99)) {
            System.out.println(str);
        }
    }

    public static List<String> solve(int nums[], int lower , int upper) {
        //1
        List<String> result = new ArrayList<>();

        //2-1
        if( lower < nums[0] ) {
            result.add(makeRange( lower , nums[0]-1 ));
        }
        //2-2
        for(int i = 0 ; i < nums.length-1 ; i++ ){
            if( nums[i] != nums[i+1] && nums[i]+1 <nums[i+1 ]) {
                result.add(makeRange( nums[i]+1, nums[i+1]-1 ));
            }
        }
        //2-3
        if( nums[nums.length-1] < upper ){
            result.add( makeRange( nums[nums.length-1]+1 , upper ));
        }

        return result;
    }
    //자주쓰이는 건 함수로 따로 만들어서 뺀다.
    public static String makeRange(int low, int high){
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }

    public static List<String> solve1(int[] nums){
        //1
        List<String> result = new ArrayList<>();


        // 본인은 포함 아님.
        if(nums[0] !=0) {
            String str = "0->" + String.valueOf(nums[0] - 1);
        }

        for(int i = 1 ; i < nums.length-1 ; i++) {
            /*if(nums[i] == )
                그 이전 인덱스랑 비교해야 되는 && 그리고 그 이전 꺼 하고 비교해야
                이전꺼+1 == 지금 && 그다음꺼 -1  == 지금
                이면 넘어 가고 아니면 다른 작업한다.
                1 4 -> 면 for 문 돌려야 ??
                3 5 -> 뺀 차이가 2 인 경우에만
             */
            int currentN = nums[i];

            if(currentN+1 == nums[i+1]) continue;

            if(currentN+2 == nums[i+1]) result.add(String.valueOf(currentN+1));
            else{
                result.add( String.valueOf(currentN+1)+"->"+String.valueOf(nums[i+1]-1) );
            }

        }
        if(nums[nums.length-1] !=99 ) result.add( String.valueOf(nums[nums.length-1]+1) +"->99"  );


        return result;
    }

}




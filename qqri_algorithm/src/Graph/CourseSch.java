package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSch {

    public static void main(String[] args) {
        int[][] nums1 = {{1,0},{0,1}}; // F
        int[][] nums2 = {{1,0} , {2,1}, {3,2}}; // T

    }

    // 순차적을 모두 들었는 지를 확인한기 위함.
    public static boolean solve(int[][] nums) {
        if(nums.length < 0 ) return false;

        // 1
        Queue<Integer> que = new LinkedList<>();
        int[] inDegree = new int[nums.length];

        // 2
        int courseLength = nums.length;
        for(int i = 0 ; i < courseLength ; i++) {
            inDegree[ nums[i][1] ] ++ ; //선행 과목인 것들 (노드의 뒤에 존재하는 것들)
        }

        int inDegreeLength = inDegree.length;
        for(int i = 0 ; i < inDegreeLength ; i++ ) {
            if( nums[i][0] == 0 ) {
                que.offer( nums[i][0] );
            }
        }

        while( !que.isEmpty() ) {
            int firstZeroVal = que.poll();

            // fZv 위치 찾음
            for(int i = 0 ; i < courseLength ; i ++ ) {
                if( firstZeroVal == nums[i][0] ) {
                    inDegree[ nums[i][1] ] --;
                    if( nums[i][0] == 0 ) {
                        que.offer( nums[i][0] );
                    }
                }
            }
        }

        for(int i = 0 ; i < inDegreeLength ; i++ ) {
            if(inDegree[i] != 0) {
                return false;
            }
        }

        return true;
    }


}

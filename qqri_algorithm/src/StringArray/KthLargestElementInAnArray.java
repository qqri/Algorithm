package StringArray;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] nums =  {3,2,1,5,6,4};
        int k = 2;
        KthLargestElementInAnArray ke = new KthLargestElementInAnArray();

        System.out.println(solve1(nums, k));
        System.out.println( ke.pq(nums, k));
    }
    public static int solve1(int[] nums, int k ) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    public int pq(int[] nums , int k) {
        //1
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comp);

        //2
        for(int val : nums) {
            pq.offer(val);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
    Comparator<Integer> Comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };
}

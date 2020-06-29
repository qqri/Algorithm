package StringArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] T = {73,74,75, 71,69,72, 76, 73};

        int[] A = solve1(T);
        for(int i=0 ; i < T.length; i++) {
            System.out.println( A[i] );
        }

        //2
        int[] nums = {73,74,75, 71,69,72, 76, 73};
        int[] res = dailyTemperatures(nums);
        System.out.println("========2.result========");
        for(int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] solve1( int[] T) {
        int[] A = new int[T.length];

        for(int i = 0 ; i < T.length ; i++ ) {
            int current = T[i];
            int count = 0;

            for(int j = i + 1 ; j < T.length ; j++) {
                count++;

                if(current < T[j]) {
                    A[i] = count;
                    break;
                }
            }
        }

        return A;
    }

    public static int[] dailyTemperatures(int[] temper ) {
        //1 - stack에 넣어서 인덱스들을 비교하면서 넣는다.
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temper.length];

        //2
        for(int i = 0 ; i < temper.length ; i++ ) {
            while(!stack.isEmpty() && temper[stack.peek()] < temper[i]) {
                // result[0] = 1 - 0
                int index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);

        }
        return result;
    }

}

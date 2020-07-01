package StringArray;

import java.io.IOException;
import java.util.*;


public class PlusOne {
    public static void main(String[] args) throws NumberFormatException, IOException {

        //meeting1
        PlusOne po = new PlusOne();

        int[] t1 = {1,9,9};
        int[] ans = po.solve1(t1);

        for(int output : ans) {
            System.out.println(output);
        }

        System.out.println("============ 2 ===========");
        int[] ans2 = po.solve(t1);

        for(int output : ans2) {
            System.out.println(output);
        }
    }
    // 1 바로 푸는 방식
    public int[] solve(int[] digits) {

        for(int i = digits.length-1 ; i >= 0 ; i-- ) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }

        if(digits[0] == 0 ) {
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }

        return digits;

    }

    // 2
    public int[] solve1(int[] test) {
        String str = "";

        for(int i = 0 ; i < test.length ; i++) {
            str += String.valueOf(test[i]);
        }

        int num = Integer.valueOf(str);
        num++;
        String newStr = String.valueOf(num);
        int[] answer = new int[newStr.length()];

        for(int i = 0 ; i < answer.length ; i++ ) {
            answer[i] = newStr.charAt(i)-'0';
        }

        return answer;
    }


}

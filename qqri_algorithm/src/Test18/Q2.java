package Test18;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] nums = new int[2];

        if(num % 15 != 0) {
            nums[0] = num / 15 + 1;
            nums[1] = num % 15;
        } else { // 15로 나뉘는 경우
            nums[0] = num/15;
            nums[1] = 15;
        }

        System.out.println(nums[0] + " " + nums[1] );
    }


}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int sum =0 ;
        int[] nums = {1,2,3,4,5,6,7,8,79};
        int[] arr = new int[9];

        for(int i = 0; i < 9; i++ ) {
            arr[i] = nums[i];
            sum += nums[i];
        }

        Loop:
        for(int i = 0 ; i < 8 ; i++) {
            for(int j = i+1 ; j<9; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    arr[i] = -1;
                    arr[j] = -1;
                    System.out.println("!!");
                    break Loop;
                }
            }
        }

        for(int i = 0; i < 9; i++ ) {
            if(arr[i] != -1) {
                System.out.println(arr[i]);
            }
        }

    }

}
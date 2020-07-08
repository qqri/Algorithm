package StringArray;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FindAnagramsMapping {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] A = {12, 28, 46, 32, 50 };
        int[] B = {50, 12, 32, 46, 28 };

        int[] C = solve(A,B);
        for(int i : C){
            System.out.print(i + " ");
        }
    }
    public static int[] solve(int[] A, int[] B) {
        //1
        int[] result = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < B.length ; i++) {
            map.put(B[i],i); //B의 값과 인덱스 map으로 저장
        }

        for(int i = 0 ; i < A.length ; i++) {
            result[i] =  map.get(A[i]);
        }


        return result;
    }


    public static int[] solve1(int[] A, int[] B){
        //1
        int[] result = new int[A.length];

        //2
        for(int i = 0 ; i < A.length ; i++ ) {
            for(int j =0 ; j< B.length ; j++) {
                if(B[j] == 0) continue;
                if(A[i] == B[j]){
                    result[i] = j;
                    B[j] =0; //range가 [1,100] 이랬어서
                }
            }
        }

        return result;
    }
}

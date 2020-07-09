package StringArray;

import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralMatrix {
    public static void main(String[] args) throws NumberFormatException, IOException {
        /*
        * while로 돌린다.
        * break문을 걸 경우로 무한 루프 빠뜨리는 게 아니라, while 조건 자체를
        * 루프조건으로 잡는다.
        *
        * */
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13, 14, 15 ,16 }};
        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9}};

        for(int n : solve(matrix) ) {
            System.out.print(n + " ");
        }

    }

    public static List<Integer> solve( int[][] matrix ) {
        //1
        List<Integer> result = new ArrayList<>();

        //2
        if (matrix == null || matrix.length == 0)
            return result;
        int rowStart = 0, rowEnd = matrix.length - 1, colStart = 0, colEnd = matrix[0].length - 1;

        //
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // right
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            // down
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // left 3->0
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            // up 2->1
            if (colStart <= colEnd) {
                if (rowStart <= rowEnd) {
                    for (int i = rowEnd; i >= rowStart; i--) {
                        result.add(matrix[i][colStart]);
                    }
                }
            }
            colStart++;
        }
        return result;
    }


    public static List<Integer> solve1(int[][] nums) {
        //1
        List<Integer> result = new ArrayList<>();

        //2

        int rowStart = 0, rowEnd = nums[0].length-1 , colStart = 0, colEnd = nums.length-1 ;

        while(rowStart <= rowEnd && colStart <= colEnd) {
            for(int i = rowStart ; i <= rowEnd ; i++ ) {
                result.add(nums[colStart][i]);
            }

            colStart++;

            for(int j = colStart ; j <= colEnd ; j++) {
                result.add(nums[j][rowEnd]);
            }
            rowEnd--;
            if (colStart <= colEnd) {
                for (int a = rowEnd; a >= rowStart; a--) {
                    result.add(nums[colEnd][a]);
                }

                colEnd--;
            }
            if (rowStart <= rowEnd) {
                for (int b = colEnd; b >= colStart; b--) {
                    result.add(nums[b][rowStart]);
                }

                rowStart++;
            }
        }

        return result;
    }

}




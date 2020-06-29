package StringArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DailyTemperature {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[] T = {73,74,75, 71,69,72, 76, 73};

        int[] A = solve1(T);
        for(int i=0 ; i < T.length; i++) {
            System.out.println( A[i] );
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

}

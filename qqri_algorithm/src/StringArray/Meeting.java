package StringArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Meeting {
    public static void main(String[] args) throws NumberFormatException, IOException {
       // int[][] sol = {{0,30},{5,10},{15,20}};
        int[][] sol = {{7,10},{2,4}};

        System.out.println(meeting(sol));
    }

    public static boolean meeting(int[][] num){
        int max = 0 ;
        for( int i = 0 ; i < num.length ; i++ ) {
            if(max < num[i][1] ) max = num[i][1];
        }

        int[] room = new int[max+1];

        for(int i = 0 ; i< max+1 ;i++){room[i]=0; }

        for(int i = 0 ; i < num.length ; i++ ) {

            for(int j = num[i][0]; j < num[i][1]+1 ; j++) {
                //System.out.println(j);
                if(room[j] != 0) return false;
                room[j] = 1;
            }
        }

        return true;

    }
}

package StringArray;

import java.io.IOException;
import java.util.ArrayList;

public class movezeros {
    public static void main(String[] args) throws NumberFormatException, IOException {
        ArrayList<Integer> num = new ArrayList<>();
        int[] mz = {0,1,0,3,12};

        for(int i : mz){
            num.add(i);
        }

        for(int i = 0 ; i < mz.length ; i++ ) {
            if(num.get(i) == 0) {
                num.remove(i);
                num.add(0);
            }
        }

        for(int i = 0 ; i< num.size() ; i++ ) {
            System.out.println(num.get(i));
        }
    }

}

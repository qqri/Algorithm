package Test;

import java.util.*;

public class Prob2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] students = new int[num];
        int sum=0;

        for(int i = 0 ; i < num ; i++ ) {
            students[i] = sc.nextInt();
            sum += students[i];
        }
        double avg = sum/(double)num;

        int cnt = 0;
        for(int i = 0; i < num ; i++) {
            if(students[i] >  avg) cnt++;
        }

        avg = (100.0 * cnt) / num;

        System.out.println(
                String.format("%.3f %%", (double)avg)
        );
        //System.out.println(avg+"%");
    }
}

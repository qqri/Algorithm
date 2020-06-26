package StringArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Comparator;

class Interval {
    int start;
    int end;
    Interval() {
        this.start = 0;
        this.end = 0;
    }
    Interval(int s , int e ) {
        this.start = s;
        this.end = e;
    }
}

public class Meeting {
    public static void main(String[] args) throws NumberFormatException, IOException {

        //meeting1
        Meeting m = new Meeting();

        Interval in1 = new Interval(15,20);
        Interval in2 = new Interval(5,10);
        Interval in3 = new Interval(0,30);

        //객체속에 객체에 대한 배열도 만들수 있다.
        Interval[] intervals = {in1 , in2, in3};

        System.out.println(in1.getClass().getName());
        //m.solve(intervals);
        System.out.println(m.solve(intervals));

        // meeting2
//        int[][] sol = {{7,10},{2,4}};
//        System.out.println(meeting2(sol));
    }

    public boolean solve(Interval[] intervals) {
        if(intervals == null) return false;

        Arrays.sort(intervals, Comp);

        for(int i = 1 ; i < intervals.length ; i++) {
            if(intervals[i-1].end > intervals[i].start) return false;
        }
        return true;
    }

    Comparator<Interval> Comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    };


    public static boolean meeting2(int[][] num){
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

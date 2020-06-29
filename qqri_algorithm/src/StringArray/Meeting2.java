package StringArray;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Meeting2 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        //meeting1
        Meeting2 m = new Meeting2();

        Interval in1 = new Interval(0,30);
        Interval in2 = new Interval(5,10);
        Interval in3 = new Interval(15,20);

        //객체속에 객체에 대한 배열도 만들수 있다.
        Interval[] intervals = {in1 , in2, in3};

       System.out.println(m.solve1(intervals));

       //2
        // 1.소팅(start 순을 기준으로) 2. End <= Start 합치기 3. priorityQueue를 비교한다.

    }

    public int solve1(Interval[] intervals) {
        int roomNum = 1;

        Arrays.sort(intervals, Comp);

        for(int i=1 ; i < intervals.length ; i++ ) {
            if(intervals[i-1].end > intervals[i].start) roomNum++;
        }

        return roomNum;
    }

    Comparator<Interval> Comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start; // 0 5 10 이런식의 오름차순
        }
    };

    public int solve( Interval[] intervals ) {
        if(intervals == null || intervals.length == 0 ) return 0;

        Arrays.sort(intervals, Comp);
        Queue<Interval> heap = new PriorityQueue<Interval>(intervals.length, Comp2);

        heap.offer(intervals[0]);

        for(int i = 1 ; i < intervals.length ; i++ ) {
            Interval interval = heap.poll();
            if(intervals[i].start  < interval.end ) {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        return heap.size();
    }

    Comparator<Interval> Comp2 = new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
            return a.end - b.end; // 0 5 10 이런식의 오름차순
        }
    };
}

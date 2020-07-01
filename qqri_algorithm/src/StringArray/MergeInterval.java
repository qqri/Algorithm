package StringArray;

import java.io.IOException;
import java.util.*;

class Interval2{
    int start;
    int end;
    public Interval2(){
        this.start = 0;
        this.end = 0;
    }
    public Interval2(int s , int e) {
        this.start = s;
        this.end = e;
    }
}
public class MergeInterval {

    public static void main(String[] args) throws NumberFormatException, IOException {
        MergeInterval mi = new MergeInterval();
        Interval2 in1 = new Interval2(1,3);
        Interval2 in2 = new Interval2(2,6);
        Interval2 in3 = new Interval2(8,10);
        Interval2 in4 = new Interval2(15,18);

        List<Interval2> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);

        List<Interval2> answer = mi.merge(intervals);
        mi.print(answer);


    }
    public void print(List<Interval2> intervals){
        for(int i = 0 ; i  < intervals.size() ; i++ ) {
            Interval2 in = intervals.get(i);
            System.out.println( in.start + " , " +  in.end );
        }
    }
    public List<Interval2> merge(List<Interval2> intervals){

        //start에 따라 오름차순 정렬 하는 과정임
        Collections.sort(intervals , (a,b) -> a.start-b.start );

        Interval2 before = intervals.get(0);
        List<Interval2> result = new ArrayList<>();

        for(int i = 1 ; i < intervals.size() ; i++ ) {
            Interval2 current = intervals.get(i);
            if( before.end > current.start ) {
                before.end = Math.max(before.end , current.end);
            } else {
                //계속 합쳐지는 과정이 끝나면 그때 더한다.
                //이때까지 end의 값만 변화하고 맨 처음에 start에 관해 오름차순 정렬 해줬기 때문에 이때 합치고 before 없뎃하면됨.
                result.add(before);
                before = current;
            }
        }
        // 지금 나온 과정은 before만 더해져 있기 때문에 마지막 in 요소는 포함이 되지 않는다. 따라서 따로 더해줘야됨.
        //마지막 before는 intervals.get(intervals.size()-1) 이거임!
        if( !result.contains( before )) result.add(before);

        return result;
    }




    //내가한거
    public ArrayList<Interval2[]> solve1(Interval2[] intervals){
        //Arrays.sort(intervals, Comp);
        ArrayList<Interval2[]> ans = new ArrayList();


        for(int i = 0 ; i < intervals.length-1 ; i++ ) {
            int start = 0 , end = 0;
            ArrayList<Integer> startlist = new ArrayList();

            end = intervals[i].end;

            for(int j = i+1 ; j < intervals.length ; j++ ) {

                if( end > intervals[j].start ) {
                   startlist.add(intervals[j].start);
                   end = Math.max(end , intervals[j].end);
                }
            }
            Collections.sort(startlist);
           // start = (Integer)startlist.get(0);
            ans.add(new Interval2[]{new Interval2(start, end)});
        }

        return ans;
    }


    //end에 따라 오름차순
    Comparator<Interval2> Comp = new Comparator<Interval2>() {
            @Override
            public int compare(Interval2 a, Interval2 b) {
                return  a.end - b.end;
        }
    };

    //내림차순
    //class Descending implements Comparator<Integer> {

}

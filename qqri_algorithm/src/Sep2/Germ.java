package Sep2;

import java.util.*;

public class Germ {

    public static void main(String[] args) {
        String[] t1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] t2 = {"AA", "AB", "AC", "AA", "AC"};
        String[] t3 = {"XYZ", "XYZ", "XYZ"};
        String[] t4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        Germ g = new Germ();
        for(int i : g.solution(t1) ) {
            System.out.println(i);
        }


        // s
    }
    public int[] solution(String[] gems) {
        //1
        int[] ans = new int[2];
        Map<String , Integer> map = new HashMap<>();

        for(String str : gems) {
            map.put(str , 0);
        }
        int left=0, right=0, size=987654321;
        boolean check = true;

        while(true){
            if(left<0 || left >= gems.length || right < 0 || gems.length <= right) break;

            if( right < left && check ) {
                for(int k = right ; k > left ; k++ ) {
                    map.replace(gems[right] , map.getOrDefault(gems[right],0)+1);
                }
                right = left+1;
            }
            else {
                if(check)map.replace(gems[right] , map.getOrDefault(gems[right],0)+1);
            }

            if( !map.containsValue(0) ) {
                if(size > right-left) {
                    ans[0] = left + 1;
                    ans[1] = right + 1;
                    size = right - left;
                }
                map.replace(gems[left] , map.getOrDefault(gems[left],1)-1);
                left ++;
                check = false;
            } else { // map 에 0이 포함되어 있는 경우 한번 더 돌린다
                right ++;
                check = true;
            }
        }
        return ans;
    }


}

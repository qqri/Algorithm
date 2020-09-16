package Sep2;

import java.util.*;

public class Airplane {
    public static List<List<String>> lists = new ArrayList<>();
    public static List<String> list = new ArrayList<>();
    public static boolean[] visited;

    public static void main(String[] args) {
        String[][] tickets = { {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"} };
        String[][] t2 = {{ "ICN" , "SFO" } , { "ICN" , "ATL" } , {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

    //    sol(t2);
        for(String str : sol(t2)) {
            System.out.println(str);
        }
    }
    public static String[] sol(String[][] tickets ) {
        // 1
        String[] answer = new String[tickets.length  + 1];

        // 2
        for(int i = 0 ; i  < tickets.length ; i++ ) {
            if( tickets[i][0].equals("ICN") ) {
                visited = new boolean[tickets.length]; // 시작마다 초기화
                list.clear();
                list.add("ICN");
                visited[i] = true;
                dfs( tickets , tickets[i][1] , 1);
            }
        }
        Collections.sort(lists, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                String e1 = o1.get(0), e2 = o2.get(0);
                for(int i = 0 ; i < o1.size(); i++ ) {
                    e1 = o1.get(i);
                    e2 = o2.get(i);
                    if(e1.equals(e2)) continue;
                    else  break;
                }
                return e1.compareTo(e2);
            }
        });

        List<String> res = lists.get(0);


        for(int i = 0 ; i < answer.length ; i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }

    public static void dfs(String[][] tickets, String next, int cnt ) {
        //1
        list.add( next );

        if(cnt == tickets.length) {
            List<String> copy = new ArrayList<>(list);
            lists.add(copy);
            return;
        }

        for(int i = 0 ; i < tickets.length ; i++ ) {
            String start = tickets[i][0];
            String end = tickets[i][1];

            if( next.equals( start ) && !visited[i] ) {
                visited[i] = true;
                dfs(tickets , end , cnt+1);

                visited[i] =false;
                list.remove( list.size()-1 ); // 마지막꺼 뺀다.
            }
        }
    }
}

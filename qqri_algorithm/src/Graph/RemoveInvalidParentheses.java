package Graph;


import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {

        for(String str : solution("(aa)())()")) {
            System.out.println(str);
        }
    }

    public static List<String> solution(String str) {
        //1
        if(str.length() == 0 ) return null;

        List<String> res = new ArrayList<>();
        Queue<String> que = new LinkedList<>(); //답 담기 위함
        Set<String> visited = new HashSet<>(); // 중복이 있는지 확인하는  set
        boolean found = false; // minimum. 까지만 찾고 끝내가 위한 것. 횟수 제한을 위함

        //2
        que.offer(str);
        visited.add(str);
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0 ; i < size ; i++ ) {
                String s = que.poll();
                if(isValid(s)) {
                    res.add(s);
                    found = true;
                }
                if(found) continue; // 밑에 있는 과정 뛰어 넘기 위함!

                for(int j = 0 ; j < s.length() ; j++ ) {
                    if( s.charAt(j) != '(' && s.charAt(j) != ')') continue;
                    String newStr = s.substring(0,j) + s.substring(j+1);

                    if( !visited.contains(newStr) ) {
                        visited.add(newStr);
                        que.offer(newStr);
                    }

                }
            }
        }

        return res;
    }
    public static boolean isValid(String str) {
        int cnt = 0;
        for(char c : str.toCharArray()) {
            if( c == '(') cnt++;
            if( c == ')') {
                cnt--;
                if(cnt < 0) return false; // ())(
            }
        }
        return cnt == 0;
    }

    //이렇게 되면 한개만 삭제한것 만 할 수있다.
    public static List<String> sol1(String word) {
        //1
        List<String> result = new ArrayList<>();
        for(int i = 0 ; i < word.length() ; i++ ) {
            String newStr = word.substring(0,i) + word.substring(i+1,word.length());
            if(valid(newStr) && !result.contains(newStr)) {
                result.add(newStr);
            }

        }
        return result;
    }

    public static boolean valid(String word) {

        Stack<Character> st = new Stack<>();

        for(char ch : word.toCharArray()) {
            switch(ch) {
                case '(':
                    st.push(ch);
                    break;
                case ')':
                    if(st.isEmpty()) {
                        return false;
                    }
                    st.pop();
                    break;
                default:
                    continue;
            }
        }
        return st.isEmpty();
    }
}

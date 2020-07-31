package QueueNStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//replace는  " "  string 도 가능하다
public class Alumini {
    public static void main(String[] args) {
        String arg = "()(((()())(())()))(())";
        System.out.println(solution(arg));

    }
    public static int solution(String arg) {
        //1
        int answer = 0;
        Stack<Character> st = new Stack<>();
        String target = arg.replace( "()" , "0" );

        //2
        for(char ch : target.toCharArray() ) {
            switch(ch) {
                case '0':
                    answer += st.size();
                    break;
                case ')':
                    st.pop();
                    answer ++;
                    break;
                default:  //ch == ( 일때
                    st.push(ch);
            }
        }


        return answer;
    }
}


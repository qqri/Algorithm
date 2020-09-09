package Sep2;
import sun.plugin2.main.client.DisconnectedExecutionContext;

import java.util.*;

public class PostCalculator {
    public static void main(String[] args) {

        String cal = (sol("2*(3+6)"));
        System.out.println(cal(cal));
    }

    public static int cal(String str) {
        char ch;
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < str.length() ; i++ ) {
            ch = str.charAt(i);
            if(ch >='0' && ch <= '9') {
                st.push((ch-'0'));
            }
            else {
                int result= 0;
                int num2 = st.pop();
                int num1 = st.pop();
                switch (ch) {
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                }
                st.push(result);
            }

        }

        return st.pop();
    }

    public static String sol(String calStr) {

        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        int p;
        char cur;
        for(int i = 0 ; i < calStr.length() ; i++ ) {
            cur = calStr.charAt(i);
            p = priority(cur);

            switch(cur){
                case '+':
                case '-':
                case '*':
                case '/':
                    while ( !st.isEmpty() && priority(st.peek()) >= p ) {
                        sb.append(st.pop());
                    }
                    st.push(cur);
                    break;
                case '(':
                    st.push(cur);
                    break;
                case ')':
                    while( !st.isEmpty() && st.peek()!='(') {
                        sb.append(st.pop());
                    }
                    st.pop(); // 마지막 ( 빼냄
                    break;
                default:
                    sb.append(cur);
            }

        }

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        return new String(sb);

    }

    public static int priority(char ch) {
        switch (ch) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            case '(':
            case ')':
                return 0;
        }
        return -1;
    }

}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String input = "23+2*2/";
        char[] arr = input.toCharArray();
        int ans = cal(arr);
        System.out.println(ans);
    }

    static int cal(char[] arr) {
        Stack<Integer> st = new Stack<>();
        int num1, num2;
        for(char ch : arr) {
            if(Character.isDigit(ch)) {
                st.push(Integer.parseInt( String.valueOf(ch) ));
            }
            else if(ch == '-') {
                num1 = st.pop();
                num2 = st.pop();
                st.push(num2 - num1);
            }else if ( ch == '+') {
                num1 = st.pop();
                num2 = st.pop();
                st.push(num2+num1);
            }else if ( ch == '*') {
                num1 = st.pop();
                num2 = st.pop();
                st.push(num2*num1);
            }else if ( ch == '/') {
                num1 = st.pop();
                num2 = st.pop();
                st.push(num2/num1);
            }
        }

        return st.pop();
    }
}
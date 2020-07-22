package QueueNStack;

import com.sun.javafx.css.PseudoClassState;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
         String str = "{} [] ()";
         // {} [] ()  true , {[}]  false , (] false
        String s = "{[]}";
        System.out.println(isValid(s));
        System.out.println(solve1(str));

    }

    public static boolean isValid(String s) {
        //1
        if(s.length() %2 != 0 ) return false;
        Stack<Character> stack = new Stack<>();

        //2
        for(char ch : s.toCharArray()) {
            switch (ch){

                case ')':
                    if(!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
                case ']':
                    if( !stack.empty() && stack.peek() == '[') {
                        stack.pop();
                    }
                    break;
                case '}':
                    if( !stack.empty() && stack.peek() == '{') {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(ch);
                    break;
            }
        }


        return stack.empty();
    }

    public static boolean solve1(String str) {
        Stack<Character> stack = new Stack<>();


        for(char ch : str.toCharArray()) {
            switch (ch){
                case '(':
                    stack.push(ch);
                    break;
                case '[':
                    stack.push(ch);
                    break;
                case '{':
                    stack.push(ch);
                    break;

                case ')':
                    if(stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
                case ']':
                    if(stack.peek() == '[') {
                        stack.pop();
                    }
                    break;
                case '}':
                    if(stack.peek() == '{') {
                        stack.pop();
                    }
                    break;
            }
        }

        if( !stack.isEmpty() ) return false;

        return true;
    }
}

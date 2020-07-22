package QueueNStack;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String[] strs = {"5","-2","4","C","D","9","+","+"};

        System.out.println(calBaseBall(strs));
    }

    public static int calBaseBall(String[] strs) {
        //1
        Stack<Integer> stack = new Stack<>();

        //2
        for(String op : strs ) {
            switch (op) {
                case "C" :
                    stack.pop();
                    break;
                case "D" :
                    stack.push( stack.peek()*2 );
                    break;
                case "+" :
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y);
                    stack.push(x);
                    stack.push(x+y);
                    break;

                default:
                    stack.push(Integer.valueOf(op));

            }
        }

        int sum = 0;
        while( !stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static int solve1(String[] strs) {
        int result = 0;
        //System.out.println( Integer.parseInt(strs[1]));
        Stack stack = new Stack();
        //stack.push(Integer.parseInt(strs[0]));
        for(int i = 0 ; i < strs.length ; i++ ){
            String ch = strs[i];
            if( !ch.equals("C") && !ch.equals("D") && !ch.equals("+")) {
                stack.push(Integer.parseInt(ch));
            }

            else if(ch.equals("C")) {
                stack.pop();
            }

            else if(ch.equals("D")) {
                int db = (int) stack.peek() *2;
                stack.push(db); //db = double
            }

            else if(ch.equals("+")) {
                int after = (int) stack.pop();
                int before = (int) stack.pop();
                int plus  = after+before;

                stack.push(before);
                stack.push(after);
                stack.push(plus);
            }
        }

        while( !stack.isEmpty() ) {
            result += (int)stack.pop();
        }

        return result;
    }
}

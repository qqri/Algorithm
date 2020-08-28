package QueueNStack;

import java.util.*;

public class OperatorMaximum {

}
class Solution {
    public static Set<String> op = new HashSet<>();
    public static ArrayList<String[]> opList = new ArrayList<>();

    public long solution(String expression) {
        long max = 0;
        ArrayList<String> strList = findNumList(expression);

        //  findArr 이후에 실행
        String[] opArr = new  String[op.size()];
        Iterator it = op.iterator();
        for(int i = 0 ; i < op.size() ; i++ ) {
            opArr[i] = (String) it.next();
        }

        perOp( opList, opArr, 0, op.size() , op.size() );
        for(String[] opArray : opList ) { // 종류 별로 따짐
            ArrayList<String> calList = makePostfix(strList, opArray );
            max = Math.max(max ,  calPostfix(calList ));
        }

        return max;
    }

    public static long calPostfix(ArrayList<String> strList) {
        Stack<Long> numStack = new Stack<>();
        for(int i = 0 ; i < strList.size() ; i++ ) {
            String cur = strList.get(i);

            if(!isOperation(cur)) {
                numStack.push( Long.parseLong(cur) );
            }
            else {
                long num1 = numStack.pop();
                long num2 = numStack.pop();
                long result = 0;

                switch(cur) {
                    case "+" :
                        result = num2 + num1;
                        break;
                    case "-" :
                        result = num2 - num1;
                        break;
                    case "*" :
                        result = num2 * num1;
                        break;
                }
                numStack.push(result);
            }
        }

        return Math.abs(numStack.pop());
    }

    public static boolean isOperation(String str) {
        if( str.equals("+") || str.equals("-") || str.equals("*") ) return true;

        return false;
    }

    public static ArrayList<String> makePostfix(ArrayList<String> strList, String[] opArr) {
        ArrayList<String> postStr = new ArrayList<>();
        Stack<String> st = new Stack<>();
        int size = strList.size();
        for(int i = 0 ; i < size ; i++ ) {
            String curStr = strList.get(i);
            int p = priority(curStr, opArr);
            switch (curStr) {
                case "+":
                case "-":
                case "*":
                    while(!st.isEmpty() && priority(st.peek(), opArr) >= p) {
                        postStr.add(st.pop());
                    }
                    st.push(curStr);
                    break;
                default:
                    postStr.add(curStr);
                    break;
            }
        }

        while(!st.isEmpty()) {
            postStr.add(st.pop());
        }

        return postStr;
    }

    public static int priority(String curStr, String[] opArr) { //인덱스 높을 수록 우선순위다.
        int pr=0;
        for(int i = 0 ; i < opArr.length ; i++ ) {
            if( opArr[i].equals(curStr) ) {
                pr = i;
                break;
            }
        }
        return pr;
    }

    public static ArrayList<String> findNumList(String str) {
        ArrayList<String> calNum = new ArrayList();

        int start=0;

        for(int i = 0 ; i < str.length() ; i++ ) {
            String ch = String.valueOf( str.charAt(i) );

            if( ch.equals("+") || ch.equals("-") || ch.equals("*") ) {
                String newStr = str.substring(start, i);
                calNum.add(newStr);
                calNum.add(ch);
                op.add(ch);

                start = i+1;
            }
            if(i == str.length() -1) {
                calNum.add( str.substring(start) );
            }
        }
        return calNum;
    }


    public static void perOp(ArrayList<String[]> opList , String[] nums, int depth, int n , int r ) {
        if(depth == r) {
            String[] newNums = nums.clone();
            opList.add(newNums);
            return;
        }
        for(int i = depth; i < n ; i++ ) {
            swap(nums, depth,i);
            perOp(opList, nums, depth+1, n,r);
            swap(nums, depth,i);
        }
    }

    public static void swap(String[] nums , int depth , int index) {
        String temp = nums[index];
        nums[index] = nums[depth];
        nums[depth] = temp;
    }

}

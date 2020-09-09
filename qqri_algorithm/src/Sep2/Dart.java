package Sep2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Dart {
    public static void main(String[] args) {
        System.out.println( sol("1S2D*3T") );

    }
    public static int sol(String str) {
        Stack<String> st = new Stack<>();
        int start=0;
        for(int i = 0 ; i < str.length() ; i++ ) {
            String ch = String.valueOf(str.charAt(i));
            if( ch.equals("S") || ch.equals("D") || ch.equals("T")  ) {
                String newStr = str.substring(start,i);
                st.push(newStr);
                st.push(ch);
                start = i +1 ;

            }
            else if( ch.equals("*") || ch.equals("#") ) {
                st.push(ch);
                start++;
            }
        }

        int result = 0;
        Stack<String> opSt = new Stack<>();
        String operation , bonus;
        int num, bonusNum=1;

        while( !st.isEmpty() ) {
            String cur = st.pop();
            if(isOp(cur)) {
                opSt.push(cur);
                continue;
            }
            else { // 숫자인 경우
                num = Integer.parseInt(cur);
                if(opSt.isEmpty()) {
                    bonusNum = num;
                }
                if(opSt.size() == 1) {
                    operation = opSt.pop();
                    result += cal(operation , num , bonusNum );
                    bonusNum = 1;
                }
                if(opSt.size() == 2) {
                    operation = opSt.pop();
                    bonus = opSt.pop();
                    System.out.println(bonus);
                    switch (bonus){
                        case "*":
                            result += 2 * cal(operation, num , bonusNum  );
                            bonusNum = 1;
                            st.push("2");
                            break;
                        case "#":
                            result -= cal(operation , num , bonusNum  );
                            bonusNum = 1;
                            break;
                    }

                }
            }

        }

        return result;
    }

    public static int cal(String op, int num , int bonusNum ) {
        switch (op) {
            case "S":
                return num*bonusNum;
            case "D":
                return (int)Math.pow(num,2) * bonusNum;
            case "T":
                return (int)Math.pow(num,3)*bonusNum;
        }
        return 0;
    }

    public static boolean isOp(String ch) { // 연산자 인지 확인
        if( ch.equals("S") || ch.equals("D") || ch.equals("T") ||ch.equals("*") || ch.equals("#")  ) return true;
        return false;
    }

}

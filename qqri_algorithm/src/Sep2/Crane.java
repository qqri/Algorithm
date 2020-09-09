package Sep2;

import java.util.Stack;

public class Crane {
    public static void main(String[] args) {
        int[][] board = {
                { 0 , 0 , 0 , 0 , 0 },
                { 0 , 0 , 1 , 0 , 3 },
                { 0 , 2 , 5 , 0 , 1 },
                { 4 , 2 , 4 , 4 , 2 },
                { 3 , 5 , 1 , 3 , 1}
                        };
        int[] moves = { 1 , 5 , 3 , 5 , 1 , 2 , 1 , 4 };

        // 4 3 1 1 3 2 0 4
    }

    public static int sol(int[][] board , int[] moves) {
        Stack<Integer> st = new Stack<>();
        int ans=0;
        int now;
        int curDoll;
        for(int i = 0 ; i < moves.length ; i++ ) {
            now = moves[i];
            curDoll = 0; // 일단 0으로 초기화
            for(int j = 0 ; j < board.length ; j++ ) {
                if( board[j][now] != 0) {
                    curDoll = board[j][now];
                    break; // 가장 위에 있으면서 0아닌거 뺀다.
                }
            }
            if(curDoll!=0) {
                if( st.peek() == curDoll ) {
                    st.pop();
                    ans++;
                }
                else st.push(curDoll);
            }

        }

        return ans;
    }

}

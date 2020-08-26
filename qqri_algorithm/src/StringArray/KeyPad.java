package StringArray;

import java.util.*;

/*
* 거리 계산할때 유클리드로 하면 안되고 맨하탄 거리로 계산해야한다.
* 예시 : 왼 8 / 오 : 6 / 눌러야 되는 키 : 2 인 경우 오류 뱔생함.
* */
class keyPad {
    public static int[][] keyPad =
            {
                    {1,2,3},
                    {4,5,6},
                    {7,8,9},
                    {100,0,200}
            };
    public String solution(int[] numbers, String hand) {
        //1
        String answer = "";
        int[] leftPos = {3,0};
        int[] rightPos = {3,2};
        int leftLen, rightLen;
        boolean status = hand.equals("right")? true : false; // 오른손잡이면 true 되게 함. 

        for(int i = 0 ; i < numbers.length ; i++ ) {
            int[] curPos = findPos(numbers[i]);
            if(curPos[1] == 0 ) {
                status = false;
            } else if(curPos[1] == 2) {
                status = true;
            } else if(curPos[1] == 1) {
                leftLen =Math.abs( curPos[0]-leftPos[0]) + Math.abs(curPos[1]-leftPos[1]);
                rightLen=Math.abs( curPos[0]-rightPos[0]) + Math.abs(curPos[1]-rightPos[1]);


                if(leftLen > rightLen) status = true;
                else if(leftLen < rightLen) status = false;
                else if(leftLen == rightLen) {
                    status = hand.equals("right")? true : false;
                }
            }
            if(status) {
                answer+="R";
                rightPos[0] = curPos[0];
                rightPos[1] = curPos[1];
            } else {
                answer+="L";
                leftPos[0] = curPos[0];
                leftPos[1] = curPos[1];
            }
        }

        return answer;
    }

    public static int[] findPos(int n) {
        int[] pos = new int[2];
        for(int i = 0 ; i < 4; i++ ) {
            for(int j = 0 ; j < 3 ; j++ ) {
                if( keyPad[i][j] == n) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        return pos;
    }
}
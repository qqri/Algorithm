# 문제
[LCS 문제](https://www.acmicpc.net/problem/9251)
<br>출처 : 백준

LCS 문제 풀이 참고
-> https://www.youtube.com/watch?v=P-mMvhfJhu8&feature=youtu.be
dp[][] 2차원배열로 풀어야 풀 수 있다.
1차로 풀수도 있으나 그럼 시간이 오래걸림 ㅠㅠ
처음 푼 방식은 substring써서 나중에 길이가 더 많이 겹치는 경우에 틀리게 된다.


# 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        String line2 = br.readLine();

        System.out.println( LCS(line1,line2) );

    }

    public static int LCS(String line1 , String line2) {
        dp = new int[ line1.length() + 1 ][ line2.length() + 1];
        dp[0][0] = 0;


        for(int i=1 ; i <= line1.length() ; i++ ) {
            for(int j=1 ; j <= line2.length() ; j++ ) {

                if( line1.charAt(i-1) == line2.charAt(j-1) ) { //dp 배열 선언을 +1 +1 로했어서 인덱스 1씩 빼줘야한다.
                    dp[i][j] = dp[i-1][j-1] + 1 ;
                }
                else{
                    dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1] );
                }
            }
        }

        return dp[line1.length()][line2.length()];
    }

    /*
    * 처음 틀렸던 코드
    *
    * 이렇게 되면 substring 때문에 나중에 겹쳐서 더 길어지는 경우를 샐 수 없어진다.
    * < test case >
    *     MKEPPA
    *     KEMPPA
    *
    * */
    public static int WrongLCS( String line1 , String line2 ){
        int ret = 0;
        for(int i = 0 ; i < line1.length() ; i++) {

            for(int j=0 ; j < line2.length() ; j++) {

                if (line1.charAt(i) == line2.charAt(j)) {
                    ret++;
                    line2 = line2.substring(j+1);
                    break;
                }
            }
        }

        return ret;

    }

}

```
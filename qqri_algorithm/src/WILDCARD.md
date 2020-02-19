# 문제
[와일드카드](https://www.algospot.com/judge/problem/read/WILDCARD)
<br>출처 : 알고스팟

# 코드
```java
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.math.*;

public class Main {

    public static int[][] cache = new int[101][101];
    public static List<String> result;
    public static String W,S;

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        result = new ArrayList<String>();

        for(int u=0;u<T;u++){
            W = sc.next();
            int n = sc.nextInt();

            for(int i=0;i<n;){
                S = sc.next();

                for(int j=0;j<101;j++){
                    for(int k=0;k<101;k++){
                        cache[j][k]=-1;
                    }
                }
                if(solve(0,0)==1){
                    result.add(S);
                }
            }
        }
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }

    }

    public static int solve(int w,int s){
        /*
        * -1 : 아직 계산 안됨
        *  1 : 대응됨
        *  0 : 대응 안됨.
        */
        int ret = cache[w][s];
        if(ret != -1) return cache[w][s];

        //W[w] S[s] 맞춤 :: 맨끝으로 안갔는지 체크 하고 ?이거나 같을때 !
        while (w<W.length() && s<S.length() && (W.charAt(w)=='?' || W.charAt(w)==S.charAt(s))){
            w++;
            s++;
        }
        //더이상 대응이 안되면 while문이 끝나는 이유 생각
        // 패턴 문자열 끝에 도달해서 끝난경우
        if(w == W.length()) {
            return cache[w][s] = (s==S.length()? 1:0);
        }

        // * 만난 경우 *에 몇 글자를 대응해야 할지 재귀호출한다.
        if(W.charAt(w) == '*'){
            for(int skip = 0; s+skip <= S.length(); ++skip ){
                if(solve(w+1,s+skip) ==1){
                    return cache[w][s] = 1 ;
                }
            }
        }

        //이외의 경우 : 모두 대응 하지 않는 경우!
        return cache[w][s]=0;

    }
}

```
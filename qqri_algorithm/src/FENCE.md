# 문제
[울타리잘라내기](https://algospot.com/judge/problem/read/FENCE)
<br>출처 : 알고스팟

# 코드
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int tc,n;
    static int[] h,result;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args)  throws NumberFormatException, IOException {

        tc = Integer.parseInt(br.readLine());
        result = new int[tc];

        while(tc-- >0) {
            n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            st = new StringTokenizer(s);
            h = new int[n];

            for (int i = 0; i < n; i++) {
                h[i] = Integer.parseInt(st.nextToken());
            }
            result[tc] = solve(h,0,h.length-1);
        }

        for(int i=result.length-1 ; i>=0 ; i--){
            System.out.println(result[i]);
        }
    }

    public static int solve(int[] h,int left,int right){
        //기저사례 : 판자가 한개뿐인 경우
        if(left == right) return h[left];

        //왼 , 오른쪽으로 분할
        int mid = (left+right)/2;
        //부분문제1,2 분할
        int ret = Math.max(solve(h,left,mid) , solve(h,mid+1,right));

        //부분3 : 왼~오 부분에 걸쳐져 있는경우
        int lo = mid, hi = mid+1;
        int height = Math.min(h[lo], h[hi]);

        //부분3-1 : mid, mid+1 포함하는 넓이 2인 사각형 고려
        ret = Math.max(ret, height*2);

        //사각형 전체 덮을때까지 확장한다.
        while(left<lo || hi<right){
            //더 높이가 높은쪽으로 확장해 나간다.
            if(hi<right && ( lo==left || h[lo-1]<h[hi+1])){
                hi++;
                height=Math.min(height,h[hi]);
            }
            else{
                lo--;
                height=Math.min(height,h[lo]);
            }
            //확장 이후 사각형의 너비 구함.
            ret = Math.max(ret,height*(hi-lo+1));
        }

        return ret;
    }

}

```
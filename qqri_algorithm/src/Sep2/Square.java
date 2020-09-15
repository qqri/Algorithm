package Sep2;

public class Square {

    public long solution(int w, int h) {
        long answer = 1;
        // 전체 수 : w*h
        // 가장 작은 수 ? 최대 공약수 구한다.
        // 최대 공약수 구한 만큼
        long gc, aw, ah;
        gc =  (w > h)  ? gcd(w,h) : gcd(h,w);
        aw = (long)w/gc;
        ah = (long)h/gc;
        long ans1 = (long)w*h;
        long ans2 = (long)(aw + ah - 1) *gc;
        return ans1 -ans2 ;
    }

    public static long gcd(long a,long b){
        if(a % b == 0)
            return b;
        return gcd(b,a%b);
    }

}


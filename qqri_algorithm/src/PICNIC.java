import java.util.Scanner;
import java.lang.*;

public class PICNIC {

    private static  boolean[][] areFriends;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c,n,m;
        boolean[] visited;
        c = sc.nextInt(); //test case 수
        int[] result = new int[c];

        while(c-- >0) {
            n = sc.nextInt(); //학생 수
            m = sc.nextInt(); //학생 쌍 수
            visited = new boolean[n]; //학생 별로 친구 있는지 확인 넣었는지
            areFriends = new boolean[n][n]; //친구 인지 확인

            for (int i = 0; i < m; i++) {
                areFriends[sc.nextInt()][sc.nextInt()] = true;
            }
            result[c] = picnic(visited);
        }
        for(int i=c-1;i>=0;i--){ //c--로 해서 거꾸로 넣어짐 주의
            System.out.println(result[i]);
        }

    }

    public static int picnic(boolean[] visited){
        int n = visited.length;
        int remain = -1;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                remain = i;
                break;
            }
        }

        int resultMain = 0;

        if(remain==-1){ //만약에 나머지가 모두 true 면 위에서 break 되지 않은 채로 넘어올거니까
            return 1;
        }

        for(int i=remain+1;i<n;i++){ //이게 친구 수만큼 반복된다
            if( !visited[i] && areFriends[remain][i] ){  //remain친구 기준, remain 하고 나머지들이 친구인지 확인.
                visited[i] = visited[remain] = true;
                resultMain += picnic(visited);
                //이건 더 작은 단위로 넘어가는게 아니라 새롭게 visited가 true된것들이 있는채로 다시 넘어가서 재귀!
                visited[i] = visited[remain] = false;
                //다른 경우의 쌍 들도 계속해서 세야 하니까 하는것!!
            }
        }

        return resultMain; //최종적으로 얘가 반환되니까!!!끝난다.
    }

}

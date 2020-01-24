import java.io.*;

public class COVER {
    public static int[][] board;
    public static int[][][] coverType = {
            {{0,0},{1,0},{0,1}},
            {{0,0},{0,1},{1,1}},
            {{0,0},{1,0},{1,1}},
            {{0,0},{1,0},{1,-1}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        int[] result = new int[C]; //결과
        int H,W;
        while(C-->0){
            H = Integer.parseInt(br.readLine());
            W = Integer.parseInt(br.readLine());
            board= new int[H][W];

            for(int i=0;i<H;i++){
                String row = br.readLine().trim(); //다음 \n 을 제거하기 위함.
                for(int j=0;j<W;j++){
                    int ch = row.charAt(j);
                    if(ch == '#'){ //게임판 덮을 수 없는 경우는 1
                        board[i][j] = 1;
                    }
                    else{ //게임판 덮을 수 있는 경우는 0
                        board[i][j] = 0;
                    }
                }
            }
            result[C] = cover(board);
        }

        for(int i=C-1;i>=0;i--){
            bw.write(result[i]);
        }

        bw.close();
    }

    public static boolean set(int[][] board , int x , int y , int type, int delta){
        boolean ok = true;

        for(int i=0;i<3;i++){ //가능한 배치에서 coverType의 배치하는 보드가 총 3개니까
            int nx = x + coverType[type][i][0];
            int ny = y + coverType[type][i][1];
            //board.length 는 가로 길이
            //board[0].length 는 세로 길이 의미 한다.

            if(nx<0 || nx > board.length || ny<0 || ny > board[0].length ){
                ok = false;
            }else if ( board[nx][ny] + delta >=1 ) {
                //검은 칸이 쌓여 있을 경우(이렇게 하지 않으면 지울때 한꺼번에 지워지므로 쌓는다.)
                ok = false;
            }
        }
        return ok;
    }

    public static int cover(int[][] board){
        int x =-1, y =-1; //가장 왼쪽 위에 있는 빈칸 찾기위함.
        //보드의 왼쪽 위에서 부터 하나씩 찾기 시작
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==0){//왼쪽 가장 위에 있는 빈칸 찾음.
                    x=i;
                    y=j;
                    break;
                }
            }
            //빈칸을 찾은 이후에 다음 세로줄로 넘어가면 안되므로 -1이 아닌 경우엔
            //반복문을 나오도록 한다.
            if(x != -1)
                break;
        }

        int resultMain = 0;

        //기저사례 : 모든 빈칸이 채워지면 무조건 x 또는 y 중에 하나가 -1로 될것이므로
        if(x == -1) return 1;
        for(int type=0 ; type < 4 ; type++){
            if(set(board,x,y,type,1)){
                resultMain += cover(board);
            }
        set(board,x,y,type,-1); //블록을 다시 치운다.
        }
        return resultMain;
    }
}

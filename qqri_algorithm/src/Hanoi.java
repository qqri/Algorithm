import java.util.Scanner;

public class Hanoi {
    public static int answer = 0;
    public static StringBuilder sb = new StringBuilder();


    public static void moveHanoiTower(int num, int from, int by, int to) {
        ++answer;
        if(num == 1) {
            sb.append(from + " " + to + "\n");
        } else {
            // STEP 1 : num-1개를 A에서 B로 이동
            moveHanoiTower(num-1, from, to, by);
            // STEP 2 : 1개를 A에서 C로 이동
            sb.append(from + " " + to + "\n");
            moveHanoiTower(num-1, by, from, to);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        moveHanoiTower(num, 1, 2, 3);
        sb.insert(0, answer + "\n");
        System.out.println(sb);
    }
}
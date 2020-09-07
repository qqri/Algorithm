package Sep2;

import java.util.*;

class WordDict implements Comparable<WordDict>{
    String word;
    int cnt;
    public WordDict(String word) {
        this.word = word;
        this.cnt = 0;
    }

    @Override
    public int compareTo(WordDict o) {
        // 지금 들어온거 가 알파벳이 더 앞순이라면 양수
        if( this.cnt == o.cnt) return this.word.compareTo(o.word);
        else return this.cnt-o.cnt;
    }
}

public class Q52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        String[] ans = new String[n];
        WordDict temp;

        List<PriorityQueue<WordDict>> pqs = new ArrayList<>();

        for(int i = 0 ; i < 'z' - 'a' + 1 ; i++ ) {
            pqs.add(new PriorityQueue<>());
        }

        for(int i = 0 ; i < k ; i++ ) {
            String cur = sc.next();
            pqs.get(cur.charAt(0) - 'a').add(new WordDict(cur));
        }

        // 단어 게임 시작

        for(int i = 0 ; i < n ; i++ ) {
            String now = sc.next();
            temp = pqs.get(now.charAt(0) - 'a').poll();
            ans[i] = temp.word;
            temp.cnt ++;

            pqs.get(now.charAt(0) - 'a').offer(temp);
        }

    }

}

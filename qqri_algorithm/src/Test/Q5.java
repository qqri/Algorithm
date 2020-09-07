package Test;


import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Word implements Comparable<Word>{
    String word;
    int cnt;

    public Word(String word) {
        this.word = word;
        this.cnt = 0;
    }
    @Override
    public int compareTo(Word word) {
        // 알파벳 순으로 정렬
        if (this.cnt == word.cnt) return this.word.compareTo(word.word);
        // 말한게 적은 순으로 정렬
        else return this.cnt - word.cnt;
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k, n;
        String word, input;
        Word temp;

        List<PriorityQueue<Word>> que = new LinkedList<>();

        for(int i = 0 ; i < ('z' - 'a' + 1); i++) {
            que.add(new PriorityQueue<>());
        }

        k = sc.nextInt();
        n = sc.nextInt();

        for(int  i= 0 ; i < k ; i++ ) {
            word = sc.next();
            que.get( word.charAt(0) - 'a' ).add(new Word(word));
        }

        for(int i = 0 ; i < n ; i++ ){
            input = sc.next();

            temp = que.get(input.charAt(0) - 'a').poll();
            System.out.println(temp.word);

            // 횟수 증가 시키고 다시 넣음 .
            temp.cnt++;
            que.get(input.charAt(0)-'a').offer(temp);
        }



    }

}


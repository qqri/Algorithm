package Graph;

import java.util.*;

public class WordTransformation {
    public static void main(String[] args) {
        String[] words = {"hot","dot","lot","log","cog"};
        List<String> wordList = Arrays.asList(words);

        WordTransformation w = new WordTransformation();

        System.out.println(w.solution("hit" , "cog", wordList));

    }
    public int solution(String beginWord , String endWord , List<String> wordList) {

        //1
        if(wordList == null || !wordList.contains(endWord)) return 0;

        Queue<String> que = new LinkedList<>();

        Set<String> dict = new HashSet<>(wordList); // wordList에 중복되게 존재하는지 확인하기 위함.
        dict.add(endWord);
        dict.remove(beginWord);

        que.offer(beginWord);
        int level = 1;

        //2
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0 ; i < size ; i++) {
                String str = que.poll();
                if( str.equals(endWord) ) return level-1;

                for(String neighbor : neighbors( str , dict ) ) {
                    System.out.println("neighbor : " + neighbor);
                    que.offer(neighbor);
                }
            }
            level++;
        }

        return 0;
    }

    public List<String> neighbors( String str, Set<String> dict) {
        List<String> res = new ArrayList<>();

        for(int i = 0 ; i < str.length() ; i++ ) {
            char[] chars = str.toCharArray();
            for(char ch = 'a' ; ch <= 'z' ; ch++ ) {
                chars[i] = ch;
                String word = new String(chars);
                if( dict.remove(word) ) { // dict에서 삭제 하면서 반환한다.
                    res.add(word);
                }
            }
        }

        return res;
    }
}

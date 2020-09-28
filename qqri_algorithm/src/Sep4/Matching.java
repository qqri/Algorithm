package Sep4;

import java.util.*;

class HomePage {
    String url;
    double score;
    List<String> list;
    public HomePage(String url, double score , List<String> list ) {
        this.url = url;
        this.score = score;
        this.list = list;
    }
}
class Matching {
    static String match = "[^a-z]";
    public int solution(String w, String[] pages) {
        //1
        int len = pages.length;
        Map<HomePage , Double > map = new HashMap<>(); //hp 정보, 나를 가리킨 수

        String cur , body, postLink, word;
        word = w.toLowerCase();

        for(int i = 0 ; i < pages.length ; i++ ) {
            cur = pages[i].toLowerCase();
            //String curUrl = cur.substring( cur.indexOf("https"), cur.indexOf("\"/>") );
            StringBuilder sb = new StringBuilder(cur);
            int mid = 0, posl = 0, posr = 0;
            while(mid <= posl) {
                posl = sb.indexOf("<meta", posl+1); // +1 을해야 똑같은걸 안찾는다.
                posr = sb.indexOf(">", posl);
                mid = sb.lastIndexOf("https://", posr); //뒤에서부터 찾는다.
            }
            posr = sb.indexOf("\"", mid);
            String curUrl = sb.substring(mid, posr);


            pages[i] = curUrl;
            body = cur.substring( cur.indexOf("<body>")+5 , cur.indexOf("</body>") );
            List<String> list = new ArrayList<>();
            double curScore = 0.0;

            String bodys[] = body.split("<a ");
            for(String s : bodys) {
                if(s.startsWith("href")) {
                    list.add( s.substring( s.indexOf("https://") , s.indexOf("\">")) );
                    postLink = s.substring( s.indexOf("</a>") , s.length() );
                    curScore += cntMatch(postLink , word);
                } else {
                    curScore += cntMatch(s , word);
                }
            }

            HomePage hp = new HomePage( curUrl , 0 , list );
            if(list.size() != 0) {
                hp = new HomePage( curUrl , (double)curScore/list.size() , list );
            }
            map.put(hp , curScore );
        }

        double[] ans = new double[len];
        for(int i = 0 ; i < len ; i++ ) {
            String tempUrl = pages[i];
            for(HomePage h : map.keySet()) {
                if( !tempUrl.equals(h.url)) {
                    continue;
                }
                else {
                    List<String> tempList = h.list;
                    for(String temp : tempList) {
                        for(HomePage p : map.keySet()) { //p는 h의 리스트 안에 있는 것들.
                            if( !p.url.equals(temp)) continue;
                            else {
                                double now = map.get(p) + h.score;
                                map.put( p , now );
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0 ; i < len ; i++ ) {
            String nowUrl = pages[i];
            for(HomePage hh : map.keySet()) {
                if(nowUrl.equals(hh.url)) {
                    ans[i] = map.get(hh);
                    break;
                }
            }

        }
        int answer = 0;
        for(int i = 0 ; i < len; i++) {
            if(ans[answer]<ans[i]) answer = i;
        }
        return answer;
    }

    public static double cntMatch(String str, String word) {
        str = str.replaceAll(match , " ");
        String strs[] = str.split(" ");
        double cnt = 0.0;

        for(String wordS : strs ) {
            if(wordS.equals(word)) {
                cnt=cnt+1;
            }
        }
        return cnt;
    }
}

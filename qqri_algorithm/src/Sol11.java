import java.util.*;
public class Sol11 {
    static int cnt = 0 ;
    public static void main(String[] args) {
        HashMap<String, String> dic = new HashMap<>();

        dic.put("오늘" , "today");
        dic.put("내일" , "tomorrow");
        dic.put("어제" , "yesterday");
        dic.put("책상", "desk");
        dic.put("즐거음", "joy");

        for(String key : dic.keySet() ) {
            String val = dic.get(key);
            System.out.println(key + " : " + val);
        }

    }

}


package StringArray;

import java.io.IOException;
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) throws NumberFormatException, IOException {

        String[] strList = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = solve(strList);

        for(List<String> list: result) {
            for(String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

/*
* 자유자재로 바뀌는 데이터 구조의 경우엔 어떻게 담을 그릇? 을 설정하면 좋을 지 ?? -> 리스트 안에 리스트 구조
* map 도 !!! map<key, value>  - > 리스트 만들고 나중에 넣는다. 아니면 get.put 해서 넣는다.
*
* 키가 동일한 값이란 것을 알면 된다. ->
*
* */

    public static List<List<String>> solve(String[] strList) {
        //1
        List<List<String>> result = new ArrayList<>();

        Map<String ,  List<String> > map = new HashMap<>();

        for(String str : strList) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);

            if(map.containsKey(key)) {
                map.get(key).add(str); //이렇게만해도 list에 더해져서 반영된다.
//                List<String> list = map.get(key);
//                list.add(str);
//                map.put(key , list);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }

        }

        result.addAll(map.values());
        return result;
    }

}

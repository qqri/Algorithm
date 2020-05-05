# 문제
[핸드폰번호 문제](https://programmers.co.kr/learn/courses/30/lessons/42577)
<br>출처 : 프로그래머스
<br><br>
시간 제한 걸려서 틀렸었는데 <br>
startsWith나 contains 쓰면 for문 한번만 써서 충분히 풀 수 있는 것 같다.

# 코드
```java
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        String check, other;
        ArrayList<String> phoneList = new ArrayList<>();

        //리스트에 우선 다 넣음
        for(String p : phone_book) {
            phoneList.add(p);
        }
        for(int i = 0 ; i < phoneList.size() ; i++) {
            check = phoneList.get(i); // 우선 체크하는 번호
            for(int j = 0 ; j < phoneList.size() ; j++) {
                if( j == i ) continue; //본인 번호인 경우 넘긴다.
                other = phoneList.get(j);

                if( check.length() > other.length()) continue; //체크하는 길이가 더 작은 경우도 넘김

                other = other.substring(0 , check.length() ); //앞부분까지 자름
                if( other.equals(check)) answer = false;

            }

        }

        return answer;
    }
}
```
<br>
# startWith , contains 사용한 다른 풀이

```java

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        boolean result = true;
        for (int i=0; i<phoneBook.length-1; i++) {
            if (phoneBook[i+1].contains(phoneBook[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}

class Solution {
    public boolean solution(String[] phoneBook) {
       for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return true;
    }
}
```
# 문제
[가장큰 수 문제](https://programmers.co.kr/learn/courses/30/lessons/42746)
<br>출처 : 프로그래머스
<br><br>
자바로 해결못함.. ㅠㅠ

# 코드1 - 정답 (파이썬)

```python
def solution(numbers):
    answer=""
    numberStr=[]
    for i,value in enumerate(numbers):
        st = str(value)
        stri = st*3
        numberStr.append([stri,i])

    numberStr.sort(reverse=True)
    for i,value in enumerate(numberStr):
        index = value[1]
        answer += str(numbers[index])


    for value in answer:
        if value!='0':
            return answer

    return "0"
```
<br>
# 코드 2 - 자바

```java
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "" ;
        String[][] ans = new String[numbers.length][2];

        for(int i=0 ; i<numbers.length; i++) {
            ans[i][0] = String.valueOf(numbers[i]) + String.valueOf(numbers[i]);
            ans[i][1] = String.valueOf(i);
        }

        Arrays.sort(ans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });

        for(int i=numbers.length-1 ; i >= 0 ; i-- ){
            int index = Integer.valueOf(ans[i][1]);
            answer += numbers[index];
        }

        if(Integer.valueOf(answer) == 0) return "0";

        return answer;
    }
}

```

<br>
# 코드 3 - 자바 , 완전탐색& 시간초과뜸

```java
import java.util.*;

class Solution {
    ArrayList<String> ansList = new ArrayList<>();
    ArrayList<String> ansN = new ArrayList<>(); //인덱스 목록

    public String solution(int[] numbers) {
        String numS="";

        for(int i=0 ;i<numbers.length; i++) {
                numS += String.valueOf(i);
        }
        permutation( "" , String.valueOf(numS)); //ansN에 모든 인덱스가 들어 있는 상황

        for(int i=0 ; i < ansN.size() ; i++ ){
             String index = ansN.get(i);
             String number = "";
             for(int j=0 ; j<numS.length() ; j++ ){
                 int pre = numbers[ Integer.valueOf(index.charAt(j) - '0') ];
                 number = number + String.valueOf(pre);
             }
             ansList.add(number);
         }

        Collections.sort(ansList);
        String answer =ansList.get(ansList.size()-1);

        if( String.valueOf(answer.charAt(0)-'0').equals("0")) answer = "0";
        return answer;
    }

    public void permutation(String prefix, String str ){
        if(str.length() == 0) ansN.add(prefix);
        for(int i=0 ; i < str.length() ; i++ ) {
            permutation(prefix + str.charAt(i) , str.substring(0,i)+str.substring(i+1,str.length() ));
        }
    }

}
```
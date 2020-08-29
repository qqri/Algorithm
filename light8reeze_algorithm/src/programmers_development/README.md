## 문제
[문제 출처](https://programmers.co.kr/learn/courses/30/lessons/42586)  

## 코드

```cpp
#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds)
{
    vector<int> answer;
    vector<int> deploy;
    
    for(int index = 0; index < progresses.size(); ++index)
    {
        int remain = 100 - progresses[index];
        int day = remain / speeds[index];
        day = (remain % speeds[index] != 0)? day + 1 : day;
        
        if(index == 0)
        {
            deploy.emplace_back(day);
            continue;
        }
        
        if(deploy[index - 1] >= day)
            day = deploy[index - 1];
        
        deploy.emplace_back(day);
    }
    
    int cnt = 0;
    int day = 0;
    for(int index = 0; index < deploy.size(); ++index)
    {
        if(index == 0)
        {
            day = deploy[index];
            cnt = 1;
            continue;
        }
        
        if(day == deploy[index])
        {
            ++cnt;
        }
        else
        {
            answer.emplace_back(cnt);
            day = deploy[index];
            cnt = 1;
        }
    }
    answer.emplace_back(cnt);
    
    return answer;
}
```

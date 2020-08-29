## 문제
[문제 출처](https://programmers.co.kr/learn/courses/30/lessons/43162)  

## 코드

```cpp
#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

class node
{
public:
	int data = 0;
	bool visited = false;
	class edge* adjancency_list = nullptr;
};

class edge
{
public:
	node* from = nullptr;
	node* to = nullptr;
	edge* next = nullptr;
};

class network
{
	std::vector<node> node_list;
	std::vector<edge> edge_list;

public:
	void InitNetwork(int n, vector<vector<int>>& computers)
	{
		for (int index = 0; index < n; ++index)
		{
			node aNode;
			aNode.data = index;
			aNode.visited = false;
			node_list.emplace_back(aNode);
		}

		edge_list.reserve(n * n);
		for (int y = 0; y < computers.size(); ++y)
		{
			auto& comp = computers[y];
			auto& aNode = node_list[y];
			for (int x = 0; x < comp.size(); ++x)
			{
				if (x == y)
					continue;

				if (comp[x] == 0)
					continue;

				edge aEdge;
				aEdge.from = &(aNode);
				aEdge.to = &(node_list[x]);
				edge_list.emplace_back(aEdge);

				auto newIndex = edge_list.size() - 1;
				auto& newEdge = edge_list[newIndex];

				auto aAdj = aNode.adjancency_list;
				if (aAdj == nullptr)
				{
					aNode.adjancency_list = &newEdge;
					continue;
				}

				while (aAdj->next != nullptr)
				{
					aAdj = aAdj->next;
				}
				aAdj->next = &newEdge;
			}
		}
	}

	void DFS(node* pNode)
	{
		pNode->visited = true;

		if (pNode->adjancency_list == nullptr)
		{
			return;
		}

		auto aEdge = pNode->adjancency_list;
		while (aEdge != nullptr)
		{
			if (aEdge->to->visited == true)
			{
				aEdge = aEdge->next;
				continue;
			}

			DFS(aEdge->to);
			aEdge = aEdge->next;
		}
	}

	int getNetworkCnt()
	{
		int result = 0;

		for (auto& aNode : node_list)
		{
			if (aNode.visited == true)
				continue;

			DFS(&aNode);

			++result;
		}

		return result;
	}
};

int solution(int n, vector<vector<int>> computers)
{
	int answer = 0;
	network aNetwork;
	aNetwork.InitNetwork(n, computers);
	answer = aNetwork.getNetworkCnt();
	return answer;
}
```

## 문제
[문제 출처](https://www.acmicpc.net/problem/15683)  

## 입력
첫째 줄에 사무실의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 8)

둘째 줄부터 N개의 줄에는 사무실 각 칸의 정보가 주어진다. 0은 빈 칸, 6은 벽, 1~5는 CCTV를 나타내고, 문제에서 설명한 CCTV의 종류이다.

CCTV의 최대 개수는 8개를 넘지 않는다.

## 출력
첫째 줄에 사각 지대의 최소 크기를 출력한다.

### 예제 입력
```
4 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 6 0
0 0 0 0 0 0
```
### 예제 출력

```
20
```

### 코드

```cpp
#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

struct Scctv
{
	int nType = 0;
	int nPos = 0;
	int nDirType = -1;
	int nDir[4] = { -1, };
};

void SetMapView(int* map, int width, int height, int index, int dir, bool isActive)
{
	int nSetValue = (isActive) ? -1 : 1;
	int nPosX = index % width;
	int nPosY = index / width;

	switch (dir)
	{
	case 0:
		for (int i = nPosY - 1; i >= 0; --i)
		{
			int& nowPos = map[i * width + nPosX];
			if (nowPos == 6)
				break;
			else if (nowPos > 0 && nowPos < 6)
				continue;

			nowPos += nSetValue;
		}
		break;

	case 1:
		for (int i = nPosX + 1; i < width; ++i)
		{
			int& nowPos = map[i + nPosY * width];
			if (nowPos == 6)
				break;
			else if (nowPos > 0 && nowPos < 6)
				continue;

			nowPos += nSetValue;
		}
		break;

	case 2:
		for (int i = nPosY + 1; i < height; ++i)
		{
			int& nowPos = map[i * width + nPosX];
			if (nowPos == 6)
				break;
			else if (nowPos > 0 && nowPos < 6)
				continue;

			nowPos += nSetValue;
		}
		break;

	case 3:
		for (int i = nPosX - 1; i >= 0; --i)
		{
			int& nowPos = map[i + nPosY * width];
			if (nowPos == 6)
				break;
			else if (nowPos > 0 && nowPos < 6)
				continue;

			nowPos += nSetValue;
		}
		break;
	}
}

void SetDirByCCTV(Scctv* cctv, int dir)
{
	cctv->nDirType = dir;
	::memset(cctv->nDir, -1, sizeof(int) * 4);

	switch (cctv->nType)
	{
	case 1:
		cctv->nDir[0] = dir;
		break;

	case 2:
		cctv->nDir[0] = dir;
		cctv->nDir[1] = (dir + 2) % 4;
		break;

	case 3:
		cctv->nDir[0] = dir;
		cctv->nDir[1] = (dir + 1) % 4;
		break;

	case 4:
		cctv->nDir[0] = (dir + 1) % 4;
		cctv->nDir[1] = (dir + 2) % 4;
		cctv->nDir[2] = (dir + 3) % 4;
		break;

	case 5:
		cctv->nDir[0] = dir;
		cctv->nDir[1] = (dir + 1) % 4;
		cctv->nDir[2] = (dir + 2) % 4;
		cctv->nDir[3] = (dir + 3) % 4;
		break;
	}
}

int GetBlindSpotCnt(int* map, int width, int height)
{
	int nResult = 0;

	for (int index = 0; index < width * height; ++index)
	{
		if (map[index] == 0)
			++nResult;
	}
	return nResult;
}

int GetResult(int* map, int width, int height, Scctv* cctv, int cctvIndex, int cnt)
{
	int nResult = 0x7FFFFFFF;

	if (cctvIndex == cnt)
		return GetBlindSpotCnt(map, width, height);

	Scctv& aCCTV = cctv[cctvIndex];
	for (int index = 0; index < 4; ++index)
	{
		SetDirByCCTV(&aCCTV, index);

		for (int c = 0; c < 4; ++c)
		{
			if (aCCTV.nDir[c] == -1)
				break;

			SetMapView(map, width, height, aCCTV.nPos, aCCTV.nDir[c], true);
		}

		int aResult = GetResult(map, width, height, cctv, cctvIndex + 1, cnt);

		nResult = std::min(aResult, nResult);

		for (int c = 0; c < 4; ++c)
		{
			if (aCCTV.nDir[c] == -1)
				break;

			SetMapView(map, width, height, aCCTV.nPos, aCCTV.nDir[c], false);
		}
	}

	return nResult;
}

int main()
{
	int n, m;
	int* map;
	Scctv cctv[8];

	cin >> n;
	cin >> m;

	map = new int[n * m];

	int index = 0;
	int cctvCnt = 0;
	while (index < (n * m))
	{
		cin >> map[index];

		if (map[index] >= 1 && map[index] <= 5)
		{
			cctv[cctvCnt].nType = map[index];
			cctv[cctvCnt++].nPos = index;
		}
		++index;
	}

	cout << GetResult(map, m, n, cctv, 0, cctvCnt) << endl;
	delete[] map;

	return 0;
}
```

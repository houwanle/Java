package ByteDance20180812;
/*
    世界杯开幕式会在球场C举行，球场C的球迷看台可以容纳M*N个球迷。
    在球场售票完成后，现官方想统计此次开幕式一共有多少球队球迷群体，
    最大的球队球迷群体有多少人。
    经调研发现，球迷群体在选座时有以下特性：
        1.同球队的球迷群体会选择相邻座位，不同球队的球迷群体会选择
          不相邻的座位。（注解：相邻包括前后相邻、左右相邻、斜对角
          相邻）
        2.给定一个M*N的二维球场，0代表该位置没有坐人，1代表该位置
          已有球迷，希望输出球队群体个数P，最大的球队群体人数Q。

    输入描述：
    第一行，2个数字，M及N，使用英文逗号分割；
    接下来M行，每行N的数字，使用英文逗号分割；
    输出描述：
    一行，2个数字，p及Q，使用英文逗号分割；
    其中，p表示球队群体个数，Q表示最大的球队群体人数

    示例
    输入：
    10 10
    0,0,0,0,0,0,0,0,0,0
    0,0,0,1,1,0,1,0,0,0
    0,1,0,0,0,0,0,1,0,1
    1,0,0,0,0,0,0,0,1,1
    0,0,0,1,1,1,0,0,0,1
    0,0,0,0,0,0,1,0,1,1
    0,1,1,0,0,0,0,0,0,0
    0,0,0,1,0,1,0,0,0,0
    0,0,1,0,0,1,0,0,0,0
    0,1,0,0,0,0,0,0,0,0
    输出：
    6,8
    备注：
    数据范围：
    0<M<1000
    0<N<1000

 */
public class Test1 {
}

/*C++实现

#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <algorithm>
using namespace std;
int bfs(const vector<vector<int>>& matrix, vector<vector<int>>& state, int i, int j);
int main()
{
	//freopen("test.txt", "r", stdin);
	int m, n;
	int count = 0; //统计共有多少群体
	int count2 = 0; //统计最大群体有多少人

	scanf("%d,%d", &m, &n);
	vector<vector<int>> matrix(m, vector<int>(n, 0));
	vector<vector<int>> state(m, vector<int>(n, 0));

	for (int i = 0; i < m; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			if (j != n - 1)
				scanf("%d,", &matrix[i][j]);
			else
			{
				scanf("%d", &matrix[i][j]);
			}
		}
	}
	for (int i = 0; i < m; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			if (state[i][j] == 0 && matrix[i][j] == 1)
			{
				count++;
				int tmp = bfs(matrix, state, i, j);
				count2 = max(count2, tmp);
			}
		}
	}
	cout << count << "," << count2 << endl;
	return 0;
}

int bfs(const vector<vector<int>>& matrix, vector<vector<int>>& state, int i, int j)
{
	queue<pair<int, int>> group;
	int ret = 0;
	int m = matrix.size();
	int n = matrix[0].size();
	group.push(pair<int, int>(i, j));
	state[i][j] = 1;
	while (!group.empty())
	{
		pair<int, int> cur = group.front();
		int x = cur.first;
		int y = cur.second;
		group.pop();
		ret++;
		if (x - 1 >= 0 && matrix[x - 1][y] == 1 && state[x - 1][y] == 0)
		{
			group.push(pair<int, int>(x - 1, y));
			state[x - 1][y] = 1;
		}
		if (x + 1 < m && matrix[x + 1][y] == 1 && state[x + 1][y] == 0)
		{
			group.push(pair<int, int>(x + 1, y));
			state[x + 1][y] = 1;
		}
		if (y - 1 >= 0 && matrix[x][y - 1] == 1 && state[x][y - 1] == 0)
		{
			group.push(pair<int, int>(x, y - 1));
			state[x][y - 1] = 1;
		}
		if (y + 1 < n && matrix[x][y + 1] == 1 && state[x][y + 1] == 0)
		{
			group.push(pair<int, int>(x, y + 1));
			state[x][y + 1] = 1;
		}
		if (y - 1 >= 0 && x - 1 >= 0 && matrix[x - 1][y - 1] == 1 && state[x - 1][y - 1] == 0)
		{
			group.push(pair<int, int>(x - 1, y - 1));
			state[x - 1][y - 1] = 1;
		}
		if (y - 1 >= 0 && x + 1 < m && matrix[x + 1][y - 1] == 1 && state[x + 1][y - 1] == 0)
		{
			group.push(pair<int, int>(x + 1, y - 1));
			state[x + 1][y - 1] = 1;
		}
		if (y + 1 < n && x + 1 < m && matrix[x + 1][y + 1] == 1 && state[x + 1][y + 1] == 0)
		{
			group.push(pair<int, int>(x + 1, y + 1));
			state[x + 1][y + 1] = 1;
		}
		if (y + 1 < n && x - 1 >= 0 && matrix[x - 1][y + 1] == 1 && state[x - 1][y + 1] == 0)
		{
			group.push(pair<int, int>(x - 1, y + 1));
			state[x - 1][y + 1] = 1;
		}
	}
	return ret;
}

 */

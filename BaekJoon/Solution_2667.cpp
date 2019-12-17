#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

int map[26][26];
bool visited[26][26];
int nx, ny, N;
int dx[4] = {-1, 1, 0, 0}, dy[4] = {0, 0, 1, -1};

int DangeNumbering(int x, int y)
{
    queue<pair<int, int> > queue;
    int count = 1;

    visited[x][y] = true;
    queue.push(make_pair(x, y));

    while (!queue.empty())
    {
        pair<int, int> temp = queue.front();
        queue.pop();

        for (int i = 0; i < 4; i++)
        {
            nx = dx[i] + temp.first;
            ny = dy[i] + temp.second;

            if (0 <= nx && nx < N && 0 <= ny && ny < N)
            {
                if (!visited[nx][ny] && map[nx][ny] != 0)
                {
                    queue.push(make_pair(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = 0;
                    count++;
                }
            }
        }
    }

    return count;
}

int main()
{
    vector<int> area;
    ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cin >> N;

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
            scanf("%1d", &map[i][j]);
    }

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (!visited[i][j] && map[i][j] != 0)
                area.push_back(DangeNumbering(i, j));
        }
    }

    sort(area.begin(), area.end());
    cout << area.size();
    for (int i = 0; i < area.size(); i++)
        cout << endl << area[i];

    return 0;
}
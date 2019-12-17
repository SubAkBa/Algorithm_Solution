#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int N, M, nx, ny, maxnum = 1;
int map[1001][1001];
queue<pair<int, int>> start;
int dx[4] = {-1, 1, 0, 0}, dy[4] = {0, 0, 1, -1};

void Tomato_Ripe()
{
    while (!start.empty())                   // 근처에 익을 수 있는 토마토가 없을 때까지
    {
        pair<int, int> temp = start.front(); // start 벡터 원소를 하나씩 사용
        start.pop();

        for (int i = 0; i < 4; i++)          // 동, 서, 남, 북 위치를 조회
        {
            nx = dx[i] + temp.first;         // 다음 x 좌표
            ny = dy[i] + temp.second;        // 다음 y 좌표

            if (0 <= nx && nx < M && 0 <= ny && ny < N)
            {
                if (map[nx][ny] == 0)        // 토마토가 아직 익지 않았다면
                {
                    map[nx][ny] = map[temp.first][temp.second] + 1; // 이전 걸린 일 수 + 1
                    start.push(make_pair(nx, ny));                  // 그 지점에서 다시 토마토가 익으므로
                    maxnum = max(map[nx][ny], maxnum);              // 모두 익는 최소 날짜는 곧 상재에서 가장 큰 수
                }
            }
        }
    }

    for (int i = 0; i < M; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (map[i][j] == 0)     // 아직 익지 않은 토마토가 있다면
                maxnum = 0;         // 불가능
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M;

    for (int i = 0; i < M; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> map[i][j];
            if (map[i][j] == 1)
                start.push(make_pair(i, j)); // 토마토가 익은 시작 좌표 저장
        }
    }

    Tomato_Ripe();
    
    cout << maxnum - 1;

    return 0;
}
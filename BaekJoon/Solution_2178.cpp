#include <iostream>
#include <queue>

using namespace std;

int N, M, nx, ny;
int map[101][101];
bool visited[101][101];
int dx[4] = {-1, 1, 0, 0}, dy[4] = {0, 0, 1, -1}; // 동, 서, 남, 북으로 가기 위해 더해줄 좌표

void BFS(int startx, int starty)
{
    queue<pair<int, int> > queue;

    visited[startx][starty] = true;          // 시작 지점인 (0, 0) 방문 여부를 true로 변경
    queue.push(make_pair(startx, starty));   // 큐에 (0, 0)을 삽입한다.

    while (!queue.empty())                   // 큐가 빌때까지 수행
    {
        pair<int, int> temp = queue.front(); // 큐의 맨 앞 원소를 temp에 담는다.
        queue.pop();                         // 맨 앞 원소를 뺀다.

        for (int i = 0; i < 4; i++)          // 인접합 동, 서, 남, 북 조회
        {
            nx = dx[i] + temp.first;         // 다음 x좌표
            ny = dy[i] + temp.second;        // 다음 y좌표

            if (0 <= nx && nx < N && 0 <= ny && ny < M)   // 다음 좌표가 미로 내부에 존재하는지
            {
                if (!visited[nx][ny] && map[nx][ny] == 1) // 아직 방문하지 않았으며, 지나갈 수 있는지
                {
                    visited[nx][ny] = true;                         // 방문 표시
                    map[nx][ny] = map[temp.first][temp.second] + 1; // 지나온 거리를 저장하기 위해
                    queue.push(make_pair(nx, ny));                  // 다음 좌표를 지나기 위해 큐에 삽입
                }
            }
        }
    }

    return;
}

int main()
{

    cin >> N >> M;

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
            scanf("%1d", &map[i][j]);
    }

    BFS(0, 0);

    cout << map[N - 1][M - 1];

    return 0;
}
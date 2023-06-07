import sys
from collections import deque
input = sys.stdin.readline


def bfs(n, x_0, y_0, x_1, y_1):
    visited = [[0 for _ in range(n)] for _ in range(n)]
    Q = deque()
    Q.append([x_0, y_0])

    while Q:
        [x, y] = Q.popleft()
        if (x, y) == (x_1, y_1):
            print(visited[x_1][y_1])
            break
        for (nx, ny) in [(x-2, y-1), (x-2, y+1), (x-1, y-2), (x-1, y+2), (x+1, y-2), (x+1, y+2), (x+2, y-1), (x+2, y+1)]:
            if nx in range(n) and ny in range(n) and not visited[nx][ny]:
                visited[nx][ny] = visited[x][y] + 1
                Q.append([nx, ny])

t = int(input())

for _ in range(t):
    n = int(input())
    x_0, y_0 = map(int, input().split())
    x_1, y_1 = map(int, input().split())
    bfs(n, x_0, y_0, x_1, y_1)
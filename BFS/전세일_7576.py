import sys
from collections import deque
input = sys.stdin.readline

m, n = map(int, input().split())
data = []

for _ in range(n):
    data.append(list(map(int, input().split())))

Q = deque()
for i in range(n):
    for j in range(m):
        if data[i][j] == 1:
            Q.append([i, j])


def bfs(graph):
    while Q:
        [x, y] = Q.popleft()
        for (nx, ny) in [(x-1, y), (x+1, y), (x, y-1), (x, y+1)]:
            if nx in range(n) and ny in range(m):
                if graph[nx][ny] == 0:
                    graph[nx][ny] = graph[x][y] + 1
                    Q.append([nx, ny])


bfs(data)

result = 0
for i in range(n):
    for j in range(m):
        if data[i][j] == 0:
            print(-1)
            exit(0)
        result = max(result, data[i][j])

print(result - 1)
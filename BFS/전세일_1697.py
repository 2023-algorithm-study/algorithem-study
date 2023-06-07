import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())

visited = [0 for _ in range(int(1e5+1))]
Q = deque()
Q.append(n)

while Q:
    x = Q.popleft()
    if x == k:
        print(visited[x])
        break
    for nx in (x-1, x+1, 2* x):
        if nx in range(int(1e5+1)) and not visited[nx]:
            visited[nx] = visited[x] + 1
            Q.append(nx)
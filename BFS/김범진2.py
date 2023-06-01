import sys
from collections import deque
input = sys.stdin.readline

n, m, r = map(int, input().split())
graph = [[] for i in range(n+1)]
visited = [False] * (n+1)
sequence_num =[0]*(n+1)

for i in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

for i in graph:
    i.sort()

q = deque()
cnt = 1
def bfs(visited,start,graph):
    global cnt
    visited[start] = True
    q.append(graph[start])
    sequence_num[start] = cnt
    while q:

        next = q.popleft()
        for i in next:
            if not visited[i]:
                visited[i] = True
                cnt += 1
                sequence_num[i] = cnt
                q.append(graph[i])

bfs(visited,r,graph)
print(*sequence_num[1:],sep='\n')
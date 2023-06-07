import sys
from collections import deque
input = sys.stdin.readline

n, m, r = map(int, input().split())
data = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    data[a].append(b)
    data[b].append(a)

for x in range(n+1):
    data[x].sort(reverse=True)

cnt_list = [0 for _ in range(n+1)]

q = deque()
q.extend(data[r])
cnt = 1
cnt_list[r] = cnt

while q:
    x = q.popleft()
    if not cnt_list[x]:
        cnt += 1
        cnt_list[x] = cnt
        q.extend(data[x])

for x in range(1, n+1):
    print(cnt_list[x])
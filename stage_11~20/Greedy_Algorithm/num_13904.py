import sys
import heapq

n = int(sys.stdin.readline())
project = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

project = sorted(project, reverse=True)

ans = 0
decision = []
m = project[0][0]

for i in range(m, 0, -1):
    for j in range(len(project)):
        if project[j][0] == i:
            heapq.heappush(decision, -project[j][1])
    
    if decision:
        ans -= heapq.heappop(decision)
        
print(ans)
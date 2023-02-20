import sys

n = int(sys.stdin.readline())
project = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

project = sorted(project, reverse=True)

ans = 0
decision = []
m = project[0][0]

for i in range(m, 0, -1):
    for j in range(len(project)):
        if project[j][0] == i:
            decision.append(project[j][1])
    
    if decision:
        decision = sorted(decision)
        ans += decision.pop()
        
print(ans)
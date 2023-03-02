import sys
from collections import Counter

n = int(sys.stdin.readline())
file = [sys.stdin.readline().rstrip().split('.') for _ in range(n)]

file_name = []
for i in range(len(file)):
    file_name.append(file[i][1])

ans = Counter(file_name)
keys = sorted(ans)

for j in keys:
    print(j, ans[j])
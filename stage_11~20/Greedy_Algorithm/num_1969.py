import sys
from collections import Counter

n, m = map(int, sys.stdin.readline().split())
dna = [sys.stdin.readline().rstrip() for _ in range(n)]
dna_list = [[] for _ in range(n)]
tmp = [[] for _ in range(m)]
res = ''
cnt = 0

for i in range(n):
    for j in dna[i]:
        dna_list[i].append(j)

for x in range(m):
    for y in range(n):
        tmp[x].append(dna_list[y][x])
           
    counter = Counter(sorted(tmp[x])).most_common(1)
    res += str(counter[0][0])
    cnt += n - counter[0][1]

print(res, cnt, sep = '\n')
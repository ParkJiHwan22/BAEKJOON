import sys
from collections import Counter
input = sys.stdin.readline

N, M = map(int, input().split())
ls_list = [input().rstrip() for i in range(N+M)]
test_list = set(ls_list)
ls_dict = Counter(ls_list)

cnt = 0
result = []
for i in test_list:
    if ls_dict[i] == 2:
        result.append(i)
        cnt += 1

result = sorted(result)
print(cnt)
print(*result, sep='\n')
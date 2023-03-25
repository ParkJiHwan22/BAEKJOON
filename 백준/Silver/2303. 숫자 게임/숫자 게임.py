from itertools import combinations

n = int(input())
sum_rank, top_rank = 0, 0
for _ in range(1, n+1):
    num_list = list(map(int, input().split()))
    
    combi = list(combinations(num_list, 3))
    res = []
    for i in combi:
        res.append(sum(i) % 10)
        res = sorted(res, reverse=True)
   
    if res[0] >= sum_rank:
        top_rank = _
        sum_rank = res[0]

print(top_rank)
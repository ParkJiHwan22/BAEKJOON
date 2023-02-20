from itertools import permutations

n, m = map(int, input().split())
num_list = [i for i in range(1, n+1)]
combi = list(permutations(num_list, m))

for x in range(len(combi)):
    print(*combi[x])
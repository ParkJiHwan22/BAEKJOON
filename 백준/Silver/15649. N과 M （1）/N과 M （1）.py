from itertools import permutations

n, m = map(int, input().split())
num_list = []

for i in range(1, n+1):
    num_list.append(i)

permu = list(permutations(num_list,m))

for i in range(len(permu)):
    print(*permu[i])
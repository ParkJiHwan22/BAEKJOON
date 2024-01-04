from itertools import combinations_with_replacement
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
num_list = list(map(int, input().split()))

num_list = sorted(num_list)

combi = combinations_with_replacement(num_list, m)
tmp = sorted(list(set(combi)))

for y in tmp:  
    print(*y)
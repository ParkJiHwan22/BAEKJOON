import sys

n = int(sys.stdin.readline())
num_list = list(map(int, sys.stdin.readline().split()))

tmp_lst = sorted(list(set(num_list)))
tmp_dict = {}

for i in range(len(tmp_lst)):
    tmp_dict[tmp_lst[i]] = i

for j in num_list:
    print(tmp_dict[j], end=' ')
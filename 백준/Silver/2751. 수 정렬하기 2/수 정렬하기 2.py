import sys

T = int(input())
num_list = [int(sys.stdin.readline()) for i in range(T)]

num_list.sort()
print(*num_list, sep='\n')
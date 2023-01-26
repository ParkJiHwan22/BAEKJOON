import sys

n = int(sys.stdin.readline())
num_list = list(map(int, input().split()))
m = int(sys.stdin.readline())
find_list = list(map(int, input().split()))

num_dict = {}
for i in num_list:
    num_dict[i] = 0

for j in find_list:
    if j in num_dict:
        print(1)
    else:
        print(0)
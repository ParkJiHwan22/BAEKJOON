import sys

n = int(sys.stdin.readline())
num_list = [int(sys.stdin.readline()) for _ in range(n)]
total_max = 0

num_list = sorted(num_list)
for i in range(len(num_list)):
    total = (num_list[i] * (len(num_list) - i))
    if total > total_max:
        total_max = total

print(total_max)
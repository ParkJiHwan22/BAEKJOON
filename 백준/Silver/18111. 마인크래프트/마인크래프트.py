import sys

n, m, b = map(int, sys.stdin.readline().split())
ground = [list(map(int, sys.stdin.readline().split()))for _ in range(n)]

block = b
for x in ground:
    block += sum(x)
limit_floor = (block //(n * m)) + 1

ground_dict = {}
for y in range(257):
    ground_dict[y]= 0

for i in range(n):
    for j in range(m):
        ground_dict[ground[i][j]] += 1

min_time = 100000000
for k in range(limit_floor):
    time = stack_time = pop_time = 0
    for cnt in range(257):
        if cnt > k:
            stack_time += (cnt - k) * ground_dict[cnt]
        else:
            pop_time += (k - cnt) * ground_dict[cnt]

    time = stack_time*2 + pop_time
    if time <= min_time:
        min_time = time
        max_floor = k


print(min_time, max_floor)
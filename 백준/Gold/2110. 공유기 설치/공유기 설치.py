import sys

N, C = map(int, sys.stdin.readline().split())
home_list = [int(sys.stdin.readline()) for i in range(N)]
home_list = sorted(home_list)

start = 0
end = max(home_list)

result = 0
while (start <= end):
    start_spot = min(home_list)
    gap = (start + end) // 2

    cnt = 0
    for y in range(N):
        if start_spot + gap <= home_list[y]:
            start_spot = home_list[y]
            cnt += 1

    if cnt < (C - 1):
        end = gap - 1
    else:
        result = gap
        start = gap + 1
        

print(result)
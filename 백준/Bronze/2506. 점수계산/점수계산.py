N = int(input()) # 문제의 개수 N
cnt = 0
bonus = 0


ox_list = list(map(int, input().split()))
for j in ox_list:
    if j == 1:
        cnt += 1 + bonus
        bonus += 1
    else:
        bonus = 0

print(cnt)
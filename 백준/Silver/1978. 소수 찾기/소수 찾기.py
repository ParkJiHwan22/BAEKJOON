T = int(input())
n = list(map(int, input().split()))
cnt = T

for i in n:
    if i == 1:
        cnt -= 1
    elif i == 2:
        continue
    for j in range(2, i):
            if i % j == 0:
                cnt -= 1
                break

print(cnt)
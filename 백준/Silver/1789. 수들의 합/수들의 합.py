S = int(input())
cnt = 0
sum = 0

while True:
    if S >= sum:
        cnt += 1
        sum += cnt
    else:
        break

print(cnt-1)
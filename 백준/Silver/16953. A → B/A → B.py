a, b = map(int, input().split())

cnt = 1
while a != b and b >= 1:
    if b % 10 == 1:
        b = b // 10
        cnt += 1
    elif b % 2 == 0:
        b = b // 2
        cnt += 1
    else:
        break

if a == b:
    print(cnt)
else:
    print(-1)
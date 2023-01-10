N = int(input())
cnt = 0

for i in range(1, N+1):
    if i >= 100:
        a = i // 100
        b = i // 10 - a * 10
        c = i % 10
        if a - b == b - c or a == b == c:
            cnt += 1

    else:
        cnt += 1

print(cnt)
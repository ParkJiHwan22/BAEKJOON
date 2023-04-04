n, a, b = map(int, input().split())
cnt = 0

while True:
    cnt += 1
    if min(a, b) % 2 == 1:
        if abs(a-b) == 1:
            break

    if a % 2 == 1:
        a = (a + 1) // 2
    else:
        a = a // 2

    if b % 2 == 1:
        b = (b + 1) // 2
    else:
        b = b // 2

print(cnt)
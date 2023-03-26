N = int(input())
res = [input() for _ in range(N)]
X, Y = 0, 0

for i in res:
    if i == 'D':
        X += 1
    else:
        Y += 1

    if abs(X - Y) >= 2:
        break

print(f'{X}:{Y}')
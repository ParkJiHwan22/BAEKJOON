x, y = map(int, input().split())
k = y*100 // x
t = 0

if k >= 99:
    print(-1)
else:
    while True:
        t += 1
        z = (y + t)*100 // (x + t)
        if k != z:
            break

    print(t)
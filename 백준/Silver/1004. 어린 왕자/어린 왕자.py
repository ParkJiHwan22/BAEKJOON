T = int(input())

for i in range(T):
    cnt = 0
    x1, y1, x2, y2 = map(int, input().split())
    circle = int(input())
    for _ in range(circle):
        x, y, r = map(int, input().split())
        length_1 = ((x1 - x)**2 + (y1 - y)**2)**0.5
        length_2 = ((x2 - x)**2 + (y2 - y)**2)**0.5
        if length_1 < r < length_2:
            cnt += 1
        elif length_2 < r < length_1:
            cnt += 1

    print(cnt)
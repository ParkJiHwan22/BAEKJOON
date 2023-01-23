T = int(input())

for i in range(T):
    mars = list(input().split())

    cnt = 0
    while True:
        if mars == []:
            print("{:.2f}".format(cnt))
            break
        elif mars[0] == '@':
            cnt *= 3
            mars.pop(0)
        elif mars[0] == '%':
            cnt += 5
            mars.pop(0)
        elif mars[0] == '#':
            cnt -= 7
            mars.pop(0)
        else:
            cnt += float(mars[0])
            mars.pop(0)
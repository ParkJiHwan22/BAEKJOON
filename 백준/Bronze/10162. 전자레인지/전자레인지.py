T = int(input())

a = T // 300
b = (T % 300) // 60
c = ((T % 300) % 60) // 10

if ((T % 300) % 60) % 10 != 0:
    print(-1)
else:
    print(a, b, c)
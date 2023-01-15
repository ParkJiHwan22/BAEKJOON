T = int(input())
k = 0


for i in range(T):

    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    l = ((x1-x2)**2+(y1-y2)**2)**0.5
    if l == 0 and r1 == r2:
        print(-1)
    elif l > abs(r1 + r2):
        print(0)
    elif l == abs(r1 + r2):
        print(1)
    elif l > abs(r2 - r1):
        print(2)
    elif l == abs(r2 - r1):
        print(1)
    elif l < abs(r2 - r1):
        print(0)
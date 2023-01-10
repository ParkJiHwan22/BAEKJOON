T = int(input())
for i in range(T):
    H, W, N = map(int, input().split())
    x = N % H
    y = N // H + 1

    if x == 0:
        x = H
        y -= 1
    
    if y < 10:
        y = '0' + str(y)
    else:
        y = str(y)

    print(str(x)+y)
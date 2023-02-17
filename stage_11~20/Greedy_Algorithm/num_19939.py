n, k = map(int, input().split())

tmp = sum([i for i in range(1, k+1)])

if n >= tmp:
    if (n - tmp) % k == 0:
        print(k - 1)
    else:
        print(k) 
else:
    print(-1) 
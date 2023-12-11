n, x = map(int, input().split())
lst = list(map(int, input().split()))

if sum(lst) % x == 0:
    print(1)
else:
    print(0)
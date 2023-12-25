import sys
input =sys.stdin.readline

n, m = map(int, input().split())
egg_price = [int(input()) for _ in range(m)]
egg_price = sorted(egg_price)

res = 0
egg_weight = 0
for idx, num in enumerate(egg_price):
    if res < min(m - idx, n) * num:
        res = min(m - idx, n) * num
        egg_weight = num
        
print(egg_weight, res)
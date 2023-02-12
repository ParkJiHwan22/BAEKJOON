n, k = map(int, input().split())
coin = [int(input()) for _ in range(n)]
coin = sorted(coin, reverse = True)
res = 0
for i in range(n):
    if k >= coin[i]:
        res += k // coin[i]
        k = k % coin[i]

print(res)
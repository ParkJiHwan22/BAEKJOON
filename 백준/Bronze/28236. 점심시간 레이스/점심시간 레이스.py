n, m, k = map(int, input().split())
d = n + m

for i in range(1, k+1):
    a, b = map(int, input().split())
    if (a - 1) + (m - b) < d:
        ans = i
        d = (a - 1) + (m - b)

print(ans)
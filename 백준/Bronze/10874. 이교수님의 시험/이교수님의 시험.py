n = int(input())
arr = [[] for _ in range(n)]
res = []
for i in range(n):
    arr[i] = list(map(int, input().split()))

for i in range(n):
    ans = 0
    for j in range(10):
        if arr[i][j] == (j % 5) +1: 
            ans += 1

    if ans == 10:
        res.append(i+1)

print(*res, sep="\n")
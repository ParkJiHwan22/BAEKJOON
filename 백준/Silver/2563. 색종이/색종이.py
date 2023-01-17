T = int(input())
arr = [[0 for _ in range(101)]for _ in range(101)]

for _ in range(T):
    x, y = map(int, input().split())
    for i in range(x, x+10):
        for j in range(y, y+10):
            arr[i][j] = 1

cnt = 0
for row in arr:
    cnt += row.count(1)
print(cnt)
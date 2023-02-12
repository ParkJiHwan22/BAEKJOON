import sys

n, k = map(int, sys.stdin.readline().split())
start = list(map(int, sys.stdin.readline().split()))
end = list(map(int, sys.stdin.readline().split()))
cnt = 0

for i in range(n):
    while start[i] < end[i]:
        cnt += 1
        for j in range(k):
            start[i + j] += k
            if i + j == n -1:
                break

print(cnt)

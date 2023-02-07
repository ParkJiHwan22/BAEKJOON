import sys

n = int(sys.stdin.readline())
h = [int(sys.stdin.readline()) for _ in range(n)]
i_max = cnt = 0

for i in h[::-1]:
    if i_max < i:
        i_max = i
        cnt += 1

print(cnt)
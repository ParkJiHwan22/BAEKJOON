import sys

T = int(sys.stdin.readline())
for _ in range(T):
    n = int(sys.stdin.readline())
    rank = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(n)]

   
    rank = sorted(rank)
    cutline = 100001
    cnt = 0

    for i in range(n):
        if rank[i][1] < cutline:
            cutline = rank[i][1]
            cnt += 1

    print(cnt)
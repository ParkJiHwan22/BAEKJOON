import sys

n, m = map(int, sys.stdin.readline().split())
r = [int(sys.stdin.readline()) for _ in range(n-1)]
c = list(map(int, sys.stdin.readline().split()))
r.append(c[0])

print(r.index(min(r))+1, c.index(min(c))+1)
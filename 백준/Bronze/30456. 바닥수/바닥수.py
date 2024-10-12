import sys
input = sys.stdin.readline

N, L = map(int, input().split())

for i in range(L - 1):
    print(1, end="")

print(N)
import sys

N, M = map(int, sys.stdin.readline().split())
num_list = list(map(int, sys.stdin.readline().split()))

dp = [0] * (N+1)
for j in range(1, N+1):
    dp[j] = dp[j-1] + num_list[j-1] # 합 구하기

for i in range(M):
    a, b = map(int, sys.stdin.readline().split())
    print(dp[b] - dp[a-1])
import sys

N, K = map(int, sys.stdin.readline().split())
temp = list(map(int, sys.stdin.readline().split()))

dp = [0] * (N-K+1)

dp[0] = sum(temp[0:K])
for i in range(1, N-K+1):
    dp[i] = dp[i-1] + temp[K+i-1] - temp[i-1]

print(max(dp))
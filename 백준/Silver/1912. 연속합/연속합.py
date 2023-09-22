import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split()))
dp = [0 for _ in range(n+1)]

for i in range(n):
    dp[i+1] = max(dp[i] + lst[i], lst[i])
    
print(max(dp[1:]))
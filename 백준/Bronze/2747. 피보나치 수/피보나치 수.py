n = int(input())
dp = [1] * n

if n <= 2:
    print(1)
    
else:
    for i in range(2, n):
        dp[i] = dp[i-1] + dp[i-2]
        
    print(dp[-1])
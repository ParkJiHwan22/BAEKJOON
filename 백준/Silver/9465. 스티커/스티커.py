import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    sticker = [list(map(int, input().split())) for _ in range(2)]
    dp = [[0, 0, 0] for _ in range(n+1)]

    for i in range(n):
        dp[i+1][0] = max(dp[i][1] + sticker[0][i], dp[i][2] + sticker[0][i])
        dp[i+1][1] = max(dp[i][0] + sticker[1][i], dp[i][2] + sticker[1][i])
        dp[i+1][2] = max(dp[i])

    print(max(dp[-1]))
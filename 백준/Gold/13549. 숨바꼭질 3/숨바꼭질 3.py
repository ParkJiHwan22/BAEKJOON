from collections import deque

n, k = map(int, input().split())

if n >= k: # 수빈이가 동생 앞에 있을 떄
    print(n - k)

else:
    MAX = 100001
    q = deque()
    q.append(n)
    dp = [-1 for _ in range(MAX)]
    dp[n] = 0

    while q:
        x = q.popleft()
        if x == k:
            print(dp[x])
            break
        
        if 0 <= x - 1 < MAX and dp[x - 1] == -1:
            dp[x - 1] = dp[x] + 1
            q.append(x - 1)
            
        if 0 < x * 2 < MAX and dp[x * 2] == -1:
            dp[x * 2] = dp[x]            
            q.appendleft(x * 2)
            
        if x + 1 < MAX and dp[x + 1] == -1:
            dp[x + 1] = dp[x] + 1
            q.append(x + 1)
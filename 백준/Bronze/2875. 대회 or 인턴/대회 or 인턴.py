n, m, k = map(int, input().split())
team = 0

while n >= 2 and m >= 1:
    n -= 2
    m -= 1
    team += 1    
    
if n + m < k:
    print(team - ((k - (n + m + 1)) // 3) - 1)
else:
    print(team)   
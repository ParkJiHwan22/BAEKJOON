import sys
input = sys.stdin.readline
n = int(input())

# 교차한다는 것 = a[n]의 값은 a[n+1]의 값보다 무조건 작아야 한다.
arr = [0] * (501)
dp = [1] * (501)

for i in range(n):
    a, b = map(int, input().split())
    
    arr[a] = b
    
for i in range(len(arr)):
    if arr[i] != 0:
        for j in range(0, i):
            if arr[j] != 0:
                if arr[j] < arr[i] and dp[j] >= dp[i]:
                    dp[i] = dp[j] + 1


print(n - max(dp))
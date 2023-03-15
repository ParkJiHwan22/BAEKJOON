# n = int(input())

# a = 1
# b = 2

# if n == 1:
#     print(1)
# elif n == 2:
#     print(2)
# else:    
#     for i in range(n-2):
#         c = a + b
#         a = b
#         b = c
    
#     print(c%10007)
        
#===========================================

import sys

N = int(sys.stdin.readline().rstrip())

dp = [1, 2]
def fib(n):
    if n == 1 or n == 2:
        return dp[n - 1]
    for _ in range(2, N):
        dp.append((dp[-1] + dp[-2]) % 10007)
    return dp[-1]

print(fib(N))
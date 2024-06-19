import sys

def new_factorial(n):
    ans = 1
    for i in range(1, n + 1):
        ans *= i
        ans %= 1000000000000
        while ans % 10 == 0:
            ans //= 10
    return int(ans % 10)

t = int(sys.stdin.readline())
for _ in range(t):
    n = int(sys.stdin.readline())
    print(new_factorial(n))
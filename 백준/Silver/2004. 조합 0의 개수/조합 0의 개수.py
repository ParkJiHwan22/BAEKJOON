import sys

n, m = map(int, sys.stdin.readline().split())
two_factorial = 0
five_factorial = 0


for i in range(1,31): # 2**30 = 1,073,741,824
    if n >= 2**i:
        two_factorial += (n // (2**i)) - (((n-m) // (2**i)) + (m // (2**i)))
    else:
        pass
for i in range(1,14): # 5**13 = 1,220,703,125
    if n >= 5**i:
        five_factorial += (n // (5**i)) - (((n-m) // (5**i)) + (m // (5**i)))
    else:
        pass

print(min(two_factorial, five_factorial))
import math

A, B, C = map(int, input().split())

if B == C:
    print(-1)

else:
    n = math.floor(A/(C-B)) + 1

    if n > 0:
        print(n)

    else:
        print(-1)
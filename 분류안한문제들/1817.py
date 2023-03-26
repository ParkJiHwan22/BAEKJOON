import sys

n, m = map(int, sys.stdin.readline().split())
if n == 0:
    print(0)
else:
    num_list = list(map(int, sys.stdin.readline().split()))

    box, total = 0, 1
    for i in range(n-1, -1, -1):
        box += num_list[i]
        if box > m:
            total += 1
            box = num_list[i]
             
    print(total)
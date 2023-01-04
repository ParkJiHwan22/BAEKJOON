import sys

T = int(sys.stdin.readline())
lst = []

for i in range(T):
    A, B = map(int, sys.stdin.readline().split())
    lst += {A + B}

for i in lst:
    print(i)

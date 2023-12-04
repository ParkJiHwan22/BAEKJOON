import sys
input = sys.stdin.readline

s = ""
for i in range(1, 100001):
    s += str(i)

print(s.index(input().rstrip())+1)
import sys
input = sys.stdin.readline

n = int(input())
lst = [0] * 3

for _ in range(n):
    r, g, b = map(int, input().split())
    if lst[0] == 0:
        lst[0] = r
        lst[1] = g
        lst[2] = b
    else:
        red = min(lst[1] + r, lst[2] + r)
        green = min(lst[0] + g, lst[2] + g)
        blue = min(lst[0] + b, lst[1] + b)

        lst[0] = red
        lst[1] = green
        lst[2] = blue
        
print(min(lst))
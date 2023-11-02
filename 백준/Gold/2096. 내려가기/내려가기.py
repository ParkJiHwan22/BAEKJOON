import sys
input = sys.stdin.readline

n = int(input())

a1, b1, c1 = map(int, input().split())

a_min = a1
a_max = a1

b_min = b1
b_max = b1

c_min = c1
c_max = c1

res = [[a1, b1, c1], [a1, b1, c1]]

for _ in range(n - 1):
    a, b, c = map(int, input().split())
    res[0][0] = max(a_max + a, b_max + a)
    res[1][0] = min(a_min + a, b_min + a)
    res[0][1] = max(a_max + b, b_max + b, c_max + b)
    res[1][1] = min(a_min + b, b_min + b, c_min + b)
    res[0][2] = max(b_max + c, c_max + c)
    res[1][2] = min(b_min + c, c_min + c)

    a_max = res[0][0]
    a_min = res[1][0]
    b_max = res[0][1]
    b_min = res[1][1]
    c_max = res[0][2]
    c_min = res[1][2]

print(max(res[0]), min(res[1]))
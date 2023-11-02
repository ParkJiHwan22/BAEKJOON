import sys
input = sys.stdin.readline

n = int(input())

tmp = list(map(int,input().split()))
dp_1 = tmp
dp_2 = tmp

for _ in range(n - 1):
    a, b, c = map(int, input().split())
    dp_1 = [a + max(dp_1[0], dp_1[1]), b + max(dp_1[0], dp_1[1], dp_1[2]), c + max(dp_1[1], dp_1[2])]
    dp_2 = [a + min(dp_2[0], dp_2[1]), b + min(dp_2[0], dp_2[1], dp_2[2]), c + min(dp_2[1], dp_2[2])]

print(max(dp_1), min(dp_2))
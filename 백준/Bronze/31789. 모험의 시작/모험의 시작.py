N = int(input())
X, S = map(int, input().split())

M = 0
for i in range(N):
    a, b = map(int, input().split())
    if X >= a:
        M = max(M, b)

if M > S:
    print('YES')
else:
    print('NO')
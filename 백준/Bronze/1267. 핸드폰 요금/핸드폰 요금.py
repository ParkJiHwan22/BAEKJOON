n = int(input())
fee = list(map(int, input().split()))
Y, M = 0, 0

for i in range(n):
    Y += ((fee[i] // 30) + 1) * 10
    M += ((fee[i] // 60) + 1) * 15

if Y > M:
    print('M', M)
elif Y == M:
    print('Y', 'M', M)
else:
    print('Y', Y)
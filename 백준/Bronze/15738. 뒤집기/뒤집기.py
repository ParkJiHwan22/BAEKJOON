N, K, M = map(int, input().split())
A = list(map(int, input().split()))
K -= 1

for _ in range(M):
    i = int(input())
    if i > 0:
        if K < i:
            K = i - K - 1
    else:
        i = -i
        if K >= N - i:
            K = N - (K - (N - i)) - 1

print(K + 1)
result = 1
N, K = map(int, input().split())
for i in range(1, K+1):
    result *= (N - i + 1 )/i

print(int(result))
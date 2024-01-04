n = int(input())
ans = 5

for i in range(1, n):
    ans += 3*i + 4

print(ans % 45678)
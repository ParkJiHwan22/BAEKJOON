N, b = input().split()
arr = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

N = N[::-1]
result = 0

for i,n in enumerate(N):
    result += (int(b)**i)*(arr.index(n))
print(result)
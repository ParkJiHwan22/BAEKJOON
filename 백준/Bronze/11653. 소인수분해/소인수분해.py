N = int(input())
num = N
lst = []

for i in range(2,N+1):
    while num % i == 0:
        num = num / i
        lst.append(i)

print(*lst, sep='\n')